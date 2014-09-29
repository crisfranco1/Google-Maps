package com.example.googlemaps;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnClickListener {
	
	
	 private GoogleMap mMap;
	 
	 EditText etlatitud;
	 EditText etlongitud;
	 Button btir;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		
		etlatitud= (EditText) findViewById(R.id.editTextlatitud);
		etlongitud=(EditText) findViewById(R.id.editTextlongitud);
		btir= (Button) findViewById(R.id.buttonir);
		
		btir.setOnClickListener(this);
	
		mMap.setMyLocationEnabled(true);
		
		
		mMap.setMapType(2);
		
		mMap.addMarker(new MarkerOptions().position(new LatLng(4.63408, -74.067017)).title("Universidad catolica de Colombia").icon(BitmapDescriptorFactory.fromResource(R.drawable.ucatolica)));
		mMap.addMarker(new MarkerOptions().position(new LatLng(48.779209, 9.1772152)).title("Stuttgart"));
		Toast.makeText(getBaseContext(), "Maps Cristian Franco - 625015", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		
		case R.id.item1:
			
			Toast.makeText(getBaseContext(), "Tipos de maps", Toast.LENGTH_SHORT).show();
		
		
			return true;
			
		case R.id.item2:
		
		mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
			return true;
			
		case R.id.item3:
			
			mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			
			return true;
		case R.id.item4:
			
			mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		
		
			return true;
			
		case R.id.item5:
			
			mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			
		
			return true;
			
			
		case R.id.item6:
			
			mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
			return true;

		default:
			return super.onOptionsItemSelected(item);
			
		}

	}

	@Override
	public void onClick(View v) {
		
		
CameraUpdate camUpd =CameraUpdateFactory.newLatLng(new LatLng(Double.parseDouble(etlatitud.getText().toString()), Double.parseDouble(etlongitud.getText().toString())));
mMap.moveCamera(camUpd);
		
	}
}
