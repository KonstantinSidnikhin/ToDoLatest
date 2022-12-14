package com.example.todopractice_7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private ArrayList<Note>notes = new ArrayList<>();
    private OnNoteClickListener onNoteClickListener; //3

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }



    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {//4
        this.onNoteClickListener = onNoteClickListener;
    }





    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
      return new NotesViewHolder(view);
    }


    @Override
    public void onBindViewHolder(NotesViewHolder viewHolder, int position) {

   Note note = notes.get(position);
   viewHolder.textViewNote.setText(note.getText().toString());
   int colorResId;
   switch (note.getPriority()){
       case 0:colorResId = android.R.color.holo_green_light;
       break;
       case 1:colorResId = android.R.color.holo_orange_light;
       break;
       default:
           colorResId = android.R.color.holo_red_light;
   }
   int color = ContextCompat.getColor(viewHolder.itemView.getContext(),colorResId);
   viewHolder.textViewNote.setBackgroundColor(color);

   viewHolder.itemView.setOnClickListener(new View.OnClickListener() {//1
       @Override
       public void onClick(View view) {
           if(onNoteClickListener != null){
        onNoteClickListener.onNoteClick(note);//5
       }}
   });




    }

    @Override
    public int getItemCount() {return notes.size();}


    class NotesViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNote;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
      textViewNote = itemView.findViewById(R.id.textViewNote);

        }
    }
    interface OnNoteClickListener{//2
        void onNoteClick(Note note);

    }
}


