package com.rohit.assignment;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            webView.loadUrl(extras.getString("url"));
        }

        webView.setWebViewClient(new WebViewClient());

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                WebViewActivity.this.setTitle(view.getTitle());
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}