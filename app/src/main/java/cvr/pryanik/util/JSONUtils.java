package cvr.pryanik.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.Gson;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import cvr.pryanik.service.Data;
import cvr.pryanik.service.JsonRootBean;

public class JSONUtils {
    private static JsonRootBean jsonRootBean;

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
    }

    private static JsonRootBean parseJSON(String json) {
        Gson gson = new Gson();
        jsonRootBean = gson.fromJson(json, JsonRootBean.class);
        return jsonRootBean;
    }
}
//    public static String JSON = "{\n" +
//            "\t\"data\": [{\n" +
//            "\t\t\t\"name\": \"hz\",\n" +
//            "\t\t\t\"data\": {\n" +
//            "\t\t\t\t\"text\": \"тринитротолуол\"\n" +
//            "\t\t\t}\n" +
//            "\t\t}, {\n" +
//            "\t\t\t\"name\": \"picture\",\n" +
//            "\t\t\t\"data\": {\n" +
//            "\t\t\t\t\"url\": \"https://cdnbeta.pryaniky.com/content/img/opportunities_8_talents.png\",\n" +
//            "\t\t\t\t\"text\": \"Голова\"\n" +
//            "\t\t\t}\n" +
//            "\t\t}, {\n" +
//            "\t\t\t\"name\": \"selector\",\n" +
//            "\t\t\t\"data\": {\n" +
//            "\t\t\t\t\"selectedId\": 1,\n" +
//            "\t\t\t\t\"variants\": [{\n" +
//            "\t\t\t\t\t\t\"id\": 0,\n" +
//            "\t\t\t\t\t\t\"text\": \"Вариант 1\"\n" +
//            "\t\t\t\t\t}, {\n" +
//            "\t\t\t\t\t\t\"id\": 1,\n" +
//            "\t\t\t\t\t\t\"text\": \"Вариант 2\"\n" +
//            "\t\t\t\t\t}, {\n" +
//            "\t\t\t\t\t\t\"id\": 2,\n" +
//            "\t\t\t\t\t\t\"text\": \"Вариант 777\"\n" +
//            "\t\t\t\t\t}\n" +
//            "\t\t\t\t]\n" +
//            "\t\t\t}\n" +
//            "\t\t}\n" +
//            "\t],\n" +
//            "\t\"view\": [\"hz\", \"selector\", \"picture\", \"hz\"]\n" +
//            "}";
