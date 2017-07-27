package com.taurus.sixtcartest.core;

import android.app.Application;
import com.taurus.sixtcartest.core.injection.Injector;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Injector.getInstance().createApplicationScope(this);

    }
}