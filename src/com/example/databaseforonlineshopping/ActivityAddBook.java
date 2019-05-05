package com.example.databaseforonlineshopping;


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;

import android.widget.Toast;

public class ActivityAddBook extends Activity {

	EditText bookid =null;
	EditText bookname=null;
	EditText publishername=null;
	EditText authorname=null;
	EditText bookyear=null;
	EditText bookprice=null;
	
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addbook);
		
			

		this.bookid=(EditText)findViewById(R.id.editTextbookid);
		this.bookname=(EditText)findViewById(R.id.editTextbookname);
		this.authorname=(EditText)findViewById(R.id.editTextauthorname);
		this.publishername=(EditText)findViewById(R.id.editTextpublishername);
		this.bookyear=(EditText)findViewById(R.id.editTextbookyear);
		this.bookprice=(EditText)findViewById(R.id.editTextbookprice);
		
	
	
		
	}
	
	
	
	
	public void showInvalidInputDialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Error Input");
		
		builder.setMessage("Please Fill all the Fields!");
		builder.setPositiveButton("OK", null);
		
		AlertDialog dialog=builder.create();
		dialog.show();
		
	}

	
	public void saveButton(View v)
	{
		
		BookDataBase dbObj=new BookDataBase(ActivityAddBook.this, null, null, 0);
		ListBook bookobj=new ListBook();
		
		if(bookid.getText().length()==0 || bookname.getText().length()==0 ||authorname.getText().length()==0
				||  publishername.getText().length()==0 
				|| bookyear.getText().length()==0 || bookprice.getText().length()==0)
		{
			showInvalidInputDialog();
		}
		
		else
		{
		bookobj.setBookId(this.bookid.getText().toString());
		bookobj.setBookName(this.bookname.getText().toString());
		bookobj.setAuthorName(this.authorname.getText().toString());
		bookobj.setPublisheName(this.publishername.getText().toString());
		bookobj.setAuthorName(this.authorname.getText().toString());
		bookobj.setBookYear(this.bookyear.getText().toString());
		bookobj.setBookPrice(this.bookprice.getText().toString());
		
		
		dbObj.insertIntoDb(bookobj);
		finish();
		}
		
		

	}
	
	public void cancelButton(View v)
	{
		Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
		finish();
	}
	
}
