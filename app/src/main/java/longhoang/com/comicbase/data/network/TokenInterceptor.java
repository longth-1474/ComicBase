package longhoang.com.comicbase.data.network;


import java.io.IOException;

import javax.inject.Inject;

import longhoang.com.comicbase.utils.ConfigManager;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    @Inject
    ConfigManager mConfigManager;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
//                .header(AUTHORIZATION, String.format("%s%s", BEARER, "idToken"))
                .method(original.method(), original.body())
                .build();
        return chain.proceed(request);
    }
}
