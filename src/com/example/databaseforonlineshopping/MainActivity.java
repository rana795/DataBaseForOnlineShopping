package com.example.databaseforonlineshopping;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void addbook(View V)
	{
		Intent i=new Intent(this,ActivityAddBook.class);
		startActivity(i);
	}
	
	public void viewAll(View v)
	{
		Intent intent = new Intent(this,ActivityViewBook.class);
		startActivity(intent);
		
	}
	
	public void deletebook(View v)
	{
		Intent intent = new Intent(this,ActivityDeleteBook.class);
		startActivity(intent);
		
	}
	
	public void logout(View v)
	{
		Intent i=new Intent(this,Login.class);
		startActivity(i);
	}
	
	public void exitApp(View v)
	{
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);	
	}
	
	
	
}
