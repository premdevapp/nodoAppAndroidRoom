package com.example.nodoapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nodo_table")
public class Nodo {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "nodo_col")
    private String nodo;

    public Nodo(@NonNull String nodo) {
        this.nodo = nodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNodo() {
        return nodo;
    }

    public void setNodo(@NonNull String nodo) {
        this.nodo = nodo;
    }
}
