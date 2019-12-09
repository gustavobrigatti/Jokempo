package com.example.jokempo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class JogoActivity extends Activity {

	int iEscolha = 0;
	int iSorteio = 0;
	
	ImageView ivUser, ivCpu, ivStatus;
	ImageButton ibPedra, ibPapel, ibTesoura, ibNovo;
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jogo);
		ibPedra = (ImageButton) findViewById(R.id.btnPedra);
		ibPapel = (ImageButton) findViewById(R.id.btnPapel);
		ibTesoura = (ImageButton) findViewById(R.id.btnTesoura);
		ivUser = (ImageView) findViewById(R.id.ivUser);
		ivCpu = (ImageView) findViewById(R.id.ivCpu);
		ivStatus = (ImageView) findViewById(R.id.status);
		ibNovo = (ImageButton) findViewById(R.id.novoJogo);
		ibNovo.setEnabled(false);
		
		ibPedra.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sorteia();
				mudarImagem();
				ivUser.setBackgroundResource(R.drawable.pedrauser);
				if(iSorteio == 1){
					ivCpu.setBackgroundResource(R.drawable.pedracpu);
					ivStatus.setBackgroundResource(R.drawable.empatou);
				}else if(iSorteio == 2){
					ivCpu.setBackgroundResource(R.drawable.papelcpu);
					ivStatus.setBackgroundResource(R.drawable.perdeu);
				}else{
					ivCpu.setBackgroundResource(R.drawable.tesoura);
					ivStatus.setBackgroundResource(R.drawable.venceu);
				}
			}
		});
		ibPapel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sorteia();
				mudarImagem();
				ivUser.setBackgroundResource(R.drawable.papeluser);
				if(iSorteio == 1){
					ivCpu.setBackgroundResource(R.drawable.pedracpu);
					ivStatus.setBackgroundResource(R.drawable.venceu);
				}else if(iSorteio == 2){
					ivCpu.setBackgroundResource(R.drawable.papelcpu);
					ivStatus.setBackgroundResource(R.drawable.empatou);
				}else{
					ivCpu.setBackgroundResource(R.drawable.tesoura);
					ivStatus.setBackgroundResource(R.drawable.perdeu);
				}
			}
		});
		ibTesoura.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sorteia();
				mudarImagem();
				ivUser.setBackgroundResource(R.drawable.tesoura);
				if(iSorteio == 1){
					ivCpu.setBackgroundResource(R.drawable.pedracpu);
					ivStatus.setBackgroundResource(R.drawable.perdeu);
				}else if(iSorteio == 2){
					ivCpu.setBackgroundResource(R.drawable.papelcpu);
					ivStatus.setBackgroundResource(R.drawable.venceu);
				}else{
					ivCpu.setBackgroundResource(R.drawable.tesoura);
					ivStatus.setBackgroundResource(R.drawable.empatou);
				}
			}
		});
		ibNovo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ibNovo.setBackgroundResource(R.drawable.novoescuro);
				ibPedra.setBackgroundResource(R.drawable.pedra2);
				ibPapel.setBackgroundResource(R.drawable.papele2);
				ibTesoura.setBackgroundResource(R.drawable.tesoura2);
				ivUser.setBackgroundResource(R.drawable.pptmini);
				ivCpu.setBackgroundResource(R.drawable.pptmini);
				ivStatus.setBackgroundResource(R.drawable.aguardando);
				ibNovo.setEnabled(false);
				ibPedra.setEnabled(true);
				ibPapel.setEnabled(true);
				ibTesoura.setEnabled(true);	
			}
		});
	}
	public void mudarImagem(){
		ibNovo.setBackgroundResource(R.drawable.novo);
		ibPedra.setBackgroundResource(R.drawable.pedra2escuro);
		ibPapel.setBackgroundResource(R.drawable.papele2escuro);
		ibTesoura.setBackgroundResource(R.drawable.tesoura2escuro);
		ibNovo.setEnabled(true);
		ibPedra.setEnabled(false);
		ibPapel.setEnabled(false);
		ibTesoura.setEnabled(false);
	}
	private void sorteia(){
		iSorteio = (int) ((Math.random()*3)+1);
	}
}
