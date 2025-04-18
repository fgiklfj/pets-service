package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long id;

    @Column(name = "cat_name", nullable = false)
    private String name;


    @Column(name = "date_of_birth", nullable = false)
    private OffsetDateTime dateOfBirth;


    @Column(name = "breed")
    private String breed;

    @Enumerated(EnumType.STRING)
    @Column(name = "color", nullable = false, length = 20)
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cats_friendship", joinColumns = @JoinColumn(name = "cat_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<Cat> friendship = new HashSet<>();

    @ManyToMany(mappedBy = "friendship")
    private Set<Cat> friendsOf = new HashSet<>();

    public Cat(String name, OffsetDateTime dateOfBirth, String breed, Color color, Owner owner) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
        this.color = color;
        this.owner = owner;
    }

    public void addFriend(Cat friend) {
        if (!this.friendship.contains(friend)) {
            this.friendship.add(friend);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat cat)) return false;
        if (id == null || cat.id == null) return false;
        return id.equals(cat.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}