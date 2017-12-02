package utils;


import java.util.List;

import bean.Deng;
import bean.DuanZi;
import bean.GeRen;
import bean.GetAd;
import bean.PublishJoke;
import bean.Reg;
import bean.Update;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by GUODONG on 2017/11/27.
 */

public interface MyJieKou {

    @FormUrlEncoded
    @POST("user/login")
    Observable<Deng> login(@Field("mobile") String mobile, @Field("password") String password);

    @FormUrlEncoded
    @POST("user/reg")
    Observable<Reg> Reg(@Field("mobile") String mobile, @Field("password")String password,@Field("regType") String regType);

    @FormUrlEncoded
    @POST("user/getUserInfo")
    Observable<GeRen> getinfo(@Field("uid")String uid);

    @POST("quarter/publishJoke")
    @Multipart
    Observable<PublishJoke> publish(@Part List<MultipartBody.Part> parts);

    @FormUrlEncoded
    @POST("quarter/getJokes")
    Observable<DuanZi> getJokes(@Field("uid")String uid);

    @GET("quarter/getAd")
    Observable<GetAd> getAd();

    @FormUrlEncoded
    @POST("user/updateNickName")
    Observable<Update> update(@Field("uid")String uid,@Field("nickname")String nickname);


}
