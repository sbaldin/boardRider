package goodline.info.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ������ ������ on 12.05.2015.
 */
public class DatabaseWrapper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseWrapper";

    private static final String DATABASE_NAME = "NewsDatabase.db";
    private static final int DATABASE_VERSION = 2;

    public DatabaseWrapper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called if the database named DATABASE_NAME doesn't exist in order to create it.
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i(TAG, "Creating database [" + DATABASE_NAME + " v." + DATABASE_VERSION + "]...");
        sqLiteDatabase.execSQL(BoardNewsORM.SQL_CREATE_TABLE);
        sqLiteDatabase.close();
    }

    /**
     * Called when the DATABASE_VERSION is increased.
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.i(TAG, "Upgrading database ["+DATABASE_NAME+" v." + oldVersion+"] to ["+DATABASE_NAME+" v." + newVersion+"]...");
        sqLiteDatabase.execSQL(BoardNewsORM.SQL_DROP_TABLE);
        onCreate(sqLiteDatabase);
    }
}