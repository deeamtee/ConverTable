package com.example.ien.convertable;

import io.reactivex.Single;


public interface CacheProviders {
    Single<Convert> converts(Single<Convert> convertSingle);
}