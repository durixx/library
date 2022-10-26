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
            nullable = false
    )
    private String nameOfLibrary;

    @Column(
            name = "country",
            nullable = false
    )
    private String country;

    @Column(
            name = "city",
            nullable = false
    )
    private String city;

    @Column(
            name = "address",
            nullable = false
    )
    private String address;


    public Library() {
    }

    public Library(Builder builder) {
        this.id = builder.id;
        this.nameOfLibrary = builder.nameOfLibrary;
        this.address = builder.address;
        this.city = builder.city;
        this.country = builder.country;
    }

    public static Library fromDto(LibraryDto dto) {
        return new Builder().withId(dto.getId())
                .withNameOfLibrary(dto.getNameOfLibrary())
                .withAddress(dto.getAddress())
                .withCountry(dto.getCountry())
                .withCity(dto.getCity())
                .build();
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

    private static class Builder {

        private long id;
        private String nameOfLibrary;
        private String country;
        private String city;
        private String address;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withNameOfLibrary(String nameOfLibrary) {
            this.nameOfLibrary = nameOfLibrary;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Library build() {
            return new Library(this);
        }

    }
}
