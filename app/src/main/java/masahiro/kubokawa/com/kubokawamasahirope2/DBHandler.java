package masahiro.kubokawa.com.kubokawamasahirope2;

import android.app.Person;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "personDB";
    private static final String TABLE = "personRecords";
    private static final String KEY_ID = "id";
    private static final String KEY_FNAME = "fname";
    private static final String KEY_AGE = "age";
    private static final String KEY_GENDER = "gender";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        String CREATE_PERSON_TABLE = "CREATE TABLE " + TABLE + "(" + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + KEY_FNAME + "TEXT" +
                KEY_AGE + "TEXT" + KEY_GENDER + "TEXT" + ")";
        db.execSQL(CREATE_PERSON_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public void addRecord(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FNAME, person.getFnamr());
        values.put(KEY_AGE, person.getAge());
        values.put(KEY_GENDER, person.getGender());

        db.insert(TABLE, null, values);
        db.close();
    }
}
