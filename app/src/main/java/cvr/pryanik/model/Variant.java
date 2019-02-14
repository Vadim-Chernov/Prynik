package cvr.pryanik.model;

import android.support.annotation.NonNull;
@lombok.Data

public class Variant {
    private Integer id;
    private String text;

    public Variant(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    @NonNull
    @Override
    public String toString() {
        return text;
    }
}
