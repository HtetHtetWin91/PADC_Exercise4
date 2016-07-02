package com.example.user8.padc_linkedin;

import android.app.Application;
import android.content.Context;

/**
 * Created by user8 on 6/29/2016.
 */
public class LinkedIn_App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
