package com.example.todo_detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private String[] tasks ={"play football", "study","dinner","sleep"};
    private String[] tasks;
    private TextView textView;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState!=null)
        {
            currentIndex=savedInstanceState.getInt("tasks",0);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        tasks=res.getStringArray(R.array.todos);
        textView=findViewById(R.id.textView);
        textView.setText(tasks[currentIndex]);
        Log.d("MainActivity", "onCreate: ");
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("tasks", currentIndex);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy: ");
    }




    public void Previous(View view){
        currentIndex--;
        textView.setText(tasks[currentIndex]);
    }
    public void Next(View view){
        currentIndex = ++currentIndex % tasks.length;
        //currentIndex++;
        Log.d("MainActivity", "value of current index:"+currentIndex);
        textView.setText(tasks[currentIndex]);

    }
}
