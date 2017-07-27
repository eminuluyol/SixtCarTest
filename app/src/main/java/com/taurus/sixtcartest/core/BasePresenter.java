package com.taurus.sixtcartest.core;

import android.app.Application;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.taurus.sixtcartest.network.CarInfoApi;
import com.taurus.sixtcartest.network.retrofit.RetrofitCarInfoApi;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

public abstract class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    @Inject
    Application application;

    @Inject
    RetrofitCarInfoApi api;

    protected CompositeDisposable compositeDisposable;

    public BasePresenter(){
        compositeDisposable = new CompositeDisposable();
    }

    public Application getApplication() {
        return application;
    }

    public RetrofitCarInfoApi getApi() {
        return api;
    }

    public void clearCompositeDisposable() {

        if (compositeDisposable != null) {

            compositeDisposable.clear();
        }
    }

}
