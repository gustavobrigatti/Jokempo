package com.example.jokempo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class InicioActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio);
		Button btnJogar, btnInstru;
		btnJogar = (Button) findViewById(R.id.btnJogar);
		btnInstru = (Button) findViewById(R.id.btnInstru);
		
		btnJogar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamarJogo();
				
			}
		});
		btnInstru.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamarInstru();
				
			}
		});
	}
	private void chamarJogo(){
		startActivity(new Intent(this, Jogo2Activity.class));
	}
	private void chamarInstru(){
		startActivity(new Intent(this, InstruActivity.class));
	}
}
