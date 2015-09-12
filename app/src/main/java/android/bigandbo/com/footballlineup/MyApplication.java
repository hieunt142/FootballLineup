package android.bigandbo.com.footballlineup;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by hieunt on 9/11/2015.
 */
public class MyApplication extends Application {
    public static String PACKAGE_NAME;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
        PACKAGE_NAME = getPackageName();
    }
}
