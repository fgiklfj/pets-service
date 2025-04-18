package daointerface;

import Utils.HibernateUtil;
import entities.Owner;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OwnerDAOImpl<T> implements DAO<Owner> {
    @Override
    public Owner save(Owner owner) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.persist(owner);
            trans.commit();
            return owner;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Owner owner = session.get(Owner.class, id);

            if (owner != null)
                session.remove(owner);
            trans.commit();
        }

    }

    @Override
    public void deleteByEntity(Owner owner) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.remove(owner);
            trans.commit();
        }
    }

    @Override
    public void deleteAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.createNativeQuery("TRUNCATE FROM Owner").executeUpdate();
            trans.commit();
        }
    }

    @Override
    public Owner update(Owner owner) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.beginTransaction();

            Owner updated = session.merge(owner);

            trans.commit();

            return updated;
        }
    }

    @Override
    public Owner getById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Owner.class, id);
        }
    }

    @Override
    public List<Owner> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Owner", Owner.class).list();
        }
    }
}
