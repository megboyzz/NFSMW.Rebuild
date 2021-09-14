package com.ea.ironmonkey.devmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ea.games.nfs13_na.BuildConfig;
import com.ea.games.nfs13_na.R;
import com.ea.ironmonkey.GameActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends Activity {

    private final String LOG_TAG = "InjectedActivity";

    private void runGame() {

        Intent GoToGame = new Intent(this, GameActivity.class);
        startActivity(GoToGame);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String flag;

        File activityFlag = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/mode.txt");
        try {
            Log.d(LOG_TAG, "activityFlag is exists))");

            BufferedReader reader = new BufferedReader(new FileReader(activityFlag));

            flag = reader.readLine();

        } catch (FileNotFoundException e) {
            Log.e(LOG_TAG, "FileNotFoundException " + e.getLocalizedMessage());
            flag = "false";
        } catch (IOException e) {
            Log.e(LOG_TAG, "IOException " + e.getLocalizedMessage());
            flag = "false";
        }

        if (flag == null || !flag.equals("true")) runGame();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom);

        String title = String.format(getString(R.string.dev_menu_title), BuildConfig.DEV_MENU_VERSION);

        getActionBar().setTitle(title);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.optionRunTheGame: {
                runGame();
            }
            break;

            case R.id.optionSettings: {

                Intent GoToSettings = new Intent(this, InjectedSettingsActivity.class);
                startActivity(GoToSettings);

            }
            break;
            case R.id.optionDeleteData: {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("lol");
                builder.setMessage("Hello, world!");
                builder.setPositiveButton("OK", (dialogInterface, i) -> {
                    Toast.makeText(MainActivity.this, "Deleted)", Toast.LENGTH_LONG).show();
                });
                builder.setNegativeButton("Cancel", (dialogInterface, i) -> {

                });
                builder.show();

            }
            break;

        }

        return super.onOptionsItemSelected(item);
    }


}