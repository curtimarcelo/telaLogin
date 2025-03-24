package com.example.telalogin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "usuarios.db";
    private static final int DATABASE_VERSION = 1;

    // Tabela de usuários
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOME = "nome";
    private static final String COLUMN_NASCIMENTO = "nascimento";
    private static final String COLUMN_NACIONALIDADE = "nacionalidade";
    private static final String COLUMN_CPF = "cpf";
    private static final String COLUMN_CELULAR = "celular";
    private static final String COLUMN_EMAIL = "email";

    // Comando SQL para criar a tabela
    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NOME + " TEXT, " +
            COLUMN_NASCIMENTO + " TEXT, " +
            COLUMN_NACIONALIDADE + " TEXT, " +
            COLUMN_CPF + " TEXT, " +
            COLUMN_CELULAR + " TEXT, " +
            COLUMN_EMAIL + " TEXT);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Método para inserir um novo usuário
    public boolean insertUser(String nome, String nascimento, String nacionalidade, String cpf, String celular, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NOME, nome);
        contentValues.put(COLUMN_NASCIMENTO, nascimento);
        contentValues.put(COLUMN_NACIONALIDADE, nacionalidade);
        contentValues.put(COLUMN_CPF, cpf);
        contentValues.put(COLUMN_CELULAR, celular);
        contentValues.put(COLUMN_EMAIL, email);

        long result = db.insert(TABLE_USERS, null, contentValues);
        db.close();
        return result != -1;  // Se for -1, o insert falhou
    }
}
