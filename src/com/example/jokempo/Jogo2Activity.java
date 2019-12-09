package com.example.jokempo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Jogo2Activity extends Activity {
	
	Button btnNovo;
	ImageButton ibPedra, ibPapel, ibTesoura, ibVoltar;
	ImageView ivUser, ivCpu;
	TextView tvUser, tvCpu;
	int iSorteio = 0;
	int iVitoriaUser = 0;
	int iVitoriaCpu = 0;
	int iEscolha = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jogo2);
		btnNovo = (Button) findViewById(R.id.btnNovol2);
		ibPedra = (ImageButton) findViewById(R.id.ibPedral2);
		ibPapel = (ImageButton) findViewById(R.id.ibPapell2);
		ibTesoura = (ImageButton) findViewById(R.id.ibTesoural2);
		ibVoltar = (ImageButton) findViewById(R.id.voltar);
		ivUser = (ImageView) findViewById(R.id.ivUserl2);
		ivCpu = (ImageView) findViewById(R.id.ivCpul2);
		tvUser = (TextView) findViewById(R.id.vitoriasUser);
		tvCpu = (TextView) findViewById(R.id.vitoriacpu);
		ivUser.setBackgroundResource(R.drawable.semfundo);
		ivCpu.setBackgroundResource(R.drawable.semfundo);
		btnNovo.setEnabled(false);
		ibPedra.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sorteia();
				iEscolha = 1;
				mudarImagem();
				ivUser.setBackgroundResource(R.drawable.pedragrandeuser);
				if (iSorteio == 1){
					ivCpu.setBackgroundResource(R.drawable.pedragrandecpu);
					Toast.makeText(Jogo2Activity.this, "EMPATOU !!", Toast.LENGTH_SHORT).show();
				}else if(iSorteio == 2){
					ivCpu.setBackgroundResource(R.drawable.papelgrandecpu);
					iVitoriaCpu += 1;
					atualizaStatus();
					Toast.makeText(Jogo2Activity.this, "VOCÊ PERDEU !!", Toast.LENGTH_SHORT).show();
				}else{
					ivCpu.setBackgroundResource(R.drawable.tesouragrandecpu);
					iVitoriaUser +=1;
					atualizaStatus();
					Toast.makeText(Jogo2Activity.this, "VOCÊ GANHOU !!", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		ibPapel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sorteia();
				iEscolha = 2;
				mudarImagem();
				ivUser.setBackgroundResource(R.drawable.papelgrandeuser);
				if (iSorteio == 1){
					ivCpu.setBackgroundResource(R.drawable.pedragrandecpu);
					iVitoriaUser += 1;
					atualizaStatus();
					Toast.makeText(Jogo2Activity.this, "VOCÊ GANHOU !!", Toast.LENGTH_SHORT).show();
				}else if(iSorteio == 2){
					ivCpu.setBackgroundResource(R.drawable.papelgrandecpu);
					Toast.makeText(Jogo2Activity.this, "EMPATOU !!", Toast.LENGTH_SHORT).show();
				}else{
					ivCpu.setBackgroundResource(R.drawable.tesouragrandecpu);
					iVitoriaCpu +=1;
					atualizaStatus();
					Toast.makeText(Jogo2Activity.this, "VOCÊ PERDEU !!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		ibTesoura.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sorteia();
				iEscolha = 3;
				mudarImagem();
				ivUser.setBackgroundResource(R.drawable.tesouragrandeuser);
				if (iSorteio == 1){
					ivCpu.setBackgroundResource(R.drawable.pedragrandecpu);
					iVitoriaCpu +=1;
					atualizaStatus();
					Toast.makeText(Jogo2Activity.this, "VOCÊ PERDEU !!", Toast.LENGTH_SHORT).show();
				}else if(iSorteio == 2){
					ivCpu.setBackgroundResource(R.drawable.papelgrandecpu);
					iVitoriaUser +=1;
					atualizaStatus();
					Toast.makeText(Jogo2Activity.this, "VOCÊ GANHOU !!", Toast.LENGTH_SHORT).show();
				}else{
					ivCpu.setBackgroundResource(R.drawable.tesouragrandecpu);
					Toast.makeText(Jogo2Activity.this, "EMPATOU !!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		btnNovo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ivUser.setBackgroundResource(R.drawable.semfundo);
				ivCpu.setBackgroundResource(R.drawable.semfundo);
				ibPedra.setBackgroundResource(R.drawable.pedral2);
				ibPapel.setBackgroundResource(R.drawable.papell2);
				ibTesoura.setBackgroundResource(R.drawable.tesoural2);
				btnNovo.setEnabled(false);
				ibPedra.setEnabled(true);
				ibPapel.setEnabled(true);
				ibTesoura.setEnabled(true);
				
			}
		});
		ibVoltar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
	}
	public void mudarImagem(){
		if(iEscolha == 1){
			ibPapel.setBackgroundResource(R.drawable.papelminiescuro);
			ibTesoura.setBackgroundResource(R.drawable.tesouraminiescuro);
		}else if(iEscolha == 2){
			ibPedra.setBackgroundResource(R.drawable.pedraminiescuro);
			ibTesoura.setBackgroundResource(R.drawable.tesouraminiescuro);
		}else if(iEscolha == 3){
			ibPedra.setBackgroundResource(R.drawable.pedraminiescuro);
			ibPapel.setBackgroundResource(R.drawable.papelminiescuro);
		}
		btnNovo.setEnabled(true);
		ibPedra.setEnabled(false);
		ibPapel.setEnabled(false);
		ibTesoura.setEnabled(false);
	}
	public void atualizaStatus(){
		tvUser.setText(""+iVitoriaUser);
		tvCpu.setText(""+iVitoriaCpu);
	}
	private void sorteia(){
		iSorteio = (int) ((Math.random()*3)+1);
	}
}
