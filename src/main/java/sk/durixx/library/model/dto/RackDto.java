package sk.durixx.library.model.dto;

import sk.durixx.library.model.entity.Rack;

public class RackDto {


    private long id;
    private int size;
    private String label;

    public RackDto() {
    }

    public RackDto(Builder builder) {
        this.id = builder.id;
        this.size = builder.size;
        this.label = builder.label;
    }

    public static RackDto fromRack(Rack rack) {
        return new Builder()
                .withId(rack.getId())
                .withLabel(rack.getLabel())
                .withSize(rack.getSize())
                .build();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private static class Builder {

        public String label;
        private long id;
        private int size;

        public RackDto.Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public RackDto.Builder withLabel(String label) {
            this.label = label;
            return this;
        }

        public RackDto.Builder withSize(int size) {
            this.size = size;
            return this;
        }

        public RackDto build() {
            return new RackDto(this);
        }
    }
}
