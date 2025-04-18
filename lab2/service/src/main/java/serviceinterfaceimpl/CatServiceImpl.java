package serviceinterfaceimpl;

import daointerface.DAO;
import entities.Cat;
import entities.Color;
import entities.Owner;
import serviceinterface.CatService;

import java.time.OffsetDateTime;
import java.util.List;

public class CatServiceImpl implements CatService {

    private final DAO<Cat> catDao;

    public CatServiceImpl(DAO<Cat> catDao) {
        this.catDao = catDao;
    }

    @Override
    public Cat createCat(String name, OffsetDateTime dateOfBirth, String breed, Color color, Owner owner) {
        Cat cat = new Cat(name, dateOfBirth, breed, color, owner);
        catDao.save(cat);
        return cat;
    }

    @Override
    public Cat getCatById(Long id) {
        return catDao.getById(id);
    }

    @Override
    public List<Cat> getAllCats() {
        return catDao.getAll();
    }

    @Override
    public Cat updateCats(Cat cat) {
        return catDao.update(cat);
    }

    @Override
    public void deleteCat(Cat cat) {
        catDao.deleteByEntity(cat);
    }

    @Override
    public void deleteAllCats() {
        catDao.deleteAll();
    }

    @Override
    public void addFriends(Cat cat, Cat friend) {
        if (!cat.getFriendship().contains(friend) && !friend.getFriendship().contains(cat)) {
            cat.addFriend(friend);
            catDao.update(cat);
        }
    }
}
