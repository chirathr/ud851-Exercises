package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// TODO (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "waitlist.db";

    // TODO (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"

    // TODO (3) Create a static final int called DATABASE_VERSION and set it to 1

    static final int DATABASE_VERSION = 1;

    // TODO (4) Create a Constructor that takes a context and calls the parent constructor

    public WaitlistDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // TODO (5) Override the onCreate method

        // TODO (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table

        // TODO (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_WAITLIST_TABLE = "create table " +
                WaitlistContract.WaitlistEntry.TABLE_NAME + "( " +
                WaitlistContract.WaitlistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME + " text not null" + " ," +
                WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE + " integer not null" + " ," +
                WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP + " timestamp default current_timestamp" +
                ");";
        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }


    // TODO (8) Override the onUpgrade method

        // TODO (9) Inside, execute a drop table query, and then call onCreate to re-create it

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "drop table if exists " + WaitlistContract.WaitlistEntry.TABLE_NAME + ";";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

}