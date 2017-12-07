package com.scu_kwc.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogActivity extends AppCompatActivity {
    private Button logBtn;
    private TextView email,password;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.useremail);
        password = findViewById(R.id.password);
        logBtn = findViewById(R.id.logbutton);
        logBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                logBtn.setText("登陆成功");
//                此处应发送到服务器去验证用户
                //password = verify(password)
                //Bool Log =http(server, email, password);
                //if(Bool)
                //  Login-succssed;
            }
        });
    }

}