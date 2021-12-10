package com.akayush1108.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfActivity4 extends AppCompatActivity {

    String urls4;
    PDFView pdfView4;
    ProgressDialog dialog4;


//    WebView myWebView4;
//    PDFView pdfView4;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf4);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout4);

        pdfView4 = findViewById(R.id.abc4);

        // Firstly we are showing the progress
        // dialog when we are loading the pdf
        dialog4 = new ProgressDialog(this);
        dialog4.setMessage("Loading..");
        dialog4.show();

        // getting url of pdf using getItentExtra
        urls4 = getIntent().getStringExtra("url");
        new PdfActivity4.RetrivePdfStream().execute(urls4);
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
            pdfView4.fromStream(inputStream).load();
            dialog4.dismiss();
        }




//        myWebView4 = (WebView) findViewById(R.id.myWebView4);
//        myWebView4.setWebViewClient(new WebViewClient());
//        WebSettings webSettings = myWebView4.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        myWebView4.loadUrl("https://drive.google.com/file/d/1zMaR-nd4DloR9qYwluqAwv5uKyNbz9vz/view?usp=sharing");

//        pdfView4=(PDFView) findViewById(R.id.pdfview4);
//        pdfView4.fromAsset("Android.pdf")
//                .defaultPage(0)
//                .enableAnnotationRendering(true)
//                .scrollHandle(new DefaultScrollHandle(this))
//                .spacing(2)
//                .load();
    }

//    @Override
//    public void onBackPressed()
//    {
//        if(myWebView4.canGoBack())
//        {
//            myWebView4.goBack();
//        }
//        else
//        {
//            super.onBackPressed();
//        }
//    }
}