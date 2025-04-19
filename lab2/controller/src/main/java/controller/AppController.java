package controller;

import entities.Cat;
import entities.Color;
import entities.Owner;
import org.hibernate.Hibernate;
import serviceinterface.CatService;
import serviceinterface.OwnerService;

import java.time.OffsetDateTime;
import java.util.List;

public class AppController {
    private final CatService catService;
    private final OwnerService ownerService;

    public AppController(CatService catService, OwnerService ownerService) {
        this.catService = catService;
        this.ownerService = ownerService;
    }

    public Owner createOwner(String name, OffsetDateTime birthday) {
        return ownerService.createOwner(name, birthday);
    }

    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    public void deleteOwnerById(Long id) {
        ownerService.deleteOwnerById(id);
    }

    public Cat createCat(String name, OffsetDateTime birthday, String breed, Color color, Owner owner) {
        return catService.createCat(name, birthday, breed, color, owner);
    }

    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    public void deleteCatById(Long id) {
        Cat cat = catService.getCatById(id);
        catService.deleteCat(cat);
    }

    public void letsBeFriends(Cat cat, Cat friend) {
        // Получаем свежие сущности из базы, потому что старые могут быть detached
        Cat freshCat = catService.getCatById(cat.getId());
        Cat freshFriend = catService.getCatById(friend.getId());

        // Инициализируем коллекцию дружб, чтобы избежать LazyInitializationException
        Hibernate.initialize(freshCat.getFriendship());

        if (!freshCat.getFriendship().contains(freshFriend)) {
            freshCat.addFriend(freshFriend);
            catService.updateCats(freshCat);
        } else {
            System.out.println(freshCat.getName() + " и " + freshFriend.getName() + " уже друзья 😸");
        }
    }



}