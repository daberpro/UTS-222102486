package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spinner = findViewById(R.id.mspinner);

        List<String> jeniskl = new ArrayList<>();
        jeniskl.add(getString(R.string.laki_laki));
        jeniskl.add(getString(R.string.perempuan));

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,jeniskl);
        spinner.setAdapter(dataAdapter);

        MaterialButton mbtn = findViewById(R.id.mbtn);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("dabdev","deb", NotificationManager.IMPORTANCE_DEFAULT);
            mbtn.setOnClickListener(v ->{
                Notification noti = new Notification.Builder(this,"dabdev")
                        .setContentTitle("Notif dari uts")
                        .setContentText("Hallo")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .build();


                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.createNotificationChannel(channel);
                manager.notify(1,noti);
            });
        }
    }

}