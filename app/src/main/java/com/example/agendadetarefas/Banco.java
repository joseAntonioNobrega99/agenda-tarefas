package com.example.agendadetarefas;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class Banco extends SQLiteOpenHelper {
    private static final String NOME = "tarefa_db";
    private static final int VERSAO = 1;

    public Banco(@Nullable Context context) {
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE IF NOT EXISTS tarefas ("
                + "codigo INTEGER PRIMARY KEY,"
                + "tarefa TEXT"
                + ")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void adicionarTarefa(Tarefas tarefa){
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tarefa", tarefa.getTarefa());
        sqLiteDatabase.insert("tarefas", null, contentValues);
        sqLiteDatabase.close();
    }

    public void deletarTarefa(Tarefas tarefa){
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("tarefas", "codigo = ?", new String[] {String.valueOf(tarefa.getId())});
        sqLiteDatabase.close();
    }

    public Cursor consulta(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("tarefas", new String[] {"codigo", "tarefa"}, null, null, null, null, null, null);
        cursor.moveToFirst();

        return cursor;
    }
}
