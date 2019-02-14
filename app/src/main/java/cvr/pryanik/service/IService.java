package cvr.pryanik.service;

import android.graphics.Bitmap;

import java.util.List;

import cvr.pryanik.model.Variant;

public interface IService {
    Bitmap loadPicture(String path);

    void loadJSON(String path);

    List<String> getView();

    String getText();

    String getUrl();

    Integer getSelectedId();

    List<Variant> getVariants();

    String getName();

    String getObjectById(long id);
}
