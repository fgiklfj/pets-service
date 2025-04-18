package service;

import daointerface.DAO;
import entities.Cat;
import entities.Color;
import entities.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import serviceinterfaceimpl.CatServiceImpl;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CatServiceTest {
    private DAO<Cat> catDao;
    private CatServiceImpl catService;

    @BeforeEach
    void setUp() {
        catDao = mock(DAO.class);
        catService = new CatServiceImpl(catDao);
    }

    @Test
    void createCat_ShouldSaveAndReturnCat() {
        Owner owner = new Owner(); // или замоканный, если нужно
        OffsetDateTime dob = OffsetDateTime.now();
        Cat expectedCat = new Cat("Barsik", dob, "Siberian", Color.BLACK, owner);

        // захватываем объект, чтобы убедиться, что его передали в save
        ArgumentCaptor<Cat> catCaptor = ArgumentCaptor.forClass(Cat.class);
        when(catDao.save(any(Cat.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Cat created = catService.createCat("Barsik", dob, "Siberian", Color.BLACK, owner);

        verify(catDao).save(catCaptor.capture());
        Cat savedCat = catCaptor.getValue();

        assertEquals("Barsik", savedCat.getName());
        assertEquals(dob, savedCat.getDateOfBirth());
        assertEquals(Color.BLACK, savedCat.getColor());
        assertSame(owner, savedCat.getOwner());
        assertEquals(expectedCat.getName(), created.getName());
    }

    @Test
    void getCatById_ShouldReturnCat() {
        Cat cat = new Cat();
        cat.setId(1L);
        when(catDao.getById(1L)).thenReturn(cat);

        Cat result = catService.getCatById(1L);

        assertEquals(1L, result.getId());
        verify(catDao).getById(1L);
    }

    @Test
    void getAllCats_ShouldReturnListOfCats() {
        List<Cat> cats = Arrays.asList(new Cat(), new Cat());
        when(catDao.getAll()).thenReturn(cats);

        List<Cat> result = catService.getAllCats();

        assertEquals(2, result.size());
        verify(catDao).getAll();
    }

    @Test
    void updateCats_ShouldUpdateAndReturnCat() {
        Cat cat = new Cat();
        cat.setName("Tom");

        when(catDao.update(cat)).thenReturn(cat);

        Cat updated = catService.updateCats(cat);

        assertEquals("Tom", updated.getName());
        verify(catDao).update(cat);
    }

    @Test
    void deleteCat_ShouldCallDaoDelete() {
        Cat cat = new Cat();
        catService.deleteCat(cat);

        verify(catDao).deleteByEntity(cat);
    }

    @Test
    void deleteAllCats_ShouldCallDaoDeleteAll() {
        catService.deleteAllCats();

        verify(catDao).deleteAll();
    }

    @Test
    void addFriends_ShouldAddFriendAndUpdateCat() {
        Cat cat1 = new Cat();
        cat1.setId(1L);
        Cat cat2 = new Cat();
        cat2.setId(2L);

        catService.addFriends(cat1, cat2);

        assertTrue(cat1.getFriendship().contains(cat2));
        verify(catDao).update(cat1);
    }

    @Test
    void addFriends_ShouldNotDuplicateFriend() {
        Cat cat1 = new Cat();
        cat1.setId(1L);
        Cat cat2 = new Cat();
        cat2.setId(2L);

        cat1.setFriendship(Set.of(cat2));
        cat2.setFriendship(Set.of(cat1));

        catService.addFriends(cat1, cat2);

        verify(catDao, never()).update(any());
    }
}
