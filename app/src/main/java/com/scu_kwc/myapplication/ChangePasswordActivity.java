package com.scu_kwc.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import com.scu_kwc.thread.ChangePasswordThread;

public class ChangePasswordActivity extends AppCompatActivity {
//
    private Button CPWBtn;
    private TextView Tid;
    private TextView changePword;
    private String changePasswordJson;
    private int stats;
    private Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg){
            ChangePasswordActivity.this.changePasswordJson = msg.getData().getString("changePassword");
            dealString(changePasswordJson);
        };
        public void dealString(String changePasswordJson){
            try {
                JSONObject json = new JSONObject(changePasswordJson);
                stats = json.getInt("errNum");
                if( stats == 200 ) {
                    Intent Person = new Intent();
                    Person.setClass(ChangePasswordActivity.this, PersonManagerActivity.class);
                    Toast.makeText(ChangePasswordActivity.this, "修改成功",
                            Toast.LENGTH_LONG).show();
                    ChangePasswordActivity.this.startActivity(Person);
                    finish();
                }
                else{
                    Toast.makeText(ChangePasswordActivity.this, "return:\n" + changePasswordJson,
                            Toast.LENGTH_LONG).show();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    };
//
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Tid = (TextView)findViewById(R.id.teaId);
        changePword = (TextView)findViewById(R.id.newPassword);
        CPWBtn = findViewById(R.id.ChangePasswordButton);
        try {
            String ujson = UserInfo.g.getString("loginreData");
            JSONObject userjson = new JSONObject(ujson);
            Tid.setText(userjson.getString("teaId"));
        }catch (JSONException e)
        {
            e.printStackTrace();
        }
        CPWBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    new ChangePasswordThread(handler,Tid.getText().toString(),changePword.getText().toString()).start();
            }
        });
//
    }
}
