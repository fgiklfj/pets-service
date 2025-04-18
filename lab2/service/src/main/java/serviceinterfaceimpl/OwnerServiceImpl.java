package serviceinterfaceimpl;

import daointerface.DAO;
import entities.Owner;
import serviceinterface.OwnerService;

import java.time.OffsetDateTime;
import java.util.List;

public class OwnerServiceImpl implements OwnerService {
    private final DAO<Owner> ownerDao;

    public OwnerServiceImpl(DAO<Owner> ownerDao) {
        this.ownerDao = ownerDao;
    }

    @Override
    public Owner createOwner(String name, OffsetDateTime dateOfBirth) {
        Owner owner = new Owner(name, dateOfBirth);
        ownerDao.save(owner);
        return owner;
    }

    @Override
    public Owner getOwnerById(Long id) {
        return ownerDao.getById(id);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerDao.getAll();
    }

    @Override
    public Owner updateOwner(Owner owner) {
        return ownerDao.update(owner);
    }

    @Override
    public void deleteOwner(Owner owner) {
        ownerDao.deleteByEntity(owner);
    }

    @Override
    public void deleteAllOwners() {
        ownerDao.deleteAll();
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerDao.deleteById(id);
    }
}
