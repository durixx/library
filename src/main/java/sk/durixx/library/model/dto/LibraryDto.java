package sk.durixx.library.model.dto;

import sk.durixx.library.model.entity.Library;

public class LibraryDto {

    private long id;
    private String nameOfLibrary;
    private String country;
    private String city;
    private String address;

    public LibraryDto() {

    }

    private LibraryDto(Builder builder) {
        this.id = builder.id;
        this.nameOfLibrary = builder.nameOfLibrary;
        this.address = builder.address;
        this.city = builder.city;
        this.country = builder.country;
    }

    public static LibraryDto fromLibrary(Library library) {
        return new LibraryDto.Builder().withId(library.getId())
                .withNameOfLibrary(library.getNameOfLibrary())
                .withAddress(library.getAddress())
                .withCountry(library.getCountry())
                .withCity(library.getCity())
                .withId(library.getId())
                .build();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfLibrary() {
        return nameOfLibrary;
    }

    public void setNameOfLibrary(String nameOfLibrary) {
        this.nameOfLibrary = nameOfLibrary;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    private static class Builder {

        private long id;
        private String nameOfLibrary;
        private String country;
        private String city;
        private String address;

        public LibraryDto.Builder withId(Long id) {
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

        public LibraryDto build() {
            return new LibraryDto(this);
        }

    }
}
