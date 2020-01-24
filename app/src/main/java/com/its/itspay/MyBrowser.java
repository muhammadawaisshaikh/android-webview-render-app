package com.its.itspay;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MyBrowser extends WebViewClient {

    private ProgressDialog progressBar;
    public static final String TAG = MyBrowser.class.getSimpleName();
    private Context context;


    public MyBrowser(Context context){
        this.context = context;
    }


    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        Log.d(TAG, "onPageStarted: ");
        if(progressBar == null) {
            progressBar = new ProgressDialog(context);
            progressBar.setMax(100);
            progressBar.setMessage("Please wait...");
            progressBar.show();
        }

    }

    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        Log.d(TAG, "onLoadResource: ");
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        Log.d(TAG, "onPageFinished: ");

        if(progressBar != null){
            progressBar.dismiss();
            progressBar = null;
        }
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String request) {

        super.shouldOverrideUrlLoading(view, request);

        if("www.gamelist.club".equals(Uri.parse(request).getHost()) ){
            return false;
        }



        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request));
        context.startActivity(intent);
        return true;

    }
}
