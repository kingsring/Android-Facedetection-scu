package com.scu_kwc.thread;

import android.os.Message;

import android.os.Handler;

import com.scu_kwc.myapplication.UserInfo;
import com.scu_kwc.myservice.PostUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

//
///**
// * Created by kewenchi26 on 2017/12/13.
// */
//
public class LoginThread extends Thread{
    private Handler handler;
    private String username;
    private String password;
    private Message msg=new Message();
    public LoginThread(Handler handler,String username,String password)

    {
        this.username=username;
        this.password=password;
        this.handler = handler;

    }

    @Override
    public void run()
    {
        try {
            PostUser pUser = new PostUser();
            String json = pUser.Login(username, password);
            JSONObject loginjson = new JSONObject(json);
            UserInfo.g.putString("loginreData", loginjson.get("retData").toString());
            UserInfo.g.putString("login",json);
            this.msg.setData(UserInfo.g);
            handler.sendMessage(this.msg);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

}


