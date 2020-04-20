package com.luanadev.agendaapplication.asynctask;


import android.os.AsyncTask;

import com.luanadev.agendaapplication.database.dao.AlunoDao;
import com.luanadev.agendaapplication.model.Aluno;
import com.luanadev.agendaapplication.ui.adapter.ListaAlunosAdapter;

import java.util.List;

public class BuscaAlunoTask extends AsyncTask<Void, Void, List<Aluno>> {

    private final AlunoDao dao;
    private final ListaAlunosAdapter adapter;

    public BuscaAlunoTask(AlunoDao dao, ListaAlunosAdapter adapter) {
        this.dao = dao;
        this.adapter = adapter;
    }

    @Override
    protected List<Aluno> doInBackground(Void[] objects) {
        return dao.todos();
    }

    @Override
    protected void onPostExecute(List<Aluno> todosAlunos) {
        super.onPostExecute(todosAlunos);
        adapter.atualiza(todosAlunos);
    }
}

