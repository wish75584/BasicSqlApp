package com.stubborn.basicsqlapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import androidx.core.app.ActivityCompat;

public abstract class FetchSms extends Context {



    String number = "+918484934914";
    long rowId;

    public ArrayList fetchSms(){

            ArrayList sms = new ArrayList();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                    != PackageManager.PERMISSION_GRANTED) {
               MainActivity.requestContactsPermissions();

                return  MainActivity.requestContactsPermissions();
            }

            Uri uriSms = Uri.parse("content://sms/inbox");
//        Cursor cursor = getContentResolver().query(uriSms,
//                new String[]{"_id", "address = '+918484934914'", "date", "body"}, null, null, null);

            String[] projection = new String[]{"_id", "address", "person", "body", "date", "type"};

            //for fetching particular contact sms sending value to querry
            Cursor cursor = getContentResolver().query(uriSms, projection, "address='+918484934914'", null, "date desc");

            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                String address = cursor.getString(1);
                String body = cursor.getString(3);
                long longdate = cursor.getLong(4);
                // String deafult_add = "+918484934914";

                String finalDate;
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(longdate);
                Date date = calendar.getTime();
                finalDate = date.toString();

                Log.e("adress****************", finalDate + "");
                Log.e("adress****************", address + "");
                Log.e("body*****************", body + "");


                sms.add("Date = " + finalDate + "\n Address = " + address + "\n" + "n SMS =  " + body);

                String uuid = UUID.randomUUID().toString();
                //FieldValue.serverTimestamp();
                Date dt = new Date();
                dt.setTime(date.getDate());

                String pdate = dt.getDate() + "-" + dt.getMonth() + "-" + dt.getYear();
                Modal modal = new Modal(finalDate, uuid, body,dt);
                insertingDatabase(modal);

            }
            return sms;

        }


    }




