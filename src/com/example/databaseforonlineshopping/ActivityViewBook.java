package com.example.databaseforonlineshopping;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;



public class ActivityViewBook  extends Activity {
	
	ListView listview=null;
	ArrayList<ListBook> bookArr;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewbook);
		
		listview=(ListView)findViewById(R.id.listView1);
		
		BookDataBase bookDb=new BookDataBase(this, null, null, 0);
		bookArr=new ArrayList<ListBook>();
		
		bookArr=bookDb.RetriveFromDb();
		
		BookBaseAdapter bbookadap=new BookBaseAdapter(this,bookArr);
		
		listview.setAdapter(bbookadap);
		
		listview.setOnItemClickListener(listener); 
		
	}
	
	OnItemClickListener listener =new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int index,
				long arg3) {
			
			Intent intent=new Intent(ActivityViewBook.this,ActivityUpdateBook.class);
			//intent.putExtra("caller","updateCall");
			intent.putExtra(DBContractor.DB_Col_BookId, bookArr.get(index).getBookId());
			intent.putExtra(DBContractor.DB_Col_BookName, bookArr.get(index).getBookName());
			intent.putExtra(DBContractor.DB_Col_AuthorName, bookArr.get(index).getAuthorName());
			intent.putExtra(DBContractor.DB_Col_PublisherName, bookArr.get(index).getPublisherName());
		 	intent.putExtra(DBContractor.DB_Col_BookYear, bookArr.get(index).getBookYear());
			intent.putExtra(DBContractor.DB_Col_BookPrice, bookArr.get(index).getBookPrice());			
			
			startActivity(intent);
			
			//Toast.makeText(ActivityViewEmployee.this, "Hello "+bookArr.get(index).getFirstName(), Toast.LENGTH_SHORT).show();
			
		}
	};


	public void backToMain(View v)
	{
		Intent intent=new Intent (this,MainActivity.class);
		startActivity(intent);
	}
	
}


