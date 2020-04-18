package com.luanadev.agendaapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.luanadev.agendaapplication.model.Aluno;

@Database(entities = {Aluno.class},version = 1, exportSchema = false)
public abstract class agendaDataBase extends RoomDatabase {
}
