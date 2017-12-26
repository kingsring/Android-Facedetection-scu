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

import com.scu_kwc.thread.ChangeNameThread;

import org.json.JSONException;
import org.json.JSONObject;

public class ChangeNameActivity  extends AppCompatActivity {
    //
    private Button CNWBtn;
    private TextView Tid;
    private TextView changeName;
    private String changeNameJson;
    private int stats;
    private Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg){
            ChangeNameActivity.this.changeNameJson = msg.getData().getString("changeName");
            dealString(changeNameJson);
        };
        public void dealString(String changeNameJson){
            try {
                JSONObject json = new JSONObject(changeNameJson);
                stats = json.getInt("errNum");
                if( stats == 200 ) {
                    Intent Person = new Intent();
                    Person.setClass(ChangeNameActivity.this, PersonManagerActivity.class);
                    Toast.makeText(ChangeNameActivity.this, "修改成功",
                            Toast.LENGTH_LONG).show();
                    ChangeNameActivity.this.startActivity(Person);
                    finish();
                }
                else{
                    Toast.makeText(ChangeNameActivity.this, "return:\n" + changeNameJson,
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
        setContentView(R.layout.activity_change_name);

        Tid = (TextView)findViewById(R.id.teaId);
        changeName = (TextView)findViewById(R.id.newName);
        CNWBtn = findViewById(R.id.ChangeNameButton);
        try {
            String ujson = UserInfo.g.getString("loginreData");
            JSONObject userjson = new JSONObject(ujson);
            Tid.setText(userjson.getString("teaId"));
        }catch (JSONException e)
        {
            e.printStackTrace();
        }
        CNWBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ChangeNameThread(handler,Tid.getText().toString(),changeName.getText().toString()).start();
            }
        });
//
    }
}
