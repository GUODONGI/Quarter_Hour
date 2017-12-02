package Presenter;

import android.content.Context;

import java.io.File;
import java.util.List;

import Model.PublishJokeModel;
import basemodel.BasePresenterr;
import bean.PublishJoke;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import view.PublishJokeView;

/**
 * Created by GUODONG on 2017/11/28.
 */

public class PublishJokePresenter extends BasePresenterr<PublishJokeView> implements PublishJokeModel.InfoInterface{

    private PublishJokeModel publishJokeModel;
    private Context context;

    public PublishJokePresenter(PublishJokeView view,Context context) {
        super(view);
        this.context = context;
        publishJokeModel = new PublishJokeModel(this);
    }
    public void publishJoke(int uid, String content, List<String> file){

       MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM)
               .addFormDataPart("uid",uid+"")
               .addFormDataPart("content",content)
               ;
       if(file!=null)
       {
           for (int i = 0; i <file.size() ; i++) {

               File file1 = new File(file.get(i));
               RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"),file1);
               builder.addFormDataPart("jokeFiles",file1.getName(),body);

           }

       }
        MultipartBody build = builder.build();
        List<MultipartBody.Part> parts = build.parts();
        publishJokeModel.network(parts);

    }
    @Override
    public void seccuss(PublishJoke p) {

        v.seccuss(p);
    }
    @Override
    public void error(String msg) {

        v.error(msg);
    }
    @Override
    public void netfailure(String msg) {

        v.netfailure(msg);
    }
    @Override
    public void Token(String msg) {

        v.Token(msg);
    }
}
