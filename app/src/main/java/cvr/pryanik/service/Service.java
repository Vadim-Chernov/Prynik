package cvr.pryanik.service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cvr.pryanik.util.JSONUtils;

public class Service {
    private static String text;
    private static String name;
    private static String url;
    private static Integer selectedId;
    private static List<Variant> variants;
    private static List<String> view;

    public static void init() {
        JsonRootBean jsonRootBean = JSONUtils.getJsonRootBean();
        if (jsonRootBean == null)
            return;

        text = jsonRootBean.getData().get(0).getData().getText();
        url = jsonRootBean.getData().get(1).getData().getUrl();
        selectedId = jsonRootBean.getData().get(2).getData().getSelectedId();
        variants = getVarianrs(jsonRootBean.getData().get(2).getData().getVariants());
        name = jsonRootBean.getData().get(1).getData().getText();
        view = jsonRootBean.getView();
    }

    public static List<String> getView() {
        return view;
    }

    private static List<Variant> getVarianrs(List<Data> list) {
        List<Variant> reslt = new ArrayList<>(list.size());
        for (Data data : list)
            reslt.add(new Variant(data.getId(), data.getText()));
        return reslt;
    }

    public static Bitmap loadPicture(String path) {
        Bitmap bitmap = null;
//        JsonRootBean jsonRootBean = parseJSON();
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
}
