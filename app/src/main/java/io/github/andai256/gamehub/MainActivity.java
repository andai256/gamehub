package io.github.andai256.gamehub;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/** Hosts the offline GameHub HTML game in a WebView. No network access is used. */
public class MainActivity extends Activity {
    private static final String START_URL = "file:///android_asset/index.html";
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        web = new WebView(this);
        setContentView(web);

        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);          // localStorage (profiles, scores, settings)
        s.setAllowFileAccess(true);            // needed for file:///android_asset
        s.setAllowContentAccess(false);
        s.setAllowFileAccessFromFileURLs(false);
        s.setAllowUniversalAccessFromFileURLs(false);
        s.setBlockNetworkLoads(true);          // fully offline
        s.setTextZoom(100);

        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                // Never navigate away from the bundled game.
                return !request.getUrl().toString().startsWith("file:///android_asset/");
            }
        });

        if (savedInstanceState != null) {
            web.restoreState(savedInstanceState);
        } else {
            web.loadUrl(START_URL);
        }
        web.requestFocus();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        web.saveState(outState);
    }

    @Override
    protected void onPause() {
        web.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        web.onResume();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onBackPressed() {
        // Step back through the game's own screens; leave the app from the profile screen.
        String js = "(function(){"
            + "function on(id){var e=document.getElementById(id);return e&&e.classList.contains('active');}"
            + "try{"
            + "if(on('screen-profile'))return 'exit';"
            + "if(on('screen-game')){exitGame();return 'ok';}"
            + "if(on('screen-menu')){showProfile();return 'ok';}"
            + "showScreen('menu');return 'ok';"
            + "}catch(e){return 'exit';}})()";
        web.evaluateJavascript(js, value -> {
            if (value == null || value.contains("exit")) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (web != null) {
            web.destroy();
        }
        super.onDestroy();
    }
}
