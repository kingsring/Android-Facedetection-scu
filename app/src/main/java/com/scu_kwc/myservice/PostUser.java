package com.scu_kwc.myservice;



import com.scu_kwc.myapplication.LoginActivity;

import java.io.IOException;
import org.json.JSONObject;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.FormBody;
import okhttp3.Call;
import android.widget.Toast;
import okhttp3.Callback;


public class PostUser {

    public String Login(String username, String password) throws IOException{
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("teaId", username)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url("http://120.27.44.128:8123/face/app/teacherLogin.do")
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        return response.body().string();
    }
    public String Regist(String username, String password) throws IOException{
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("teaId", username)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url("http://120.27.44.128:8123/face/app/teacherRegister.do")
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        return response.body().string();
    }
    public String ChangePassword(String username, String password) throws IOException{
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("teaId", username)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url("http://120.27.44.128:8123/face/app/teacherChangePasswrod.do")
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        return response.body().string();
    }
    public String ChangeName(String username, String teacharName) throws IOException{
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("teaId", username)
                .add("teaName", teacharName)
                .build();

        Request request = new Request.Builder()
                .url("http://120.27.44.128:8123/face/app/teacherUpdate.do")
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        return response.body().string();
    }
}

