package com.example.nodoapp.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.nodoapp.model.Nodo;

import java.util.List;

@Dao
public interface NoDoDAO {
    //crud
    @Insert
    void insert(Nodo nodo);

    @Query("DELETE FROM nodo_table")
    void deleteAll();

    @Query("DELETE FROM nodo_table WHERE id = :id")
    int deleteANodo(int id);

    @Query("UPDATE nodo_table SET nodo_col = :nodoQuery WHERE id = :id")
    int updateNodoItem(int id, String nodoQuery);

    @Query("SELECT * FROM nodo_table ORDER BY nodo_col DESC")
    LiveData<List<Nodo>> getAllNodos();


}
