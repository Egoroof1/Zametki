package com.diego.zametki;

import androidx.cardview.widget.CardView;

import com.diego.zametki.Models.Notes;

public interface NotesClickListener {

    void onClick (Notes notes); //полозователь нажал
    void onLongClick (Notes notes, CardView cardView); //долго нажал

}
