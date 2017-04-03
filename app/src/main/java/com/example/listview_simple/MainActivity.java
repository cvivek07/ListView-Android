package com.example.listview_simple;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	//film are defined in strings.xml in Values Folder
String[] movie;
//Director are also defined in strings.xml in Values Folder
String[] director;
//Images for the list to be displayed is defined (or) Pasted in drawable Folder
int [] images ={R.drawable.accident,R.drawable.batman,R.drawable.enemy,R.drawable.interstellar,R.drawable.noahh,R.drawable.thegreatbeauty,R.drawable.bc};
//Defining ListView
ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Referring the ListView
		lv=(ListView)findViewById(R.id.listView1);
		//Binding the film values from strings file to the Titles
		movie=getResources().getStringArray(R.array.films);
		//Binding the Director values from strings file to Description
		director=getResources().getStringArray(R.array.director);
		//Creating our custom Adapter 		
		CustomListViewAdapter customListViewAdapter =new CustomListViewAdapter(this, movie, images, director );
		//Setting the adapter to the ListView
		lv.setAdapter(customListViewAdapter);
		lv.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) 
					
			{
				// TODO Auto-generated method stub

				//Do something when user clicks on the item
				
			}
		});
	}
	
	class CustomListViewAdapter extends ArrayAdapter<String>

	{
		Context context;
		int [] images;
		String[] filmArray;
		String [] directorArray;
		
		//Binding the values for Superclass constructor  for the class CustomListViewAdapter
		CustomListViewAdapter(Context c, String[] film, int imgs[], String[] director)
		{
			super(c, R.layout.singlerow, R.id.textView1, film);
			this.context = c;
			this.images = imgs;
			this.filmArray = film;
			this.directorArray =director;
		}
		
		//getView() is a method which will build each row and it will return the row built to the ListView
		public View getView(int position, View convertView, ViewGroup parent)
		{

			//Layout inflator is used to inflate the custom xml file(singlerow.xml) to the class CustomListViewAdapter
			LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = inflater.inflate(R.layout.singlerow, parent, false);

			//Defining the ImageView and TextView for movie icon, Film , Director
			ImageView myImage;
			TextView myFilm;
			TextView myDirector;

			//Referring the ImageView
			myImage= (ImageView) row.findViewById(R.id.imageView1);
			//Setting the image for movieicon() from drawable folder
			myImage.setImageResource(images[position]);

			//Reffering the TextView
			myFilm=(TextView) row.findViewById(R.id.textView1);
			//Setting the Text for Film from strings.xml from Values folder
			myFilm.setText(filmArray[position]);

			//Referring the Textview
			myDirector=(TextView) row.findViewById(R.id.textView2);
			//Setting the Text for Director from strings.xml from Values folder
			myDirector.setText(directorArray[position]);

			//Returning the row built to the getview
			return row;

		}
	}

}
