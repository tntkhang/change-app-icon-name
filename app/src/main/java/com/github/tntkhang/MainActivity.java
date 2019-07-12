package com.github.tntkhang;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    String lastActiveIcon = "com.github.tntkhang.DefaultActivity";
    String activeName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btDefault).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revertOrginalIcon();
            }
        });

        findViewById(R.id.btLeft).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeName = "com.github.tntkhang.TurnLeftActivity";
                setAppIcon(activeName);
            }
        });

        findViewById(R.id.btRight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeName = "com.github.tntkhang.TurnRightActivity";
                setAppIcon(activeName);
            }
        });

    }
    public void setAppIcon(String activeName) {
        getPackageManager().setComponentEnabledSetting(
                new ComponentName(BuildConfig.APPLICATION_ID, lastActiveIcon),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        getPackageManager().setComponentEnabledSetting(
                new ComponentName(BuildConfig.APPLICATION_ID, activeName),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

        lastActiveIcon = activeName;
    }

    public void revertOrginalIcon() {
        activeName = "com.github.tntkhang.DefaultActivity";
        setAppIcon(activeName);
    }
}
