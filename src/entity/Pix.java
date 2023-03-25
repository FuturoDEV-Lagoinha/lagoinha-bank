package entity;

import java.util.UUID;

public class Pix {

    private UUID id;

    private String key;

    public Pix(UUID id, String key) {
        this.id = id;
        this.key = key;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
