package com.example.menu.Activities;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.menu.R;

public class ChangeMenu extends AppCompatActivity {
    private WebView webView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_menu);
        webView = findViewById(R.id.changewebview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://fratellipolverini.it/wp-admin/post.php?post=52&action=edit");


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
