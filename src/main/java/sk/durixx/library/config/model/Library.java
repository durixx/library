package sk.durixx.library.config.model;

import jakarta.persistence.*;

@Entity
@Table(name = "library")
public class Library {

    @Id
    @SequenceGenerator(
            name = "id_sequence",
            sequenceName = "id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_sequence"
    )
    private long id;

    @Column(
            name = "name_of_library",
            updatable = false
    )
    private String nameOfLibrary;

    @Column(
            name = "country",
            updatable = false
    )
    private String country;

    @Column(
            name = "city",
            updatable = false
    )
    private String city;

    @Column(
            name = "adress",
            updatable = false
    )
    private String address;

    public Library(String nameOfLibrary, String country, String city, String address) {
        this.nameOfLibrary = nameOfLibrary;
        this.country = country;
        this.city = city;
        this.address = address;
    }
}
