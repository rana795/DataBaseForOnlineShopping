package com.example.databaseforonlineshopping;



import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BookBaseAdapter extends BaseAdapter {
	
	Context con;
	ArrayList<ListBook> bookArr=null;
	
	public BookBaseAdapter(Context c, ArrayList<ListBook> a) {
		this.con=c;
		this.bookArr=a;
	}
	
	@Override
	public int getCount() 
	{
		return this.bookArr.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int index, View v, ViewGroup vg)
	{

		TextView idText,nameText,authorText;
		
		LayoutInflater inflater = (LayoutInflater)con.getSystemService
														(Context.LAYOUT_INFLATER_SERVICE);
		
		if(v==null)
		{
			v=inflater.inflate(R.layout.viewdesign, vg,false);
		}
		
		idText=(TextView)v.findViewById(R.id.bookid);
		nameText=(TextView)v.findViewById(R.id.bookname);
		authorText=(TextView)v.findViewById(R.id.bookauthor);
		
		ListBook currEmp=bookArr.get(index);
		
		idText.setText(currEmp.getBookId());
		nameText.setText(currEmp.getBookName());
		authorText.setText(currEmp.getAuthorName());
		
		return v;
	}

}
