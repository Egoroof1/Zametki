package com.diego.zametki.DataBase;

import static androidx.room.OnConflictStrategy.REPLACE;

import android.provider.ContactsContract;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.diego.zametki.Models.Notes;

import java.util.List;

@Dao
public interface mainDAO {

    //метод для вставляния данных в таблицу
    @Insert(onConflict = REPLACE)
    void insert(Notes notes);

    //вписывам SQL запрос для получения данных из таблици
    //@Query("SELECT * FROM notes") --- данная команда будет отображать заметки по времени их создания
    @Query("SELECT * FROM notes ORDER BY id DESC") // а эта сортирует по id от desc Я до А, а asc А-Я
    //матод для получения данных
    List<Notes> getAll();

    //обновить записи в таблице notes. Ищем по id и найдя меняем
    @Query("UPDATE notes SET title = :title, notes = :notes WHERE ID = :id")
    void update (int id, String title, String notes);

    @Delete
    void delete (Notes notes);
}
