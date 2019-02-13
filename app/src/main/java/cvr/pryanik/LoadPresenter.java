package cvr.pryanik;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import cvr.pryanik.service.IService;
import cvr.pryanik.service.Service;


@InjectViewState
public class LoadPresenter extends MvpPresenter<ILoaderView> {

    private static final String URI_JSON = "https://prnk.blob.core.windows.net/tmp/JSONSample.json";

    // Использовать инжекцию
    private IService service = Service.getInstance();

    public LoadPresenter() {
        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void, String, Void> task = new AsyncTask<Void, String, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                service.loadJSON(URI_JSON);
                publishProgress(service.getText());
                return null;
            }

            @Override
            protected void onProgressUpdate(String... values) {
                getViewState().setName(values[0]);
            }

        };
        task.execute();
    }


    public void clickPlus() {
        getViewState().showBtnPlusPressed("LoadPresenter.clickPlus");
    }

    public void clickMinus() {
        getViewState().showBtnMinusPressed("LoadPresenter.clickMinus");
    }
}
