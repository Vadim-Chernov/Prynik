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


    public PryanikPresenter() {
        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                bitmap = Service.loadPicture(Service.getUrl());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().setImage(bitmap);
                getViewState().setName(Service.getName());
                getViewState().setSpinnerValues(Service.getVariants());
                getViewState().setSpinner(Service.getSelectedId());
                getViewState().setList(Service.getView());
            }
        };
        task.execute();
    }

    public void clickPlus() {
        System.out.println("---===>>>PryanikPresenter.clickPlus");

    }

    public void spinnerOnItemClick(int num) {
        getViewState().saySpinnerOnItemClick(" выбран " + num);
    }
}
