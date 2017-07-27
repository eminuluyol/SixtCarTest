package com.taurus.sixtcartest.core;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.taurus.sixtcartest.R;
import com.taurus.sixtcartest.core.dialog.ProgressDialogFragment;
import com.taurus.sixtcartest.core.dialog.ProgressDialogFragmentBuilder;

public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends MvpFragment<V, P>
        implements BaseView {

    private static final String TAG_PROGRESS_DIALOG = "PROGRESS_DIALOG";

    private ProgressDialogFragment progressDialogFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentArgs.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(getLayoutResId(), container, false);

        ButterKnife.bind(this, rootView);

        progressDialogFragment = new ProgressDialogFragmentBuilder().build();

        // Fragment locked in portrait screen orientation
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        return rootView;
    }

    protected abstract int getLayoutResId();

    public String getDefaultFragmentTag() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void showError(String message) {

        if (TextUtils.isEmpty(message)) return;

        Snackbar snackbar = Snackbar.make(((BaseActivity) getActivity()).getRootView(), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.red));
        snackbar.show();

    }

    @Override
    public void showProgress() {
        if (progressDialogFragment == null || progressDialogFragment.isVisible()) return;

        progressDialogFragment.show(getChildFragmentManager(), TAG_PROGRESS_DIALOG);
    }

    @Override
    public void showProgress(String message) {
        if (progressDialogFragment == null || progressDialogFragment.isVisible()) return;

        progressDialogFragment.setMessage(message);
        progressDialogFragment.show(getChildFragmentManager(), TAG_PROGRESS_DIALOG);
    }

    @Override
    public void setProgressMessage(String message) {
        progressDialogFragment.setMessage(message);
    }

    @Override
    public void dismissProgress() {
        if(progressDialogFragment == null) return;
        progressDialogFragment.dismissAllowingStateLoss();
    }

    @Override public void onStop() {
        getPresenter().clearCompositeDisposable();
        super.onStop();
    }

}
