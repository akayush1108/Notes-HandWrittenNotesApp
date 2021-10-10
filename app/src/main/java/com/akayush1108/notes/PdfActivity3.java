package com.akayush1108.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class PdfActivity3 extends AppCompatActivity {

    WebView myWebView3;
//    PDFView pdfView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf3);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout3);

        myWebView3 = (WebView) findViewById(R.id.myWebView3);
        myWebView3.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView3.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView3.loadUrl("https://drive.google.com/file/d/1dP4hbXoxppUjJ7yk7RFIAnHV1UI7_0Fm/view?usp=sharing");


    }

    @Override
    public void onBackPressed()
    {
        if(myWebView3.canGoBack())
        {
            myWebView3.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}