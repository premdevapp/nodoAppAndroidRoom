package com.example.nodoapp.util;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.nodoapp.data.NoDoDAO;
import com.example.nodoapp.data.NoDoRoomDatabase;
import com.example.nodoapp.model.Nodo;

import java.util.List;
public class NoDoRepository {
    private NoDoDAO noDoDAO;
    private LiveData<List<Nodo>> allNoDos;

    public NoDoRepository(Application application) {
// get adata from remote api and pult it in different list
        NoDoRoomDatabase db = NoDoRoomDatabase.getDatabase(application);

        //db.noDoDAO().deleteAll();

        noDoDAO = db.noDoDAO();

        allNoDos = noDoDAO.getAllNodos();


    }

    public LiveData<List<Nodo>> getAllNoDos(){

        return allNoDos;
    }

    public void insert(Nodo nodo){
        new insertAsyncTask(noDoDAO).execute(nodo);
    }

    private class insertAsyncTask extends AsyncTask<Nodo, Void, Void> {
        private NoDoDAO asynTaskDao;
        public insertAsyncTask(NoDoDAO dao) {
            asynTaskDao = dao;

        }

        @Override
        protected Void doInBackground(Nodo... params) {
            asynTaskDao.insert(params[0]);
            return null;
        }
    }

}
