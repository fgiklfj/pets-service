package serviceinterface;

import entities.Owner;

import java.time.OffsetDateTime;
import java.util.List;

public interface OwnerService {
    public Owner createOwner(String name, OffsetDateTime dateOfBirth);

    public Owner getOwnerById(Long id);

    public List<Owner> getAllOwners();

    public Owner updateOwner(Owner owner);

    public void deleteOwner(Owner owner);

    public void deleteAllOwners();

    public void deleteOwnerById(Long id);
}
