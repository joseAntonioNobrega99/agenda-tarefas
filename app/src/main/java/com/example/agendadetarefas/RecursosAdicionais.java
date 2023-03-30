package com.example.agendadetarefas;

import android.app.Activity;

import androidx.appcompat.app.AlertDialog;

public class RecursosAdicionais {
    protected Activity activity;
    public RecursosAdicionais(Activity activity){
        this.activity = activity;
    }

    public void alertas(String mensagem){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this.activity);
        alerta.setMessage(mensagem);
        alerta.setNeutralButton("OK", null);
        alerta.show();
    }
}
