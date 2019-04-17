package com.takwolf.android.refreshandloadmore.demo.model.zhihu;

import android.os.Build;

import com.takwolf.android.refreshandloadmore.demo.BuildConfig;

import java.io.IOException;

import androidx.annotation.NonNull;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ZhihuClient {

    private ZhihuClient() {}

    private static final String USER_AGENT = "RefreshAndLoadMoreDemo/" + BuildConfig.VERSION_NAME + " (Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + "; " + Build.MANUFACTURER + ")";
    private static final String BASE_URL = "https://news-at.zhihu.com/api/4/";

    public static final ZhihuService service = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(new OkHttpClient.Builder()
                    .addInterceptor(createUserAgentInterceptor())
                    .addInterceptor(createHttpLoggingInterceptor())
                    .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ZhihuService.class);

    @NonNull
    private static Interceptor createUserAgentInterceptor() {
        return new Interceptor() {

            private static final String HEADER_USER_AGENT = "User-Agent";

            @NonNull
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                return chain.proceed(chain.request().newBuilder()
                        .header(HEADER_USER_AGENT, USER_AGENT)
                        .build());
            }

        };
    }

    @NonNull
    private static Interceptor createHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return loggingInterceptor;
    }

}
