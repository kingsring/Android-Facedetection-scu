package com.scu_kwc.thread;

import android.icu.lang.UScript;
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

public class ChangeNameThread extends Thread {
    private Handler handler;
    private String username;
    private String teacherName;
    private Message msg = new Message();

    public ChangeNameThread(Handler handler, String username, String teacherName)

    {
        this.username = username;
        this.teacherName = teacherName;
        this.handler = handler;

    }

    @Override
    public void run() {
        try {
            PostUser pUser = new PostUser();
            String json = pUser.ChangeName(username, teacherName);
            JSONObject Changejson = new JSONObject(json);
            UserInfo.g.putString("changeNamereData", Changejson.get("retData").toString());
            UserInfo.g.putString("changeName", json);
            this.msg.setData(UserInfo.g);
            handler.sendMessage(this.msg);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
