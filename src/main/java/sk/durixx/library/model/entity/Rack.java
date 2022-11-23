package sk.durixx.library.model.entity;

import jakarta.persistence.*;
import sk.durixx.library.model.dto.RackDto;

@Entity
@Table(name = "rack")
public class Rack {

    @Id
    @SequenceGenerator(
            name = "rack_sequence",
            sequenceName = "rack_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rack_sequence"
    )
    private Long id;

    @Column(
            name = "label",
            nullable = false
    )
    private String label;

    @Column(
            name = "size",
            nullable = false
    )
    private int size;

    public Rack() {

    }

    public Rack(Builder builder) {
        this.id = builder.id;
        this.size = builder.size;
        this.label = builder.label;
    }

    public static Rack fromDto(RackDto rackDto) {
        return new Builder()
                .withId(rackDto.getId())
                .withLabel(rackDto.getLabel())
                .withSize(rackDto.getSize())
                .build();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    private static class Builder {

        public String label;
        private long id;
        private int size;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withLabel(String label) {
            this.label = label;
            return this;
        }

        public Builder withSize(int size) {
            this.size = size;
            return this;
        }

        public Rack build() {
            return new Rack(this);
        }
    }
}