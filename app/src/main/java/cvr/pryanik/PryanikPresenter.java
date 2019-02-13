package cvr.pryanik;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import cvr.pryanik.service.Service;


@InjectViewState
public class PryanikPresenter extends MvpPresenter<IPryanikView> {

    private Bitmap bitmap;
// Использовать инжекцию
    private Service service = Service.getInstance();


    public PryanikPresenter() {
        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                bitmap = service.loadPicture(service.getUrl());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().setImage(bitmap);
                getViewState().setName(service.getName());
                getViewState().setSpinnerValues(service.getVariants());
                getViewState().setSpinner(service.getSelectedId());
                getViewState().setList(service.getView());
            }
        };
        task.execute();
    }

    public void spinnerOnItemClick(int num) {

        getViewState().saySpinnerOnItemClick("Spinner выбор : " + num);
    }

    public void onItemClick(long id) {
        getViewState().sayOnItemClick("ListView выбран : id="+id+"    view=" + service.getObjectById(id));
    }
}
