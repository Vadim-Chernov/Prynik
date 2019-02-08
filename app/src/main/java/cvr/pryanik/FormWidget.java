package cvr.pryanik;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import java.util.List;

import cvr.pryanik.service.Variant;

public class FormWidget extends BaseWidget<FormWidget> implements IPryanikView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    PryanikPresenter mPryanikPresenter;

    private TextView nameTextView;
    private ImageView imageView;
    private Spinner spinner;
    private ListView listView;

    public FormWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.form_widget, this, true);

        nameTextView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerOnItemClick(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getContext(),"onNothingSelected",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void spinnerOnItemClick(int id) {
        mPryanikPresenter.spinnerOnItemClick(id);
    }


    @Override
    public void setImage(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void setName(String name) {
        nameTextView.setText(name);
    }


    @Override
    public void setSpinner(int num) {
        spinner.setSelection(num);
    }

    @Override
    public void setList(List<String> list) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.rowlayout, R.id.label, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void setSpinnerValues(List<Variant> list) {
        ArrayAdapter<Variant> adapter = new ArrayAdapter<>(getContext(), R.layout.spinnerrowlayout,R.id.label, list);
        spinner.setAdapter(adapter);
    }

    @Override
    public void saySpinnerOnItemClick(String txt) {
        Toast.makeText(getContext(),txt,Toast.LENGTH_SHORT).show();
    }
}

