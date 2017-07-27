package com.taurus.sixtcartest.core.injection;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

public final class Injector {

    private static Injector instance;

    private ApplicationComponent applicationComponent;

    private ActivityComponent activityComponent;

    public static Injector getInstance() {
        if (instance == null) {
            instance = new Injector();
        }

        return instance;
    }

    private Injector() {
    }

    public void createApplicationScope(Application application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .build();
    }

    public void createActivityScope(AppCompatActivity activity) {
        activityComponent = applicationComponent.activityComponent(new ActivityModule(activity));
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
