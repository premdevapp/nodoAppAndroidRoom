package com.example.nodoapp.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.nodoapp.model.Nodo;

@Database(entities = {Nodo.class}, version = 1)
public abstract class NoDoRoomDatabase extends RoomDatabase {

    private static volatile NoDoRoomDatabase INSTANCE;

    public abstract NoDoDAO noDoDAO();

    public static NoDoRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (NoDoRoomDatabase.class){
                if (INSTANCE == null){
                    //create db
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), NoDoRoomDatabase.class, "nodo_database").addCallback(roomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateAsync(INSTANCE).execute();
        }
    };

    private static class PopulateAsync extends AsyncTask<Void, Void, Void> {
        private final NoDoDAO noDoDAO;
        public PopulateAsync(NoDoRoomDatabase db) {
            noDoDAO = db.noDoDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noDoDAO.deleteAll(); //removes all items from table
            /*
            //testing
            Nodo nodo = new Nodo("Buy a new Ferrari");
            noDoDAO.insert(nodo);

            nodo = new Nodo("Buy a big house");
            noDoDAO.insert(nodo);*/

            return null;
        }
    }
}
