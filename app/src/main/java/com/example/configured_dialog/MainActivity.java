package com.example.configured_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * author hadar ohana
 * 10.12.19
 */
public class MainActivity extends AppCompatActivity {

    final String[] colors = {"Red", "Green", "Blue"};
    int[] color;
    AlertDialog.Builder adb;
    LinearLayout ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = findViewById(R.id.ll);
    }

    /**
     * this mathod pops alert dialog that changes the color by the user choice
     * @param view
     */
    public void RGB(View view) {
        color = new int[]{0, 0, 0};

        adb = new AlertDialog.Builder(this);

        adb.setTitle("choose color");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which] = 255;
                ll.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }


        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * this mathod pops alart dialog that changes the color of the background by the user choice and combines the ccolors if the user choose more then one
     * @param view
     */
    public void RGBplus(View view) {
        color = new int[]{0, 0, 0};

        adb = new AlertDialog.Builder(this);

        adb.setTitle("choose colors combination for the background");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                color[which] = 255;
            }
        });

        adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();

    }

    /**
     * this method changes the background to white color
     * @param view
     */
    public void Reset(View view) {
        ll.setBackgroundColor(Color.WHITE);
    }

    /**
     * this method pops alert and toast the text that the user chose
     * @param view
     */
    public void Toast(View view) {
        adb = new AlertDialog.Builder(this);

        adb.setTitle("toast massege:");
        final EditText et = new EditText(this);
        et.setHint("input");
        adb.setView(et);

        adb.setPositiveButton("Toast", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = et.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * this method creates option manu with credits
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 250, "Credits");
        return true;
    }

    /**
     * checes what the user chose and
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("Credits")) {
            Intent si = new Intent(this, Main2Activity.class);
            startActivity(si);

        }
        return true;
    }
}


