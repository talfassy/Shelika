package com.first.myapplicationtry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class Note_adapter extends FirestoreRecyclerAdapter <Note,Note_adapter.NoteHolder> {


    public Note_adapter(@NonNull FirestoreRecyclerOptions<Note> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteHolder noteHolder, int i, @NonNull Note note) {

        noteHolder.textView_title.setText(note.getTitle()); // put the title of the note in text view_title
        noteHolder.textView_date.setText(note.getDate()); // put the title of the note in text view_title
        noteHolder.textView_description.setText(note.getDescription()); // put the description of the note in text view_Details
        noteHolder.textView_address.setText(note.getAddress()); // put the address of the note in text view_address
        noteHolder.textView_phone.setText(note.getPhone()); // put the phone of the note in text view_phone

    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent , false);
        return new NoteHolder(v);

    }

    class NoteHolder extends RecyclerView.ViewHolder{

        TextView textView_title;
        TextView textView_date;
        TextView textView_description;
        TextView textView_address;
        TextView textView_phone;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            textView_title = itemView.findViewById(R.id.offer_title);
            textView_date = itemView.findViewById(R.id.dateOffer);
            textView_description = itemView.findViewById(R.id.Details);
            textView_address = itemView.findViewById(R.id.Address);
            textView_phone =itemView.findViewById(R.id.phone_number);
        }
    }
}
