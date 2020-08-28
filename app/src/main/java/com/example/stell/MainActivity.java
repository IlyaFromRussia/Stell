 package com.example.stell;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


 public class MainActivity extends AppCompatActivity {

   private static final String CAMERA_PERMISSION = Manifest.permission.CAMERA;
   private static final int PERMISSION_REQUEST_CODE = 1001;
   private Button mCameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCameraButton = (Button) findViewById(R.id.CameraButton);
        mCameraButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                //
                // (1.2) need to autofocus camera om CameraActivity
                CameraPermissions();
                // (1.3) need to push project into GitHub

                // (3) need to receive Longitude and Latitude with GPS
                // (3.1) need to push changes to GitHub
                // (4) need to receive phone orientation
                // (5) need to receive map of stars
                // (6) need to draw on surfaceView first two stars
                // (7) need to add some test in project
                //

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void CameraPermissions(){
        if(ActivityCompat.checkSelfPermission(this,CAMERA_PERMISSION) == PackageManager.PERMISSION_DENIED){
           requestPermissions(new String[] {CAMERA_PERMISSION}, PERMISSION_REQUEST_CODE);
       }
        else{
            startActivity(newIntent(this,CameraActivity.class));
        }
    }

    // this method calls after user accept or denied permission
     @Override
     public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
         super.onRequestPermissionsResult(requestCode, permissions, grantResults);
         if(requestCode == PERMISSION_REQUEST_CODE){
             if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                 startActivity(newIntent(this,CameraActivity.class));
             }
         }
     }

     private Intent newIntent(Context packageContext, Class<?>cls){
         Intent intent = new Intent(packageContext, cls);
         return intent;
     }

}