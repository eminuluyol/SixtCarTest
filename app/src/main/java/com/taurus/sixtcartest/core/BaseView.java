package com.taurus.sixtcartest.core;

import com.hannesdorfmann.mosby.mvp.MvpView;

public interface BaseView extends MvpView {

    void showError(String message);

    void showProgress();

    void showProgress(String message);

    void setProgressMessage(String message);

    void dismissProgress();
}