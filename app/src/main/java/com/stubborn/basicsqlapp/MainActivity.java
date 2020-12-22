package com.stubborn.basicsqlapp;

import android.Manifest;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {


    String[] PERMISSIONS = {Manifest.permission.READ_SMS};
    EditText title, body;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        title = findViewById(R.id.title);
//        body = findViewById(R.id.body);
//        submit = findViewById(R.id.submit);

        DbHelper dbHelper = new DbHelper(this);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        ListView lViewSMS = (ListView) findViewById(R.id.listViewSMS);
        FetchSms fetchSms1 = new FetchSms();
        if (fetchSms1.fetchSms() != null) {
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fetchInbox());
            lViewSMS.setAdapter(adapter);
        }
    }





    public static ArrayList requestContactsPermissions() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_SMS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
        } else {
            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
        }
        return null;
    }
}
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String TITLE = title.getText().toString();
//                String BODY = body.getText().toString();
//
//                ContentValues values = new ContentValues();
//                values.put("note_title", TITLE);
//                values.put("note_body", BODY);
//
//                // values.put(BODY, "note_body");
//                long newRowId = db.insert("TEST", null, values);
//
//                Log.e(String.valueOf(newRowId), "onClick:newRowId ");
//
//                if (newRowId >= 1) {
//                    Toast.makeText(MainActivity.this, "data uploaded susccessfully", Toast.LENGTH_SHORT).show();
//                }
////                Log.e(String.valueOf(db.insert("TEST", null, values)), "onClick:querry ");
//
//
//            }
//        });
//
//
//    }