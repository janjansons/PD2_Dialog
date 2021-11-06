package com.example.pd2_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.DialogTitle);
    }
    public void openActivity2(View view) {
        startActivity(new Intent(this, MainActivity2.class));
    }

    public void open(View view) {
        showAlertDialog();
    }
    public void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("3. Groups Dialog");
        alertDialog.setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
            public void  onClick(DialogInterface dialog, int id) {
               Toast.makeText(MainActivity.this, "You clicked OK", Toast.LENGTH_LONG).show();
                }
         });
        alertDialog.setNegativeButton(R.string.Close, new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
               Toast.makeText(MainActivity.this, "You closed dialog", Toast.LENGTH_LONG).show();
                 }
        });
        String[] items = {"Jānis Jansons","Gunārs Božis","Normunds Vējiņš"};
        boolean[] checkedItems = {false, false, false, false, false,false};
        alertDialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                switch (which) {
                    case 0:
                        if(isChecked)
                            Toast.makeText(MainActivity.this, "Jānis Jansons checked", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Jānis Jansons unchecked", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        if(isChecked)
                            Toast.makeText(MainActivity.this, "Gunārs Božis checked", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Gunārs Božis unchecked", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        if(isChecked)
                            Toast.makeText(MainActivity.this, "Normunds Vējiņš checked", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Normunds Vējiņš unchecked", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }
}