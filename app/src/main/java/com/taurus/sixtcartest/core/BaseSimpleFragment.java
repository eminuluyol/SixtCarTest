package com.taurus.sixtcartest.core;

import android.support.annotation.NonNull;

/**
 * Inherit fragments which have no presenter and view from {@link BaseSimpleFragment}.
 */
public abstract class BaseSimpleFragment extends BaseFragment<BaseView, NoOpPresenter> implements BaseView {

    @NonNull
    @Override
    public NoOpPresenter createPresenter() {
        return new NoOpPresenter();
    }
}
