package com.scu_kwc.myapplication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class PersonManagerActivity extends AppCompatActivity {

    private TextView username;//教师姓名
    private TextView userid;//用户名
    private Button CPWBtn;//修改密码键
    private Button CNWBtn;//修改教师姓名
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_manager);


        username = (TextView)findViewById(R.id.username);
        userid = (TextView)findViewById(R.id.userid);
        String loginjson = UserInfo.g.getString("loginreData");
        try{
            JSONObject json = new JSONObject(loginjson);
            Toast.makeText(PersonManagerActivity.this, "return:\n" + loginjson,
                    Toast.LENGTH_LONG).show();
            username.setText(json.getString("teaName"));
            userid.setText(json.getString("teaId"));
        }catch(JSONException e){
            e.printStackTrace();
        }

//       change password
        CPWBtn = findViewById(R.id.changePasswordButton);
        CPWBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ChgPassword = new Intent();
                ChgPassword.setClass(PersonManagerActivity.this, ChangePasswordActivity.class);
                PersonManagerActivity.this.startActivity(ChgPassword);
                finish();
            }
        });
        CNWBtn = findViewById(R.id.changeNameButton);
        CNWBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ChgName = new Intent();
                ChgName.setClass(PersonManagerActivity.this, ChangeNameActivity.class);
                PersonManagerActivity.this.startActivity(ChgName);
                finish();
            }
        });

    }


}
