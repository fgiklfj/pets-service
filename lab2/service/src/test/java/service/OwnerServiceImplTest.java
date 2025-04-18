package service;

import daointerface.DAO;
import entities.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import serviceinterfaceimpl.OwnerServiceImpl;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerServiceImplTest {

    private DAO<Owner> ownerDao;
    private OwnerServiceImpl ownerService;

    @BeforeEach
    void setUp() {
        ownerDao = mock(DAO.class);
        ownerService = new OwnerServiceImpl(ownerDao);
    }

    @Test
    void createOwner_ShouldSaveAndReturnOwner() {
        OffsetDateTime dob = OffsetDateTime.now();
        String name = "Nastya";

        when(ownerDao.save(any(Owner.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Owner owner = ownerService.createOwner(name, dob);

        assertEquals(name, owner.getName());
        assertEquals(dob, owner.getDateOfBirth());
        verify(ownerDao).save(any(Owner.class));
    }

    @Test
    void getOwnerById_ShouldReturnOwner() {
        Owner owner = new Owner();
        owner.setId(1L);
        when(ownerDao.getById(1L)).thenReturn(owner);

        Owner result = ownerService.getOwnerById(1L);

        assertEquals(1L, result.getId());
        verify(ownerDao).getById(1L);
    }

    @Test
    void getAllOwners_ShouldReturnList() {
        List<Owner> owners = Arrays.asList(new Owner(), new Owner());
        when(ownerDao.getAll()).thenReturn(owners);

        List<Owner> result = ownerService.getAllOwners();

        assertEquals(2, result.size());
        verify(ownerDao).getAll();
    }

    @Test
    void updateOwner_ShouldCallDaoUpdate() {
        Owner owner = new Owner();
        owner.setName("Updated");

        when(ownerDao.update(owner)).thenReturn(owner);

        Owner updated = ownerService.updateOwner(owner);

        assertEquals("Updated", updated.getName());
        verify(ownerDao).update(owner);
    }

    @Test
    void deleteOwner_ShouldCallDaoDeleteByEntity() {
        Owner owner = new Owner();
        ownerService.deleteOwner(owner);

        verify(ownerDao).deleteByEntity(owner);
    }

    @Test
    void deleteAllOwners_ShouldCallDaoDeleteAll() {
        ownerService.deleteAllOwners();

        verify(ownerDao).deleteAll();
    }

    @Test
    void deleteOwnerById_ShouldCallDaoDeleteById() {
        ownerService.deleteOwnerById(42L);

        verify(ownerDao).deleteById(42L);
    }
}
