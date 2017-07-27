package com.taurus.sixtcartest.carinfo;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.taurus.sixtcartest.R;
import com.taurus.sixtcartest.core.BaseFragment;
import com.taurus.sixtcartest.core.BaseSimpleActivity;

public class CarInfoActivity extends BaseSimpleActivity {

  @Nullable
  @Override protected BaseFragment getContainedFragment() {
    return CarInfoFragment.newInstance();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setTitle(R.string.car_info_title);

  }
}
