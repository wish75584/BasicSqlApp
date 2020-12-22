package com.stubborn.basicsqlapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final String CREATE_DATABASE = "db_test";
    private static final Integer DATABSE_VERSION = 1;
    public static final String CREATE_TABLE = "CREATE TABLE TEST (note_id text,note_title text,note_body text,note_created_at text,note_time_at text)";

    public DbHelper(@Nullable Context context) {
        super(context, CREATE_TABLE, null, DATABSE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
