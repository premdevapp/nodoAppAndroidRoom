package com.example.nodoapp.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nodoapp.util.NoDoRepository;

import java.util.List;

public class NoDoViewModel extends AndroidViewModel {

    private NoDoRepository noDoRepository;

    private LiveData<List<Nodo>> allNodos;

    public NoDoViewModel(@NonNull Application application) {
        super(application);
        noDoRepository = new NoDoRepository(application);
        allNodos = noDoRepository.getAllNoDos();
    }

    public   LiveData<List<Nodo>> getAllNodos(){
        return allNodos;
    }

    public void insert(Nodo nodo){
        noDoRepository.insert(nodo);
    }

}
