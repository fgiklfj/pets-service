package serviceinterface;

import entities.Cat;
import entities.Color;
import entities.Owner;

import java.time.OffsetDateTime;
import java.util.List;

public interface CatService {
    public Cat createCat(String name, OffsetDateTime dateOfBirth, String breed, Color color, Owner owner);

    public Cat getCatById(Long id);

    public List<Cat> getAllCats();

    public Cat updateCats(Cat cat);

    public void deleteCat(Cat cat);

    public void deleteAllCats();

    public void addFriends(Cat cat, Cat friend);
}
