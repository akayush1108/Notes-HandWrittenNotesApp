package com.akayush1108.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class PdfActivity4 extends AppCompatActivity {

    WebView myWebView4;
//    PDFView pdfView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf4);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout4);

        myWebView4 = (WebView) findViewById(R.id.myWebView4);
        myWebView4.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView4.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView4.loadUrl("https://drive.google.com/file/d/1zMaR-nd4DloR9qYwluqAwv5uKyNbz9vz/view?usp=sharing");

//        pdfView4=(PDFView) findViewById(R.id.pdfview4);
//        pdfView4.fromAsset("Android.pdf")
//                .defaultPage(0)
//                .enableAnnotationRendering(true)
//                .scrollHandle(new DefaultScrollHandle(this))
//                .spacing(2)
//                .load();
    }

    @Override
    public void onBackPressed()
    {
        if(myWebView4.canGoBack())
        {
            myWebView4.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}