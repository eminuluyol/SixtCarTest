package com.taurus.sixtcartest.core.injection;

import android.app.Application;
import com.taurus.sixtcartest.network.retrofit.RetrofitCarInfoApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public RetrofitCarInfoApi provideCarInfoApi() {
        return new RetrofitCarInfoApi();
    }

}
