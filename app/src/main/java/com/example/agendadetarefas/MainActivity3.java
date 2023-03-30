package com.example.agendadetarefas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    EditText inputCodigoApagar;
    Button btnVoltar, btnApagar;

    Banco banco = new Banco(this);
    RecursosAdicionais recursosAdicionais = new RecursosAdicionais(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        inputCodigoApagar = findViewById(R.id.inputTarefaApagar);
        btnVoltar = findViewById(R.id.btnVoltarApagar);
        btnApagar = findViewById(R.id.btnApagarTarefa);
    }

    public void voltarTela(View view){
        this.finish();
    }

    public void apagarTarefa(View view){
        String tarefaApgar = inputCodigoApagar.getText().toString();

        if (tarefaApgar.isEmpty()){
            recursosAdicionais.alertas("Prencha os campus vazios!");
        }else{
            Tarefas tarefas = new Tarefas();
            tarefas.setId(Integer.parseInt(tarefaApgar));
            banco.deletarTarefa(tarefas);
            recursosAdicionais.alertas("Tarefa deletada com sucesso!");
        }
    }
}