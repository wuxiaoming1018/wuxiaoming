package android.ming.com.commonlibrary.net.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Interceptor;

public class Configurator {

    private static final Map<Object, Object> CONFIG = new HashMap<>();

    private static final List<Interceptor> INTERCEPTORS = new ArrayList<>();

    //静态内部类实现单例模式
    private Configurator() {
        //默认为false
        CONFIG.put(ConfigKey.CONFIG_READY.name(), false);
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    //获取配置信息
    public  final Map<Object, Object> getConfigs() {
        return CONFIG;
    }

    //配置APIHOST(返回this，方便链式调用)
    public final Configurator withApiHost(String host){
        CONFIG.put(ConfigKey.API_HOST.name(),host);
        return this;
    }

    /**
     * 根据key值来获取配置信息
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getConfiguration(Object key){
        checkConfigurator();
        final Object value = CONFIG.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString()+" IS NULL");
        }
        return (T) CONFIG.get(key);
    }

    private void checkConfigurator() {
        final boolean isReady = (boolean) CONFIG.get(ConfigKey.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configurator is no ready,Please call configure()");
        }
    }

    /**
     * 完成配置
     */
    public void configure(){
        CONFIG.put(ConfigKey.CONFIG_READY.name(),true);
    }

}
