package com.luanadev.agendaapplication;

import android.app.Application;

import androidx.room.Room;

import com.luanadev.agendaapplication.database.AgendaDataBase;
import com.luanadev.agendaapplication.database.dao.RoomAlunoDao;
import com.luanadev.agendaapplication.model.Aluno;

class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AgendaDataBase dataBase = Room.databaseBuilder(this, AgendaDataBase.class, "agenda.db").build();
        RoomAlunoDao dao = dataBase.getRoomAlunoDao();
        dao.salva(new Aluno("Alex", "1122223333", "alex@alura.com.br"));
        dao.salva(new Aluno("Fran", "1122223333", "fran@gmail.com"));
    }
}

