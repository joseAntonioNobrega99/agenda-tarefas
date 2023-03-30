package com.example.agendadetarefas;

public class Tarefas {
    private String tarefa;
    private int id;

    public Tarefas(){

    }

    public Tarefas(String tarefa){
        this.tarefa = tarefa;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
