package com.example.dawi8961.adaptiveicontest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Window window = getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String url = "https://play.google.com/store/apps/details?id=com.esri.explorer";
        final Intent downloadApp = new Intent(Intent.ACTION_VIEW);
        downloadApp.setData(Uri.parse(url));

        ConstraintLayout mainLayout = findViewById(R.id.mainLayout);
        CoordinatorLayout snackbarLayout = findViewById(R.id.snackbarLayout);

        switch (item.getItemId()) {
            case R.id.action_search:
            case R.id.action_bookmark:
            case R.id.action_layers:
            case R.id.action_basemap:
            case R.id.action_measure:
            case R.id.action_markup:
                Snackbar menuOptionsSnackbar = Snackbar
                    .make(snackbarLayout, R.string.menuOptionSnackbar, Snackbar.LENGTH_LONG)
                    .setAction("DOWNLOAD", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(downloadApp);
                        }
                    });

                menuOptionsSnackbar.show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
