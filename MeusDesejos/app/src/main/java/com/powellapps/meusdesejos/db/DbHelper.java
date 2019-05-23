package com.powellapps.meusdesejos.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "meusdesejos.db";

    public static final String NOME_TABELA_DESEJO = "DESEJO";

    public static final String DESEJO_ID = "ID";
    public static final String DESEJO_DATA = "DATA";
    public static final String DESEJO_NOME = "NOME";
    public static final String DESEJO_ID_USUARIO = "ID_USUARIO";
    public static final String DESEJO_PRIORIDADE = "PRIORIDADE";
    public static final String DESEJO_ESTADO = "ESTADO";

    private static final String CRIAR_TABELA = "CREATE TABLE " +
            NOME_TABELA_DESEJO + "( " +
            DESEJO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DESEJO_PRIORIDADE + " INTEGER, " + DESEJO_ESTADO + " INTEGER, " +
            DESEJO_DATA + " LONG, " + DESEJO_NOME + " TEXT, " + DESEJO_ID_USUARIO + " INTEGER)";


    public DbHelper(Context context) {
        super(context, NOME_BANCO, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRIAR_TABELA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
