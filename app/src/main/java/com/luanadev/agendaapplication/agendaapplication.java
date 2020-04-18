package com.luanadev.agendaapplication;

import android.app.Application;

import com.luanadev.agendaapplication.dao.AlunoDAO;
import com.luanadev.agendaapplication.model.Aluno;

class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Alex", "1122223333", "alex@alura.com.br"));
        dao.salva(new Aluno("Fran", "1122223333", "fran@gmail.com"));
    }
}

