package com.example.nodoapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.nodoapp.model.Nodo;

@Database(entities = {Nodo.class}, version = 1)
public abstract class NoDoRoomDatabase extends RoomDatabase {

    private static volatile NoDoRoomDatabase INSTANCE;

    public abstract NoDoDAO noDoDAO();

    static NoDoRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (NoDoRoomDatabase.class){
                if (INSTANCE == null){
                    //create db
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), NoDoRoomDatabase.class, "nodo_database").build();
                }
            }
        }
        return INSTANCE;
    }

}
