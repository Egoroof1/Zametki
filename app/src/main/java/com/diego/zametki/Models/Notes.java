package com.diego.zametki.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
//вроде как создаём таблицу SQL
@Entity (tableName = "notes")

//таблица будет состоять из 3-х колонок (пока) это PrimaryKey,
// title(название) and notes (сама заметка)

public class Notes implements Serializable {
    //первичный ключ (при создании объекта автоматом присваивается PrimaryKey)
    @PrimaryKey(autoGenerate = true)
    int ID = 0;
    //название заметки (сходить в магаз)
    @ColumnInfo(name = "title")
    String title = "";
    //текст самой заметки (перечисленный список покупок)
    @ColumnInfo(name = "notes")
    String notes = "";

    //будет писаться дата, когда мы эту заметку написали
    @ColumnInfo(name = "data")
    String data = "";

    //возможность закреплять самые важные заметки
    @ColumnInfo(name = "pinned")
    boolean pinned = false;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }
}
