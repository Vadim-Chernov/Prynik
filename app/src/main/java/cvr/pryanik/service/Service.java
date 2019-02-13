package cvr.pryanik.service;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.Gson;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Фейковый сервис имитирующий работу реального сервиса
 */

public class Service {
    private static String text;
    private static String name;
    private static String url;
    private static Integer selectedId;
    private static List<Variant> variants;
    private static List<String> view;
    private static JsonRootBean jsonRootBean;

    private static void initData() {
        JsonRootBean jsonRootBean = getJsonRootBean();
        if (jsonRootBean == null)
            return;

        text = jsonRootBean.getData().get(0).getData().getText();
        url = jsonRootBean.getData().get(1).getData().getUrl();
        selectedId = jsonRootBean.getData().get(2).getData().getSelectedId();
        variants = getVariants(jsonRootBean.getData().get(2).getData().getVariants());
        name = jsonRootBean.getData().get(1).getData().getText();
        view = jsonRootBean.getView();
    }

    public static List<String> getView() {
        return view;
    }

    private static List<Variant> getVariants(List<Data> list) {
        List<Variant> reslt = new ArrayList<>(list.size());
        for (Data data : list)
            reslt.add(new Variant(data.getId(), data.getText()));
        return reslt;
    }

    public static Bitmap loadPicture(String path) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(path);

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            httpConn.connect();
            int resCode = httpConn.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                InputStream in = httpConn.getInputStream();
                bitmap = BitmapFactory.decodeStream(in);
                httpConn.disconnect();
                in.close();
            }
        } catch (Exception e) {
            return null;
        }
        return bitmap;
    }

    private static JsonRootBean parseJSON(String json) {
        Gson gson = new Gson();
        jsonRootBean = gson.fromJson(json, JsonRootBean.class);
        return jsonRootBean;
    }

    public static JsonRootBean getJsonRootBean() {
        return jsonRootBean;
    }


    public static void initJSON(String path) {
        try {
            URL url = new URL(path);

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            httpConn.connect();
            int resCode = httpConn.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                InputStream in = httpConn.getInputStream();
                int len = httpConn.getContentLength();
                byte[] buffer = new byte[len];
                in.read(buffer);

                String json = new String(buffer);
                jsonRootBean = parseJSON(json);

                httpConn.disconnect();
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        initData();
    }


    public static String getText() {
        return text;
    }

    public static String getUrl() {
        return url;
    }

    public static Integer getSelectedId() {
        return selectedId;
    }

    public static List<Variant> getVariants() {
        return variants;
    }

    public static String getName() {
        return name;
    }

    @SuppressLint("UseValueOf")
    public static String getObjectById(long id) {
        return view.get((int) id);
    }
}
