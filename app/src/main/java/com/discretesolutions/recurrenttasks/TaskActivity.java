package com.discretesolutions.recurrenttasks;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TaskActivity extends AppCompatActivity implements TaskDialog.TaskDialogListener {
    private View content;
    private ScrollView taskScroll;
    private FloatingActionButton btnAdd;
    TaskDialog td;

    @Override
    protected void onCreate(Bundle instance){
        Log.v("TaskActivity","onCreate");
        super.onCreate(instance);
         td = new TaskDialog(this);
        setContentView(R.layout.activity_fullscreen);
        taskScroll = (ScrollView)findViewById(R.id.scrollViewTask);
        btnAdd =(FloatingActionButton)findViewById(R.id.floatAddButton);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("TaskActivity","add pushed");
                td.show(getSupportFragmentManager(),"addTask");
            }
        });
    }



    @Override
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override
    public void onTaskAdded(Task newtask) {
        Log.v("Recived",newtask.getName());
    }
}
