package com.example.databaseforonlineshopping;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class ActivityUpdateBook  extends Activity {

	EditText bookid =null;
	EditText bookname=null;
	EditText publishername=null;
	EditText authorname=null;
	EditText bookyear=null;
	EditText bookprice=null;
	String Key=null;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.updatebook);
		
			

		this.bookid=(EditText)findViewById(R.id.editTextbookid);
		this.bookname=(EditText)findViewById(R.id.editTextbookname);
		this.authorname=(EditText)findViewById(R.id.editTextauthorname);
		this.publishername=(EditText)findViewById(R.id.editTextpublishername);
		this.bookyear=(EditText)findViewById(R.id.editTextbookyear);
		this.bookprice=(EditText)findViewById(R.id.editTextbookprice);
		
	
	
		Intent intent = getIntent();
		this.Key=intent.getStringExtra(DBContractor.DB_Col_BookName);
		
		this.bookid.setText(intent.getStringExtra(DBContractor.DB_Col_BookId));
		this.bookname.setText(intent.getStringExtra(DBContractor.DB_Col_BookName));
	
		this.authorname.setText(intent.getStringExtra(DBContractor.DB_Col_AuthorName));
		this.publishername.setText(intent.getStringExtra(DBContractor.DB_Col_PublisherName));
		this.bookprice.setText(intent.getStringExtra(DBContractor.DB_Col_BookPrice));
		this.bookyear.setText(intent.getStringExtra(DBContractor.DB_Col_BookYear));
		
		
	}
	
	public void updateSaveButton(View v)
	{
		
		BookDataBase dbObj=new BookDataBase(ActivityUpdateBook.this, null, null, 0);
		ListBook bookobj=new ListBook();
		
		bookobj.setBookId(this.bookid.getText().toString());
		bookobj.setBookName(this.bookname.getText().toString());
		bookobj.setAuthorName(this.authorname.getText().toString());
		bookobj.setPublisheName(this.publishername.getText().toString());
		bookobj.setBookPrice(this.bookprice.getText().toString());
		bookobj.setBookYear(this.bookyear.getText().toString());	
	
		dbObj.updateIntoDb(this.Key,bookobj);
		
		Intent intent=new Intent(this,ActivityViewBook.class);
		startActivity(intent);
		//finish();
		

	}
	
	public void updateCancelButton(View v)
	{
		Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
		finish();
	}
	

}

	
	
	

	
	