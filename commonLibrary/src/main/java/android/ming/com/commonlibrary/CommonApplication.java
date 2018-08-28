package android.ming.com.commonlibrary;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

public class CommonApplication {

    public static void init(Application application){
        //处理需要初始化的第三方框架
        Utils.init(application);
    }
}
