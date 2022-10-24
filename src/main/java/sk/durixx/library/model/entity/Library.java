package sk.durixx.library.model.entity;

import jakarta.persistence.*;
import sk.durixx.library.model.dto.LibraryDto;

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

    public Library() {
    }

    public long getId() {
        return id;
    }

    public String getNameOfLibrary() {
        return nameOfLibrary;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Library(String nameOfLibrary, String country, String city, String address) {
        this.nameOfLibrary = nameOfLibrary;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public static Library fromDto(LibraryDto dto) {
        return new Library(
                dto.getNameOfLibrary(),
                dto.getCountry(),
                dto.getCity(),
                dto.getAddress()
        );
    }
}
