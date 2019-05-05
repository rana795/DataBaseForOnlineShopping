package com.example.databaseforonlineshopping;





import java.util.ArrayList;








import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class BookDataBase extends  SQLiteOpenHelper {
	
	Context myContext=null;
	SQLiteDatabase mydatabase=null;
	
	public BookDataBase(Context context, String name, CursorFactory factory,
			int version) {
		//super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		super(context, DBContractor.DB_Name, null, DBContractor.DB_Version);
		this.myContext=context;
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String createTableQuery=
				"CREATE TABLE "+DBContractor.DB_TableName
					  +" ("
					  + DBContractor.DB_Col_BookId +" VARCHAR PRIMARY KEY , "
					  + DBContractor.DB_Col_BookName + " VARCHAR ,"
					  + DBContractor.DB_Col_AuthorName + " VARCHAR ,"
					  + DBContractor.DB_Col_PublisherName + " VARCHAR ,"
					  + DBContractor.DB_Col_BookYear + " VARCHAR ,"
					  + DBContractor.DB_Col_BookPrice + " VARCHAR " + ")";
		db.execSQL(createTableQuery);	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void openReadableDataBase()
	{
		this.mydatabase=this.getReadableDatabase();
	}
	
	public void openWriteableDataBase()
	{
		this.mydatabase=this.getWritableDatabase();
	}
	
	public synchronized void CloseDb()
	{
		if(mydatabase!=null)
		{
			mydatabase.close();
		}
		
		super.close();
		
	}
	
	public void insertIntoDb(ListBook data)
	{
		openWriteableDataBase();
		
		ContentValues values=new ContentValues();
		values.put(DBContractor.DB_Col_BookId, data.getBookId());
		values.put(DBContractor.DB_Col_BookName, data.getBookName());
		values.put(DBContractor.DB_Col_AuthorName, data.getAuthorName());
		values.put(DBContractor.DB_Col_PublisherName, data.getPublisherName());
		values.put(DBContractor.DB_Col_BookYear, data.getBookYear());
		values.put(DBContractor.DB_Col_BookPrice, data.getBookPrice());
		
			
		
		mydatabase.insert(DBContractor.DB_TableName, null, values);
		CloseDb();
		Toast.makeText(myContext, "Saved Sucessfully!", Toast.LENGTH_SHORT).show();
	
	}
	
	public ArrayList<ListBook> RetriveFromDb()
	{
		ListBook book=null;
		
		ArrayList<ListBook> bookArr=new ArrayList<ListBook>();
		
		openReadableDataBase();
		
		String selectQuery="SELECT * FROM "+DBContractor.DB_TableName;

		Cursor cursor = mydatabase.rawQuery(selectQuery, null);
		
		if(cursor!=null)
		{
			if(cursor.getCount()>0)
			{
				cursor.moveToFirst();
				   do{  
					   book=new ListBook();
					   
					   int index=cursor.getColumnIndex(DBContractor.DB_Col_BookId);
					   book.setBookId(cursor.getString(index));
					   
					   index=cursor.getColumnIndex(DBContractor.DB_Col_BookName);
					   book.setBookName(cursor.getString(index));
					   
					   index=cursor.getColumnIndex(DBContractor.DB_Col_AuthorName);
					   book.setAuthorName(cursor.getString(index));
					  
					   index=cursor.getColumnIndex(DBContractor.DB_Col_PublisherName);
					   book.setPublisheName(cursor.getString(index));
					   
					   index=cursor.getColumnIndex(DBContractor.DB_Col_BookYear);
					   book.setBookYear(cursor.getString(index));
					   
					   index=cursor.getColumnIndex(DBContractor.DB_Col_BookPrice);
					   book.setBookYear(cursor.getString(index));
					 
					 
					    
				   		
					   bookArr.add(book);
				   }while(cursor.moveToNext());							
			}
		}
			
		cursor.close();
		this.CloseDb();	
		
		return bookArr;
	}

	public void updateIntoDb(String key,ListBook data)
	{
		openWriteableDataBase();
		if(mydatabase.isOpen())
		{
			ContentValues values=new ContentValues();
			values.put(DBContractor.DB_Col_BookId, data.getBookId());
			values.put(DBContractor.DB_Col_BookName, data.getBookName());
			values.put(DBContractor.DB_Col_AuthorName, data.getAuthorName());
			values.put(DBContractor.DB_Col_PublisherName, data.getPublisherName());
			values.put(DBContractor.DB_Col_BookYear, data.getBookYear());
			values.put(DBContractor.DB_Col_BookPrice, data.getBookPrice());
		
			mydatabase.update(DBContractor.DB_TableName, values,
							DBContractor.DB_Col_BookName+" = '" +key+ "'" , null);
			
			Toast.makeText(myContext, "Updated Successfully!", Toast.LENGTH_SHORT).show();
			
		}
		
	}
	
	public void DeleteFromDB(String key1,String key2)
	{
		openWriteableDataBase();
		if(mydatabase.isOpen())
		{
			ContentValues values=new ContentValues();
			
			int success=mydatabase.delete(DBContractor.DB_TableName,DBContractor.DB_Col_BookId+
						" = '" +key1+"' AND " +DBContractor.DB_Col_BookName+" = '"+ key2+ "'" , null);	
			
			if(success==0)
				showFailDeleteDialog();

			else
				showSuccessDeleteDialog(key1);				
		}
			
	}
	
	public void showSuccessDeleteDialog(String name)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(myContext);
		builder.setTitle("Deletion Success");
		
		builder.setMessage(" Book with Id "+name+ " Deleted Successfully!");
		builder.setPositiveButton("OK", null);
		
		AlertDialog dialog=builder.create();
		dialog.show();
		
	}
	
	public void showFailDeleteDialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(myContext);
		builder.setTitle("Error in Deletion");
		
		builder.setMessage("Invalid Input! No such record exists");
		builder.setPositiveButton("OK", null);
		
		AlertDialog dialog=builder.create();
		dialog.show();
		
	}
}
