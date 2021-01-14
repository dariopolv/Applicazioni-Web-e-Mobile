package com.example.menu.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.menu.R;


public class ShowWebSite extends Fragment {


    WebView webView;

    public ShowWebSite() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.show_web_site, container, false);
        webView = view.findViewById(R.id.showSiteWebView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://fratellipolverini.it/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    return view;

    }

}