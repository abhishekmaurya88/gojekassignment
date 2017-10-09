package com.example.blackbird.myapplication.api.retrofit;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by blackbird on 7/10/17.
 */


public class AuthenticationInterceptor implements Interceptor {
    Context context;

    public AuthenticationInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request.Builder builder = originalRequest.newBuilder();
        setHeaders(builder);
        Request newRequest = builder.build();
        return chain.proceed(newRequest);
    }
    private void setHeaders(Request.Builder builder) {

    }

}

