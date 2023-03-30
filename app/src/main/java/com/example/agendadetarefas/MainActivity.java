package com.example.agendadetarefas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button apagarTela, proximaTela;
    TextView tarefa, codigo;
    RecursosAdicionais recursosAdicionais = new RecursosAdicionais(this);
    Banco banco = new Banco(this);
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apagarTela = findViewById(R.id.btnApagar);
        proximaTela = findViewById(R.id.btnProxima);
        tarefa = findViewById(R.id.textVisualizarTarefa);
        codigo = findViewById(R.id.textVisualizarCodigo);
        consultarBanco();
    }

    @Override
    protected void onResume(){
        super.onResume();
        consultarBanco();
    }

    public void consultarBanco(){
        cursor = banco.consulta();

        if (cursor.getCount() != 0){
            visualizarDados();
        }else{
            recursosAdicionais.alertas("Não tem tarefas armazenadas!");
        }
    }

    public void proximoDado(View view){
        try {
            cursor.moveToNext();
            visualizarDados();
        }catch (Exception exception){
            if (cursor.isAfterLast()){
                recursosAdicionais.alertas("Não tem mais dados armazenados!");
            }else{
                recursosAdicionais.alertas("Error na navegação entre os dados");
            }
        }
    }

    public void anteriorDado(View view){
        try {
            cursor.moveToPrevious();
            visualizarDados();
        }catch (Exception exception){
            if (cursor.isBeforeFirst()){
                recursosAdicionais.alertas("Não tem mais dados armazenados!");
            }else{
                recursosAdicionais.alertas("Error na navegação entre os dados");
            }
        }
    }

    public void visualizarDados(){
        tarefa.setText(cursor.getString(cursor.getColumnIndex("tarefa")));
        codigo.setText(cursor.getString(cursor.getColumnIndex("codigo")));
    }

    public void abrirTelaCadastro(View view){
        Intent intentCadastro = new Intent(this, MainActivity2.class);
        startActivity(intentCadastro);
    }

    public void abrirTelaApagar(View view){
        Intent intentApagar = new Intent(this, MainActivity3.class);
        startActivity(intentApagar);
    }
}