package com.taurus.sixtcartest.core.injection;


import com.taurus.sixtcartest.carinfo.CarInfoPresenter;
import com.taurus.sixtcartest.core.NoOpPresenter;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(NoOpPresenter noOpPresenter);

    void inject(CarInfoPresenter carInfoPresenter);
}
