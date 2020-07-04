package com.example.maps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    public static final String TAG = ThirdActivity.class.getName();
    private TextView label;
    private Button btnNext;
    private Button btnDialog ;
    private Button btnFirstActivity;
    private Button btnSecondActivity;
    private Button btnThirdActivity;
    private Button btnForthActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        btnNext = (Button) findViewById(R.id.BTN_next);
        btnDialog = (Button) findViewById(R.id.BTN_dialog);
        btnFirstActivity = (Button) findViewById(R.id.BTN_first_Activity);
        btnSecondActivity = (Button) findViewById(R.id.BTN_second_activity);
        btnThirdActivity = (Button) findViewById(R.id.BTN_third_activity);
        btnForthActivity = (Button) findViewById(R.id.BTN_forth_activity);
        label = (TextView) findViewById(R.id.TV_current_activity_name);
        label.setText(TAG);
        Log.v(TAG, "I'm onCreate()");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThirdActivity.this, ForthActivity.class));
            }
        });
        btnFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThirdActivity.this, FirstActivity.class));
            }
        });
        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThirdActivity.this, SecondActivity.class));
            }
        });
        btnThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThirdActivity.this, ThirdActivity.class));
            }
        });
        btnForthActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThirdActivity.this, ForthActivity.class));
            }
        });
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        // restoring the instance if exist
        if (savedInstanceState != null) {
            String labelFromInstance = savedInstanceState.getString("activityName");
            label.setText(TAG);
        }
        setupTaskList();
    }

    private void setupTaskList() {
    }

    private void openDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_fire_missiles)
                .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        builder.setCancelable(false).create().show();
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // saving an instance
        outState.putString("activityName", TAG);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.v(TAG+"newIntent", intent.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "I'm onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "I'm onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "I'm onRestart()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "I'm onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "I'm onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "I'm onDestroy()");
    }
}
