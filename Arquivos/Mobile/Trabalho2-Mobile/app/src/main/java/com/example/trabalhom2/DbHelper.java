package com.example.trabalhom2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DbHelper extends SQLiteOpenHelper {
    // Attributes
    private Context context;
    private static final String dbname = "restaurantDataBase.db"; // set the database name
    private static final String tableName = "menu";

    private static final String column_id = "_id";
    private static final String column_name = "name";
    private static final String column_description = "description";
    private static final String column_price = "price";
    private static final String column_gluten = "gluten";
    private static final String column_cal = "cal";
    private static final String column_image = "image";


    public DbHelper(Context context) { // Constructor
        super(context, dbname, null, 1); // send the database name
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table
        String query = "CREATE TABLE " + tableName +
                " (" + column_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                column_name + " TEXT, " + column_description + " TEXT, " +
                column_price + " TEXT, " + column_gluten + " TEXT, " +
                column_cal + " TEXT, " + column_image + " TEXT);";
        db.execSQL(query); // Execute query
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }

    void saveData(String name, String description, String price, String gluten, String cal, String image){ // Add new line to database
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(column_name, name);
        contentValues.put(column_description, description);
        contentValues.put(column_price, price);
        contentValues.put(column_gluten, gluten);
        contentValues.put(column_cal, cal);
        contentValues.put(column_image, image);

        long result = sqLiteDatabase.insert(tableName, null, contentValues);

        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            //return false;
        }
        else{
            Toast.makeText(context, "Added Succesfully", Toast.LENGTH_SHORT).show();
            //return true;
        }
    }

    public Cursor ViewData() { // Cursor to get data from database
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + tableName + ";", null);

        return cursor;
    }
}
