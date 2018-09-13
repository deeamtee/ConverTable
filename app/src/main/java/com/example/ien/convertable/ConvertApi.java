package com.example.ien.convertable;
/**
 * Интерфейс реализующий нужный нам запрос
 **/
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConvertApi {
    @GET("convert")
    Single<Convert> converts(@Query("q") String from_to,
                             @Query("compact") String ultra);
}
