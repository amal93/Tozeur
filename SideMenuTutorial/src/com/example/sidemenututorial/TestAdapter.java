package com.example.sidemenututorial;


import java.io.IOException; 







import java.util.ArrayList;
import java.util.List;

import android.content.Context; 
import android.database.Cursor; 
import android.database.SQLException; 
import android.database.sqlite.SQLiteDatabase; 
import android.util.Log; 
import android.widget.EditText;
import android.widget.TextView;
 
public class TestAdapter  
{ 
    protected static final String TAG = "DataAdapter"; 
   
    private final Context mContext; 
    private SQLiteDatabase mDb; 
    private DataBaseHelper mDbHelper; 
 
    public TestAdapter(Context context)  
    { 
        this.mContext = context; 
        mDbHelper = new DataBaseHelper(mContext); 
    } 
 
    
    


	public TestAdapter createDatabase() throws SQLException  
    { 
        try  
        { 
            mDbHelper.createDataBase(); 
        }  
        catch (IOException mIOException)  
        { 
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase"); 
            throw new Error("UnableToCreateDatabase"); 
        } 
        return this; 
    } 
 
    public TestAdapter open() throws SQLException  
    { 
        try  
        { 
            mDbHelper.openDataBase(); 
            mDbHelper.close(); 
            mDb = mDbHelper.getReadableDatabase(); 
        }  
        catch (SQLException mSQLException)  
        { 
            Log.e(TAG, "open >>"+ mSQLException.toString()); 
            throw mSQLException; 
        } 
        return this; 
    } 
 
    public void close()  
    { 
        mDbHelper.close(); 
    } 
 
     public Cursor getTestData() 
     
     
     { 
    	 try 
         { 
             String sql ="SELECT nom_t, designation  FROm hotel"; 
 
             Cursor mCur = mDb.rawQuery(sql, null); 
             if (mCur!=null) 
             { 
                mCur.moveToNext(); 
                
             } 
             return mCur;
         } 
         catch (SQLException mSQLException)  
         { 
             Log.e(TAG, "getTestData >>"+ mSQLException.toString()); 
             throw mSQLException; 
         } 
     }

	
     
     public List<liste> getAll()
     { String nom,des;
    	 String sql ="SELECT nom_t, designation  FROm hotel"; 
    	 ArrayList array_list = new ArrayList();
    	 
    	 
    	 Cursor mCur = mDb.rawQuery(sql, null); 
    	 
    	 mCur.moveToFirst();
    	 while(mCur.isAfterLast() == false)
    	 { nom= mCur.getString(0);
    	des= mCur.getString(1);
    		 
    		 array_list.add(nom + des);
    		 mCur.moveToNext(); 
    		 }
    	 return array_list;
     }
 	}
     




	


