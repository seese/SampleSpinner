package com.example.micha.spinnersample;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.SupportActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static String[] TEXT_DISPLAY = new String[]{
            "System 1",
            "System 2",
            "System 3",
            "System 4",
            "System 5",
            "System 6",
            "System 7",
            "System 8",
            "System 9"
    };

    final static String[] TEXT_VALUES = new String[]{
            "a1",
            "a2",
            "a3",
            "a4",
            "a5",
            "a6",
            "a7",
            "a8",
            "a9",

    };

    private MenuItem camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        toolbar.setTitle("title1");
        toolbar.setSubtitle("title2");
        setSupportActionBar(toolbar);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner_toolbar);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, TEXT_DISPLAY);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, TEXT_VALUES[i], Toast.LENGTH_SHORT).show();

                if (camera != null) {
                    camera.setEnabled(i % 2 == 0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean rc = super.onCreateOptionsMenu(menu);

        camera = menu.add("Barcode");
        camera.setIntent(new Intent(this, ChildActivity.class));
        camera.setIcon(R.drawable.ic_action_name);
        camera.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        menu.add("world");

        return rc;
    }
}

