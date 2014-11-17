package baze;

import java.io.File;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class SQLiteTerapija extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "TTT";
	private static final String TABLE_TERAPIJA = "Terapija";

	private static final String[] COLUMNS = { "id", "spisak", "sat", "minut",
			"kolicina", "aktivna" };

	// OVO JE DA MOZES DA CITAS IZ FOLDERA /BAZE U TELEFONU
	public SQLiteTerapija(Context context) {
		super(context, Environment.getExternalStorageDirectory()
				+ File.separator + "baze" + File.separator + DATABASE_NAME,
				null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
// zamenio vreme na LONG, videti da li radi
		String cr = "CREATE TABLE " + getTableTerapija() + "(" + "id"
				+ " INTEGER PRIMARY KEY," + "spisak TEXT," + "sat TEXT,"+ "minut TEXT,"
				+ "kolicina TEXT," + "aktivna TEXT)";

		try {
			db.execSQL(cr);
			Log.d("adsf", "agsga");
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			Log.d("dsa", "ASDSAD");
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS" + getTableTerapija());
		onCreate(db);
	}

	public void dodajTerapiju(int id, String s, String sat, String minut, String k, String a) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("id", id);
		values.put("spisak", s);
		values.put("sat", sat);
		values.put("minut", minut);
		values.put("kolicina", k);
		values.put("aktivna", a);
		
		db.insert(getTableTerapija(), null, values);
		db.close();
	}

	public String vratiTerapiju(int id) {

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor y = db.query(getTableTerapija(), getColumns(), "id=?",
				new String[] { String.valueOf(id) }, null, null, null, null);

		String x = "";

		if (y.moveToNext()) {
			x = y.getString(1) + ":::" + y.getString(2) + ":::"
					+ y.getString(3) + ":::" + y.getString(4);
		}

		return x;
	}
	
//	public String vratiTerapiju1() {
//
//		SQLiteDatabase db = this.getReadableDatabase();
//
//		Cursor y = db.query(TABLE_TERAPIJA, COLUMNS, null,
//				null, null, null, null, null);
//		String x = "";
//		
//		//x += Integer.toString(y.getCount());
//		if (y.moveToNext()) {
//			x += y.getString(0) +":::"+ y.getString(1) + ":::" + y.getString(2) + ":::"
//					+ y.getString(3) + ":::" + y.getString(4) + " |||";
//		}
//
//		return x;
//	}
	
	public Cursor queueAll() {
		SQLiteDatabase db = this.getWritableDatabase();
	    return db.query(getTableTerapija(), getColumns(), null, null, null, null, null, null);
	    
	} 
	
	public String vratiNaziv1(int id) {

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor y = queueAll();
		
		String x = "";
		if(y.moveToNext()){
			x += y.getString(0)+ " "+y.getString(1);
		}

		return x;
	}
	
	public String vratiNaziv() {

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor y = db.query(getTableTerapija(), getColumns(), null,
				null, null, null, null, null);
		
		String x = "";
		if(y.moveToNext()){
			x += y.getString(1);
		}

		return x;
	}
	

	public String vratiID() {

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor y = db.query(getTableTerapija(), getColumns(), null,
				null, null, null, null, null);
		
		String x = "";
		if(y.moveToNext()){
			x += y.getString(0);
		}

		return x;
	}
	
	public String vratiSat() {

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor y = db.query(getTableTerapija(), getColumns(), null,
				null, null, null, null, null);
		
		String x = "";
		if(y.moveToNext()){
			// zasto mi ovde pozicije gleda drugacije nego u vratiNaziv?
			x =y.getString(2);
		}

		return x;
	}
	
	public String vratiMinut() {

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor y = db.query(getTableTerapija(), getColumns(), null,
				null, null, null, null, null);
		
		String x = "";
		if(y.moveToNext()){
			// zasto mi ovde pozicije gleda drugacije nego u vratiNaziv?
			x =y.getString(3);
		}

		return x;
	}

	public static String getTableTerapija() {
		return TABLE_TERAPIJA;
	}

	public static String[] getColumns() {
		return COLUMNS;
	}

	// public int updateTerapija(int id, String s, String v, String k, String a)
	// {
	//
	// // 1. get reference to writable DB
	// SQLiteDatabase db = this.getWritableDatabase();
	//
	// // 2. create ContentValues to add key "column"/value
	// ContentValues values = new ContentValues();
	// values.put("spisak", s);
	// values.put("vreme", v);
	// values.put("kolicina", k);
	// values.put("aktivna", a);
	//
	// // 3. updating row
	// int i = db.update(TABLE_TERAPIJA, // table
	// values, // column/value
	// "id=?", // selections
	// new String[] { String.valueOf(id) }); // selection args
	//
	// // 4. close
	// db.close();
	//
	// return i;
	//
	// }
}
