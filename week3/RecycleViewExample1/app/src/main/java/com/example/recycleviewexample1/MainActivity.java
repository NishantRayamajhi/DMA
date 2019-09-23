package com.example.recycleviewexample1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> wordlist;
    private WordListAdapter adapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordlist = new ArrayList<>();
        for (int i = 0; i<20; i++){
            wordlist.add("word" + 1);
        }
        recyclerView = findViewById(R.id.word_list);
        adapter = new WordListAdapter(wordlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int wordListSize = wordlist.size();
                // Add a new word to the wordList.
                wordlist.add("+ Word " + wordListSize);
                // Notify the adapter, that the data has changed.
                recyclerView.getAdapter().notifyItemInserted(wordListSize);
                // Scroll to the bottom.
                recyclerView.smoothScrollToPosition(wordListSize);
            }
        });
    }
}

