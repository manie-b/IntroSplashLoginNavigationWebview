package com.example.manish.apptopintro22;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Navigation_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        wv= (WebView) findViewById(R.id.webView1);
        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);

        wv.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wv.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        wv.getSettings().setAppCacheEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setSavePassword(true);
        settings.setSaveFormData(true);

        wv.loadUrl("https://www.google.co.in");
        wv.setWebViewClient(new MywebViewClient());


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Navigation_Main/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Login) {

            wv.loadUrl("http://ssteckservices.com:8080/collegeapps/login.xhtml");


            Intent intent = getIntent();
            String user_name = intent.getStringExtra("user");
            String pass_name = intent.getStringExtra("pass");
            wv.loadUrl("javascript: var x = document.getElementById('user').value = '" + user_name + "';" +
                    "var y = document.getElementById('pass').value = '" + pass_name + "';" +
                    "var form1 = document.getElementById('submit');" +
                    "form1[0].submit(); ");
            wv.setWebViewClient(new MywebViewClient());


            wv.requestFocus();
//            return true;
        }
        else if (id==R.id.Logout){

            wv.loadUrl("http://ssteckservices.com:8080/collegeapps/logout.xhtml");

            Toast.makeText(getApplicationContext(), "Logout Successful!", Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.OnlineStudent) {
            wv.loadUrl("https://www.instagram.com");
            // Handle the camera action
        }
        else if (id == R.id.Update) {
            wv.loadUrl("https://www.facebook.com");

        }
        else if (id == R.id.Date_wise_Report) {
            wv.loadUrl("https://twitter.com");

        }
        else if (id == R.id.Offline) {
            wv.loadUrl("https://login.skype.com");

        }
        else if (id == R.id.OnlineStaff) {
            wv.loadUrl("https://in.linkedin.com");

        }
        else if (id == R.id.DateWiseReport) {
            wv.loadUrl("https://web.telegram.org");

        }
        else if (id == R.id.UpdateStaff) {
            wv.loadUrl("https://www.youtube.com");

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return false;
    }

    private class MywebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (Uri.parse(url).getHost().equals("https://www.google.co.in")){

                return false;
            }

            else {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                startActivity(intent);

                return true;

            }
        }

        ProgressDialog pd = null;

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            pd = new ProgressDialog(Navigation_Main.this);
            pd.setTitle("please wait...");
            pd.setMessage("Connect To Network...");
            pd.show();
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            pd.dismiss();
            super.onPageFinished(view, url);
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction()== KeyEvent.ACTION_DOWN){

            switch(keyCode){
                case KeyEvent.KEYCODE_BACK:

                    if(wv.canGoBack()){

                        wv.goBack();
                    }

                    else{

                        finish();
                    }

                    return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }

}
