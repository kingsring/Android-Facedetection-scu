package com.scu_kwc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.provider.MediaStore;
import android.graphics.Bitmap;
import java.io.File;
import android.os.Environment;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;



public class PActivity extends AppCompatActivity {

    private Button TPbtn;
    private Button FTpbun;
    public static final int MEDIA_TYPE_IMAGE = 1;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri fileUri;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p);
        TPbtn = findViewById(R.id.takePhotoButton1);
        TPbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);;
                //if (intent.resolveActivity(getPackageManager()) != null)
                    //startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
                    //fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
                    //intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);;
                    startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        });
    }
//    private static Uri getOutputMediaFileUri(int type)
//    {
//        return Uri.fromFile(getOutputMediaFile(type));
//    }
//    private static File getOutputMediaFile(int type)
//    {
//        File mediaStorageDir = null;
//        try{
//            mediaStorageDir = new File(
//                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"ScukwcApp");
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        if (!mediaStorageDir.exists())
//        {
//            if (!mediaStorageDir.mkdirs())
//            {
//                // 在SD卡上创建文件夹需要权限：
//                // <uses-permission
//                // android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
//                return null;
//            }
//        }
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
//                .format(new Date());
//        File mediaFile;
//        if (type == MEDIA_TYPE_IMAGE)
//        {
//            mediaFile = new File(mediaStorageDir.getPath() + File.separator
//                    + "IMG_" + timeStamp + ".jpg");
//        }
//        else
//        {
//            return null;
//        }
//        return mediaFile;
//    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE:
                if(data !=null)
                {
                    Toast.makeText(this, "Image saved to:\n" + data.getExtras(),
                            Toast.LENGTH_LONG).show();
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    imageView = findViewById(R.id.show_photo);
                    imageView.setImageBitmap(imageBitmap);
//                    if (data.hasExtra("data"))
//                    {
//                        Bitmap thumbnail = data.getParcelableExtra("data");
//                        imageView.setImageBitmap(thumbnail);
//                    }
                }
                break;

        }
    }


}
