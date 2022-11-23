package sk.durixx.library.model.dto;


import sk.durixx.library.model.entity.Book;

public class BookDto {

    private Long id;
    private String name;
    private String author;
    private int yearOfRelease;
    private String description;
    private Long isbn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public BookDto() {
    }

    public BookDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.author = builder.author;
        this.yearOfRelease = builder.yearOfRelease;
        this.description = builder.description;
        this.isbn = builder.isbn;
    }

    public static BookDto fromBook(Book book) {
        return new Builder().withId(book.getId())
                .withName(book.getName())
                .withAuthor(book.getAuthor())
                .withYearOfRelease(book.getYearOfRelease())
                .withDescription(book.getDescription())
                .withIsbn(book.getIsbn())
                .build();
    }

    private static class Builder {

        private Long id;
        private String name;
        private String author;
        private int yearOfRelease;
        private String description;
        private Long isbn;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder withYearOfRelease(int yearOfRelease) {
            this.yearOfRelease = yearOfRelease;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withIsbn(Long isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookDto build() {
            return new BookDto(this);
        }

    }
}