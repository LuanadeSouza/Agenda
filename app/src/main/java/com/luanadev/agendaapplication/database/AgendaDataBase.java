package com.luanadev.agendaapplication.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.luanadev.agendaapplication.database.dao.AlunoDao;
import com.luanadev.agendaapplication.model.Aluno;

@Database(entities = {Aluno.class}, version = 3, exportSchema = false)
public abstract class AgendaDataBase extends RoomDatabase {
    private static String NOME_BANCO_DE_DADOS = "agenda.db";

    public abstract AlunoDao getRoomAlunoDao();

    public static AgendaDataBase getInstance(Context context) {
        return Room.databaseBuilder(context, AgendaDataBase.class, NOME_BANCO_DE_DADOS)
                .allowMainThreadQueries().addMigrations(new Migration(1, 2) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("ALTER TABLE  aluno ADD COLUMN sobrenome TEXT");
                    }
                }, new Migration(2, 3) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_novo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT, `telefone` TEXT, `email` TEXT)");
                        database.execSQL("INSERT INTO Aluno_novo (id, nome, email ) SELECT id, nome, email FROM Aluno");
                        database.execSQL("DROP TABLE Aluno");
                        database.execSQL("ALTER TABLE Aluno_novo RENAME TO Aluno");
                    }
                }).build();
    }
}
