package com.example.mexpense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mexpense.data.TripEntity;

import java.util.ArrayList;
import java.util.List;

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

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
        values.put(KEY_DESTINATION, trip.getDestination());
        values.put(KEY_TYPE, trip.getType());
        values.put(KEY_DATE, trip.getDate());
        values.put(KEY_RISK, trip.getRisk());
        values.put(KEY_DESCRIPTION, trip.getDescription());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public TripEntity getTrip(int tripId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_ID + " = ?", new String[] { String.valueOf(tripId) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        TripEntity student = new TripEntity(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getInt(5),
                cursor.getString(6)
        );
        return student;
    }

    public List<TripEntity> getAllTrips() {
        List<TripEntity>  tripList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            TripEntity trip = new TripEntity(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getString(6)
            );
            tripList.add(trip);
            cursor.moveToNext();

        }
        return tripList;
    }

    public void updateTrip(TripEntity trip) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, trip.getTitle());
        values.put(KEY_DESCRIPTION, trip.getDestination());
        values.put(KEY_TYPE, trip.getType());
        values.put(KEY_DATE, trip.getDate());
        values.put(KEY_RISK, trip.getRisk());
        values.put(KEY_DESCRIPTION, trip.getDescription());
        db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[] { String.valueOf(trip.getId()) });
        db.close();
    }

    public void deleteTrip(int tripId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?", new String[] { String.valueOf(tripId) });
        db.close();
    }


}
