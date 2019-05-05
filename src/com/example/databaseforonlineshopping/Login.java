package com.example.databaseforonlineshopping;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity{

	
	EditText userName=null;
	EditText pass=null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		userName=(EditText)findViewById(R.id.usernameEditText);
		pass=(EditText)findViewById(R.id.passwordEditText);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void login(View argo)
	{
		String user=null,paswd=null;
		user=this.userName.getText().toString();
		paswd=this.pass.getText().toString();
		
		if(user.equals("rana") && paswd.equals("mad"))
		{
			Toast.makeText(this, "Welcome "+user+"!", Toast.LENGTH_LONG).show();
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			
		}
		else
		{
			showInvalidUserDialog();
			
			//Toast.makeText(this, "Bye "+user+"!", Toast.LENGTH_LONG).show();
		}	
	}
	
	public void showInvalidUserDialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Error Login");
		
		builder.setMessage("Invalid UserName or Password!");
		builder.setPositiveButton("OK", null);
		
		AlertDialog dialog=builder.create();
		dialog.show();
		
	}
}

	

