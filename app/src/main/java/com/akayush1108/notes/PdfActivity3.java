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

public class PdfActivity3 extends AppCompatActivity {

    String urls3;
    PDFView pdfView3;
    ProgressDialog dialog3;


//    WebView myWebView3;
//    PDFView pdfView3;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf3);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout3);


        pdfView3 = findViewById(R.id.abc3);

        // Firstly we are showing the progress
        // dialog when we are loading the pdf
        dialog3 = new ProgressDialog(this);
        dialog3.setMessage("Loading..");
        dialog3.show();

        // getting url of pdf using getItentExtra
        urls3 = getIntent().getStringExtra("url");
        new PdfActivity3.RetrivePdfStream().execute(urls3);
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
            pdfView3.fromStream(inputStream).load();
            dialog3.dismiss();
        }



//        myWebView3 = (WebView) findViewById(R.id.myWebView3);
//        myWebView3.setWebViewClient(new WebViewClient());
//        WebSettings webSettings = myWebView3.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        myWebView3.loadUrl("https://drive.google.com/file/d/1dP4hbXoxppUjJ7yk7RFIAnHV1UI7_0Fm/view?usp=sharing");


    }

//    @Override
//    public void onBackPressed()
//    {
//        if(myWebView3.canGoBack())
//        {
//            myWebView3.goBack();
//        }
//        else
//        {
//            super.onBackPressed();
//        }
//    }
}