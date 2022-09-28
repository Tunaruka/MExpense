package com.example.mexpense;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mexpense.data.TripEntity;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "tripDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "trips";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESTINATION = "destination";
    private static final String KEY_TYPE = "type";
    private static final String KEY_DATE = "date";
    private static final String KEY_RISK = "risk";
    private static final String KEY_DESCRIPTION = "description";

    public DatabaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_trips_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                TABLE_NAME, KEY_ID, KEY_TITLE, KEY_DESTINATION, KEY_TYPE, KEY_DATE, KEY_RISK, KEY_DESCRIPTION);
        db.execSQL(create_trips_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_trips_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_trips_table);
        onCreate(db);
    }

    public void addTrip(TripEntity trip) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, trip.getTitle());
        values.put(KEY_DESCRIPTION, trip.getDestination());
        values.put(KEY_TYPE, trip.getType());
        values.put(KEY_DATE, trip.getDate());
        values.put(KEY_RISK, trip.getRisk());
        values.put(KEY_TITLE, trip.getTitle());
        values.put(KEY_TITLE, trip.getTitle());


        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}
