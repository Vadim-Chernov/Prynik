package cvr.pryanik;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpDelegate;

public class BaseWidget<T>  extends FrameLayout {
    private MvpDelegate mParentDelegate;
    private MvpDelegate<T> mMvpDelegate;

    public BaseWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public BaseWidget<T> init(MvpDelegate parentDelegate) {
        mParentDelegate = parentDelegate;

        getMvpDelegate().onCreate();
        getMvpDelegate().onAttach();
        return this;
    }

    public BaseWidget<T> get(){
        return this;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        getMvpDelegate().onSaveInstanceState();
        getMvpDelegate().onDetach();
    }


    public MvpDelegate<T> getMvpDelegate() {
        if (mMvpDelegate != null) {
            return mMvpDelegate;
        }

        mMvpDelegate = new MvpDelegate(this);
        mMvpDelegate.setParentDelegate(mParentDelegate, String.valueOf(getId()));
        return mMvpDelegate;
    }



}
