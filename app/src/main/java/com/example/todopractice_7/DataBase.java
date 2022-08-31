package com.example.todopractice_7;

import java.util.ArrayList;
import java.util.Random;

public class DataBase {
 private static DataBase instance = null;

public static DataBase getInstance(){
    if (instance == null){
        instance = new DataBase();

    }
    return instance;
}
    ArrayList<Note>notes = new ArrayList<>();
 public DataBase(){

     Random random = new Random();
     for(int i = 0; i<20;i++){
         Note note = new Note(i,"note:"+i,random.nextInt(3));
         notes.add(note);
     }
 }
 public void addNote(Note note){notes.add(note);}
 public void removeNote(int id){
     for (int i =0; i < notes.size();i++){
         Note note = notes.get(i);
         if (note.getId()==id){
             notes.remove(id);

         }
     }

 }
    public ArrayList<Note> getNotes(){
        return new ArrayList<>(notes);
    }

}
