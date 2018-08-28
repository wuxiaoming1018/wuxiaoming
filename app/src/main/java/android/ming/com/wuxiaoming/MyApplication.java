package android.ming.com.wuxiaoming;

import android.app.Application;
import android.ming.com.commonlibrary.CommonApplication;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        CommonApplication.init(this);
        super.onCreate();
    }
}
