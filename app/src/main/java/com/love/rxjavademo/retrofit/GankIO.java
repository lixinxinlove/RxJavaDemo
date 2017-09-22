package com.love.rxjavademo.retrofit;

import com.love.rxjavademo.bean.Result;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by android on 2017/7/11.
 */

public interface GankIO {

    @GET("{count}/{page}")
    Observable<Result> getGirls(@Path("count") int count, @Path("page") int page);

}
