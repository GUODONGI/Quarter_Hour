package test.bwie.com.quarter_hour;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.meg7.widget.CustomShapeImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import basemodel.BasePresenterr;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static java.lang.String.valueOf;

public class XiuGaiXinXi extends BaseActivity {


    private RelativeLayout re_xiuage;
    private RelativeLayout re_xiuname;
    private RelativeLayout re_xiuqian;
    private RelativeLayout re_xiutou;
    private SharedPreferences sp;
    private TextView xiu_name;
    private CustomShapeImageView xiu_tx;
    private TextView te_zhang;
    private static final int CHOOSE_PICTURE = 0;
    private static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static Uri tempUri;

    @Override
    public BasePresenterr initPresenter() {
        return presenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_xiu_gai_xin_xi;
    }

    @Override
    public void initView() {


        re_xiuage = findViewById(R.id.re_xiuage);
        re_xiuname = findViewById(R.id.re_xiuname);
        re_xiuqian = findViewById(R.id.re_xiuqian);
        re_xiutou = findViewById(R.id.re_xiutou);
        xiu_name = findViewById(R.id.xiu_name);
        xiu_tx = findViewById(R.id.xiu_tx);
        te_zhang = findViewById(R.id.te_zhang);


        re_xiuname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(XiuYeMian.class);
            }
        });


        sp = getSharedPreferences("token", MODE_PRIVATE);
        String icon = sp.getString("icon", "");
        String moblie = sp.getString("moblie", "");
        String nickname = sp.getString("nickname", "");
        xiu_name.setText(nickname);
        te_zhang.setText(moblie);
        showToast(moblie+nickname);
        Glide.with(this).load(icon).into(xiu_tx);
        re_xiutou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                showChoosePicDialog();
            }
        });

    }



    private void showChoosePicDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("设置头像");
        String[] items = { "选择本地照片", "拍照" };
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE: // 选择本地照片
                        Intent openAlbumIntent = new Intent(
                                Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    case TAKE_PICTURE: // 拍照
                        Intent openCameraIntent = new Intent(
                                MediaStore.ACTION_IMAGE_CAPTURE);
                        tempUri = Uri.fromFile(new File(Environment
                                .getExternalStorageDirectory(), "image.jpg"));
                        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                }
            }
        });
        builder.create().show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            try {
                Bitmap photo = extras.getParcelable("data");
                xiu_tx.setImageBitmap(photo);
                File file=new File("mnt/sdcard/yang.png");
                if(!file.exists()){
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileOutputStream outputStream = new FileOutputStream(file);
                photo.compress(Bitmap.CompressFormat.PNG,100,outputStream);
                if(file!=null) {
                    String filename = file.getName();
                    Map<String, Object> params = new HashMap<>();
                    params.put("mobile", "15011411273");
                    params.put("uid",86);
                    OkHttpClient okHttpClient = new OkHttpClient();
                    MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
                    RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
                    builder.addFormDataPart("file", filename, requestBody);
                    if (params != null) {
                        // map 里面是请求中所需要的 key 和 value
                        for (Map.Entry entry : params.entrySet()) {

                            builder.addFormDataPart(valueOf(entry.getKey()), valueOf(entry.getValue()));
                        }
                    }
                    Request request = new Request.Builder().url("https://www.zhaoapi.cn/file/upload").post(builder.build()).build();
                    Call call = okHttpClient.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            System.out.println("=========" + response.body().string());
                        }
                    });
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void startPhotoZoom(Uri uri) {

        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);

    }

}
