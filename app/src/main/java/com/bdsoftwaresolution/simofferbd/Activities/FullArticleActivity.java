package com.bdsoftwaresolution.simofferbd.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bdsoftwaresolution.simofferbd.R;

public class FullArticleActivity extends AppCompatActivity {
    private WebView webView;
    private ImageView imageView;
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_article);
        webView = findViewById(R.id.fullarticleWeb);
        title = findViewById(R.id.fullarticletitle_id);
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        String titleData = intent.getStringExtra("title");
        initWeb(data,titleData);
    }

    private void initWeb(String data,String titleData) {
        title.setText(titleData);
        webView.loadDataWithBaseURL(null,data, "text/html", "utf-8", null);
    }

    public void goback(View view) {
        onBackPressed();
    }
}
