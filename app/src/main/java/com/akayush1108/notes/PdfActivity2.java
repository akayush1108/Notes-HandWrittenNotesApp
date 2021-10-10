package com.akayush1108.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class PdfActivity2 extends AppCompatActivity {

    WebView myWebView2;
//    PDFView pdfView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout2);

        myWebView2 = (WebView) findViewById(R.id.myWebView2);
        myWebView2.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView2.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView2.loadUrl("https://drive.google.com/file/d/1DWHRNbXt5v3OoweOMaUG2TxTEGKmV1u4/view?usp=sharing");

    }

    @Override
    public void onBackPressed()
    {
        if(myWebView2.canGoBack())
        {
            myWebView2.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}