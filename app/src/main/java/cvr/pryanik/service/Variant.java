package cvr.pryanik.service;

import android.support.annotation.NonNull;

public class Variant {
    private Integer id;
    private String text;

    public Variant() {
    }

    public Variant(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @NonNull
    @Override
    public String toString() {
        return text;
    }
}
