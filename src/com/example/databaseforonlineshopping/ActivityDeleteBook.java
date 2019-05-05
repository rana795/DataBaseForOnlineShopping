package com.example.databaseforonlineshopping;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityDeleteBook extends Activity{

	EditText bookid=null;
	EditText bookname=null;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deletebook);
		
		this.bookid=(EditText)findViewById(R.id.ed1);
		this.bookname=(EditText)findViewById(R.id.ed2);
		
	}
	
	
	public void deleteButton(View v)
	{
		String key1,key2 = null;
		BookDataBase dbObj=new BookDataBase(ActivityDeleteBook.this, key2, null, 0);
		
		key1=this.bookid.getText().toString();
		key2=this.bookname.getText().toString();
		
		dbObj.DeleteFromDB(key1, key2);
		
		//Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
		//finish();
	}
	
	public void backButton(View v)
	{
		finish();
	}
	
}

	
	
