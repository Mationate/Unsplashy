package com.adacherSoft.unsplashy.network;

import com.adacherSoft.unsplashy.background.GetDataSplash;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adacher on 10-07-17.
 */

public class UnsplashInterceptor {


    public static final String BASE_URL = "https://api.unsplash.com/photos/";

    public  GetSplash get() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request request = originalRequest.newBuilder()
                        .header("Authorization", "Client-ID 09ac695660cc5ef8fbcd7bea36df815fe47f356a0c26ce11916b9b6c779fe05d")
                        .build();

                Response response = chain.proceed(request);

                /*If the request fail then you get 3 retries*/
                int retryCount = 0;
                while (!response.isSuccessful() && retryCount < 3) {
                    retryCount++;
                    response = chain.proceed(request);
                }

                return response;
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        GetSplash request = interceptor.create(GetSplash.class);

        return request;
    }

    }

