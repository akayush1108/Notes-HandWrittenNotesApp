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

public class PdfActivity2 extends AppCompatActivity {

    String urls2;
    PDFView pdfView2;
    ProgressDialog dialog2;


//    WebView myWebView2;
//    PDFView pdfView2;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout2);


        pdfView2 = findViewById(R.id.abc2);

        // Firstly we are showing the progress
        // dialog when we are loading the pdf
        dialog2 = new ProgressDialog(this);
        dialog2.setMessage("Loading..");
        dialog2.show();

        // getting url of pdf using getItentExtra
        urls2 = getIntent().getStringExtra("url");
        new PdfActivity2.RetrivePdfStream().execute(urls2);
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
            pdfView2.fromStream(inputStream).load();
            dialog2.dismiss();
        }



//        myWebView2 = (WebView) findViewById(R.id.myWebView2);
//        myWebView2.setWebViewClient(new WebViewClient());
//        WebSettings webSettings = myWebView2.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        myWebView2.loadUrl("https://drive.google.com/file/d/1DWHRNbXt5v3OoweOMaUG2TxTEGKmV1u4/view?usp=sharing");

    }

//    @Override
//    public void onBackPressed()
//    {
//        if(myWebView2.canGoBack())
//        {
//            myWebView2.goBack();
//        }
//        else
//        {
//            super.onBackPressed();
//        }
//    }
}