package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.love.rxjavademo.R;

public class H5Activity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5);
        mWebView = (WebView) findViewById(R.id.wv);
        mWebView.setWebViewClient(new HelloWebViewClient());
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        mWebView.getSettings().setAppCacheMaxSize(1024 * 1024 * 8);
        String appCachePath = getApplication().getCacheDir().getAbsolutePath();
        settings.setAppCachePath(appCachePath);
        // mWebView.loadUrl("file:///android_asset/index.html");
        mWebView.loadUrl("https://api.shanshanstory.com/local.html");

        mWebView.setWebChromeClient(new WebChromeClient() {
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private boolean isSetLocalStorage = false;
    private class HelloWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView webView, String url) {
            super.onPageFinished(webView, url);
            if (!isSetLocalStorage) {
                String key = "requestcout";
                String value = "requestcout";
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    webView.evaluateJavascript("window.localStorage.setItem('" + key + "','" + value + "');", null);
                } else {
                    webView.loadUrl("javascript:localStorage.setItem('" + key + "','" + value + "');");
                }
                webView.reload();
            }
            isSetLocalStorage = true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWebView.clearCache(true);
    }
}