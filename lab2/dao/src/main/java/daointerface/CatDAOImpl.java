package daointerface;

import entities.Cat;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class CatDAOImpl<T> implements DAO<Cat> {
    @Override
    public Cat save(Cat cat) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.persist(cat);
            trans.commit();
            return cat;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Cat cat = session.get(Cat.class, id);

            if (cat != null)
                session.remove(cat);
            trans.commit();
        }

    }

    @Override
    public void deleteByEntity(Cat cat) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.remove(cat);
            trans.commit();
        }
    }

    @Override
    public void deleteAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.createNativeQuery("TRUNCATE Cat").executeUpdate();
            trans.commit();
        }
    }

    @Override
    public Cat update(Cat cat) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.beginTransaction();

            Cat updated = session.merge(cat);

            trans.commit();

            return updated;
        }
    }

    @Override
    public Cat getById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Cat.class, id);
        }
    }

    @Override
    public List<Cat> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("""
            SELECT DISTINCT c
            FROM Cat c
            LEFT JOIN FETCH c.friendship
            LEFT JOIN FETCH c.owner
        """, Cat.class).getResultList();
        }
    }
}
