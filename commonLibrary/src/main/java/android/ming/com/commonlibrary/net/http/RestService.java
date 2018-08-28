package android.ming.com.commonlibrary.net.http;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Retrofit所有功能
 */
public interface RestService {

    @GET
    Call<String> get(@Url String url, @QueryMap Map<String,Object> params);
}
