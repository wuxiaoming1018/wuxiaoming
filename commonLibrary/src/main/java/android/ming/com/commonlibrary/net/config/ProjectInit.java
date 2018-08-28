package android.ming.com.commonlibrary.net.config;

import android.content.Context;

public class ProjectInit {

    public static  Configurator init(Context context){
        Configurator.getInstance()
                .getConfigs()
                .put(ConfigKey.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return getConfigurator();
    }

    public static  Configurator getConfigurator(){
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key){
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext(){
        return getConfiguration(ConfigKey.APPLICATION_CONTEXT.name());
    }
}
