package com.scu_kwc.thread;

import android.os.Handler;
import android.os.Message;

import com.scu_kwc.myapplication.UserInfo;
import com.scu_kwc.myservice.PostUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by kewenchi26 on 2017/12/25.
 */



public class ChangePasswordThread extends Thread{
    private Handler handler;
    private String username;
    private String password;
    private Message msg=new Message();
    public ChangePasswordThread(Handler handler,String username,String password)

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
            String json = pUser.ChangePassword(username, password);
            JSONObject Changejson = new JSONObject(json);
            UserInfo.g.putString("changePasswordreData", Changejson.get("retData").toString());
            UserInfo.g.putString("changePassword",json);
            this.msg.setData(UserInfo.g);
            handler.sendMessage(this.msg);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
    }

}