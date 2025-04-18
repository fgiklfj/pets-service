package org.example;

import controller.AppController;
import daointerface.CatDAOImpl;
import daointerface.DAO;
import daointerface.OwnerDAOImpl;
import entities.Cat;
import entities.Color;
import entities.Owner;
import serviceinterface.CatService;
import serviceinterface.OwnerService;
import serviceinterfaceimpl.CatServiceImpl;
import serviceinterfaceimpl.OwnerServiceImpl;

import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("starting cats friendship");

        DAO<Cat> catDao = new CatDAOImpl();
        DAO<Owner> ownerDAO = new OwnerDAOImpl();

        CatService catService = new CatServiceImpl(catDao);
        OwnerService ownerService = new OwnerServiceImpl(ownerDAO);

        AppController controller = new AppController(catService, ownerService);

        Owner nastya = controller.createOwner("настя", OffsetDateTime.parse("2005-10-18T00:00:00Z"));
        Owner katya = controller.createOwner("катя", OffsetDateTime.parse("2005-03-31T00:00:00Z"));
        Owner misha = controller.createOwner("миша", OffsetDateTime.parse("2004-11-11T00:00:00Z"));
        Owner lenya = controller.createOwner("леня", OffsetDateTime.parse("2005-02-05T00:00:00Z"));

        Cat tasya = controller.createCat("тася", OffsetDateTime.now(), "невская-маскарадная", Color.GRAY, nastya);
        Cat senya = controller.createCat("сеня", OffsetDateTime.now(), "ангорская", Color.WHITE, nastya);


        Cat redghi = controller.createCat("реджи", OffsetDateTime.now(), "собака", Color.WHITE, katya);

        Cat petya = controller.createCat("петя", OffsetDateTime.now(), "американский бобтейл", Color.BLACK, misha);
        Cat peach = controller.createCat("пич", OffsetDateTime.now(), "собака", Color.PINK, misha);

        Cat lina = controller.createCat("лина", OffsetDateTime.now(), "собака", Color.WHITE, lenya);

        controller.letsBeFriends(tasya, senya);
        controller.letsBeFriends(tasya, petya);

        controller.letsBeFriends(redghi, peach);
        controller.letsBeFriends(redghi, lina);

        System.out.println("congratulations!");

    }
}
