package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public interface WordDao {
    void deleteAll();

    void insert(com.example.myapplication.Word word);

    public class Word {

        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "word")
        private String mWord;

        public Word(@NonNull String word) {this.mWord = word;}

        public String getWord(){return this.mWord;}
    }
}
