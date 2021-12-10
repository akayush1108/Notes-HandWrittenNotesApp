package com.akayush1108.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfActivity1 extends AppCompatActivity {

    String urls;
    PDFView pdfView;
    ProgressDialog dialog;



    //PDFView pdfView;
//    WebView myWebView;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf1);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout1);



        pdfView = findViewById(R.id.abc);

        // Firstly we are showing the progress
        // dialog when we are loading the pdf
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading..");
        dialog.show();

        // getting url of pdf using getItentExtra
        urls = getIntent().getStringExtra("url");
        new RetrivePdfStream().execute(urls);
    }

    // Retrieving the pdf file using url
    class RetrivePdfStream extends AsyncTask<String, Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {

                // adding url
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                // if url connection response code is 200 means ok the execute
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            }
            // if error return null
            catch (IOException e) {
                return null;
            }
            return inputStream;
        }

        @Override
        // Here load the pdf and dismiss the dialog box
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
            dialog.dismiss();
        }




//        myWebView = (WebView)findViewById(R.id.myWebView);
//        myWebView.setWebViewClient(new WebViewClient());
//        WebSettings webSettings = myWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        myWebView.loadUrl("https://drive.google.com/file/d/1VT2nv2bTrJ_JCGyk6jBNB7U9WujP2Acw/view?usp=sharing");



//        ProgressBar progressBar = findViewById(R.id.progressBar);
//
//        progressBar.setVisibility(View.VISIBLE);
//
//        webView.getSettings().setBuiltInZoomControls(true);
//
//        webView.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                super.onProgressChanged(view, newProgress);
//                if(newProgress==100){
//                    progressBar.setVisibility(View.GONE);
//                }
//            }
//        });
//        webView.loadUrl(url);


//        pdfView=(PDFView) findViewById(R.id.pdfview);
//        pdfView.fromAsset("Java 1.pdf")
//                .defaultPage(0)
//                .enableAnnotationRendering(true)
//                .scrollHandle(new DefaultScrollHandle(this))
//                .spacing(2)
//                .load();


    }
//    @Override
//    public void onBackPressed()
//    {
//        if(myWebView.canGoBack())
//        {
//            myWebView.goBack();
//        }
//        else
//        {
//            super.onBackPressed();
//        }
//    }


}