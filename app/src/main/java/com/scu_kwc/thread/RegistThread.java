package com.scu_kwc.thread;

import android.os.Handler;
import android.os.Message;

import com.scu_kwc.myapplication.UserInfo;
import com.scu_kwc.myservice.PostUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by SCU-KWC on 2017/12/21.
 */

public class RegistThread extends Thread{
    private Handler handler;
    private String username;
    private String password;
    private Message msg=new Message();
    public RegistThread(Handler handler,String username,String password)

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
            String json = pUser.Regist(username, password);
            JSONObject registjson = new JSONObject(json);
            UserInfo.g.putString("registreData", registjson.get("retData").toString());
            UserInfo.g.putString("regist",json);
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
