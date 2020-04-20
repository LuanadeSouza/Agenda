package com.luanadev.agendaapplication.database;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


import com.luanadev.agendaapplication.database.converter.ConversorCalendar;
import com.luanadev.agendaapplication.database.converter.ConversorTipoTelefone;
import com.luanadev.agendaapplication.database.dao.AlunoDao;
import com.luanadev.agendaapplication.database.dao.TelefoneDAO;
import com.luanadev.agendaapplication.model.Aluno;
import com.luanadev.agendaapplication.model.Telefone;

import static com.luanadev.agendaapplication.database.AgendaMigrations.TODAS_MIGRATIONS;

@Database(entities = {Aluno.class, Telefone.class}, version = 6, exportSchema = false)
public abstract class AgendaDataBase extends RoomDatabase {
    @TypeConverters({ConversorCalendar.class, ConversorTipoTelefone.class})
    public abstract static class AgendaDatabase extends RoomDatabase {

        private static final String NOME_BANCO_DE_DADOS = "agenda.db";

        public abstract AlunoDao getAlunoDAO();

        public abstract TelefoneDAO getTelefoneDAO();

        public  static AgendaDatabase getInstance(Context context) {
            return Room
                    .databaseBuilder(context, AgendaDatabase.class, NOME_BANCO_DE_DADOS)
                    .addMigrations(TODAS_MIGRATIONS)
                    .build();
        }
    }
}