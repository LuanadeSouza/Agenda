package com.luanadev.agendaapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.luanadev.agendaapplication.database.dao.AlunoDao;
import com.luanadev.agendaapplication.model.Aluno;

@Database(entities = {Aluno.class}, version = 1, exportSchema = false)
public abstract class AgendaDataBase extends RoomDatabase {
    private static String NOME_BANCO_DE_DADOS = "agenda.db";
    public abstract AlunoDao getRoomAlunoDao();

    public static AgendaDataBase getInstance(Context context) {
        return Room.databaseBuilder(context, AgendaDataBase.class, NOME_BANCO_DE_DADOS).allowMainThreadQueries().build();
    }
}
