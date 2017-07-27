package com.taurus.sixtcartest.core;

import android.app.Application;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

public abstract class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    @Inject Application application;

    protected CompositeDisposable compositeDisposable;

    public BasePresenter(){
        compositeDisposable = new CompositeDisposable();
    }

    public Application getApplication() {
        return application;
    }

    public void clearCompositeDisposable() {

        if (compositeDisposable != null) {

            compositeDisposable.clear();
        }
    }

}
