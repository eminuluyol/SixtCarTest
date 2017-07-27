package com.taurus.sixtcartest.core.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;
import com.taurus.sixtcartest.R;

@FragmentWithArgs
public class ProgressDialogFragment extends BaseDialogFragment {

    @BindView(R.id.progressDialogProgressBar) ProgressBar progressBar;

    @BindView(R.id.progressDialogTextViewMessage) TextView textViewMessage;

    @Arg(required = false) String message;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getDialog().setCanceledOnTouchOutside(false);
        setCancelable(false);

        progressBar.setIndeterminate(true);
        setText(message);
    }

    private void setText(String message) {
        if (TextUtils.isEmpty(message)) {
            textViewMessage.setVisibility(View.GONE);
        } else {
            textViewMessage.setVisibility(View.VISIBLE);
            textViewMessage.setText(message);
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.dialog_progress;
    }

    public void setMessage(String message) {
        this.message = message;
        setText(message);
    }
}
