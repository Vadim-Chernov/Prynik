package cvr.pryanik;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ILoaderView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setName(String name);

    void showBtnPlusPressed(String selected);

    void showBtnMinusPressed(String selected);

//    @StateStrategyType(AddToEndSingleStrategy.class)
//    void setImage(Bitmap bitmap);

}
