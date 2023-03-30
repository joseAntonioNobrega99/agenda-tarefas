package com.example.agendadetarefas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    Button btnVoltar, btnAdicionar;
    EditText inputTarefa;
    Banco banco = new Banco(this);
    RecursosAdicionais recursosAdicionais = new RecursosAdicionais(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnVoltar = findViewById(R.id.btnVoltarTela2);
        btnAdicionar = findViewById(R.id.btnAdicionarTela2);
        inputTarefa = findViewById(R.id.inputTarefaTela2);
    }

    public void voltarTela(View view){
        this.finish();
    }

    public void adicionarNovaTarefa(View view){
        String novaTarefa = inputTarefa.getText().toString();

        if (novaTarefa.isEmpty()){
            recursosAdicionais.alertas("Prencha os campus vazios!");
        }else{
            banco.adicionarTarefa(new Tarefas(novaTarefa));
            recursosAdicionais.alertas("Nova tarefa adicionada");
        }
    }
}