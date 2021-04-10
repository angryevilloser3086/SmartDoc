package com.example.smartdoc;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

         ImageButton btn = findViewById(R.id.imageButton2);
        btn.setOnClickListener(v ->{
            Intent intent = new Intent(this, PreferredTherapy.class);

            startActivity(intent);
        });

        WebView webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("file:///android_asset/hello.html");

        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setJavaScriptEnabled(true);

        
    }
}