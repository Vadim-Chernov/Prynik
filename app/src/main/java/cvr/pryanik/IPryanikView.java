package cvr.pryanik;

import android.graphics.Bitmap;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import cvr.pryanik.service.Variant;


public interface IPryanikView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setImage(Bitmap bitmap);

    void setName(String name);

    void setList(List<String> list);

    void setSpinner(int num);

    void setSpinnerValues(List<Variant> values);

    void saySpinnerOnItemClick(String s);

    void sayOnItemClick(String s);

//    void setSpinnerValues(String[] values);

}
