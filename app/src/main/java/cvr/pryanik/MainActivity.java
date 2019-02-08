package cvr.pryanik;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
//import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpDelegate;
import com.arellomobile.mvp.presenter.InjectPresenter;

import cvr.pryanik.util.Dialogs;

public class MainActivity extends MvpAppCompatActivity implements ILoaderView {

    @InjectPresenter
    LoadPresenter loadPresenter;

    private TextView mNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlus = findViewById(R.id.buttonPlus);
        Button btnMinus = findViewById(R.id.buttonMinus);

        btnPlus.setOnClickListener(event -> clickPlus());
        btnMinus.setOnClickListener(event -> clickMinus());


        mNameTextView = findViewById(R.id.name);
        MvpDelegate mvpDelegate = getMvpDelegate();
        // Доступ к дочернним элементам возможен так:
        FormWidget formWidget = (FormWidget) ((BaseWidget) findViewById(R.id.form_widget)).init(mvpDelegate);
    }

    private void clickMinus() {
        loadPresenter.clickMinus();
    }

    private void clickPlus() {
        loadPresenter.clickPlus();
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void setName(String name) {
        mNameTextView.setText("Загружен:" + name);
    }

    @Override
    public void showBtnPlusPressed(String txt) {
        Dialogs.showMessage(this,txt);
//        Toast.makeText(this, txt, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showBtnMinusPressed(String txt) {
        Dialogs.showMessage(this,txt);
    }

}
