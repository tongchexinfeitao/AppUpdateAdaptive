package com.ali.update;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private AppDownloadManager appDownloadManager;
    //    http://mobile.bwstudent.com/media/zs2.apk
    public static final String url = "http://111.205.104.180/bwie.1.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startDownload(View view) {
        appDownloadManager.downloadApk(url, this.getResources().getString(R.string.app_name), "正在更新");

    }

    @Override
    public void onResume() {
        if (appDownloadManager == null) {
            appDownloadManager = new AppDownloadManager(this);
        }
        super.onResume();
        appDownloadManager.resume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        appDownloadManager.onPause();
    }
}
