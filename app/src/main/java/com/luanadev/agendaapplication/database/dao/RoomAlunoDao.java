package com.luanadev.agendaapplication.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.luanadev.agendaapplication.model.Aluno;

import java.util.List;

@Dao
public interface RoomAlunoDao {
    @Insert
    void salva(Aluno aluno);

    @Query("SELECT * FROM aluno")
    List<Aluno> todos();

    @Delete
    void remove(Aluno aluno);
}
