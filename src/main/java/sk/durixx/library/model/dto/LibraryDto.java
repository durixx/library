package sk.durixx.library.model.dto;

public class LibraryDto {

    private long id;
    private String nameOfLibrary;
    private String country;
    private String city;
    private String address;

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

    public LibraryDto() {
    }

    public LibraryDto(String nameOfLibrary, String country, String city, String address) {
        this.nameOfLibrary = nameOfLibrary;
        this.country = country;
        this.city = city;
        this.address = address;
    }
}
