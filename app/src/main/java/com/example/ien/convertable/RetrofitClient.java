package com.example.ien.convertable;

import android.content.Context;

import io.reactivex.Single;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class RetrofitClient {
    //private CacheProviders cacheProviders;
    private static Retrofit ourInstance;

    public static Retrofit getInstance(){
        if (ourInstance == null)
            ourInstance = new Retrofit.Builder()
                    .baseUrl("http://free.currencyconverterapi.com/api/v6/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return ourInstance;
    }
    private RetrofitClient(){

    }
}