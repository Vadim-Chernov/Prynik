package cvr.pryanik.service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

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
