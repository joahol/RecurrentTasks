package com.discretesolutions.recurrenttasks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationBarView;

import androidx.fragment.app.DialogFragment;

public class TaskDialog extends DialogFragment {
private EditText etName;
private EditText etDescription;
private Button btnAdd;
private Button btnCancel;
private Spinner spnOcc;
private Dialog tdl;
private CalendarView calView;

    public TaskDialog() {

    }

    public interface TaskDialogListener{
    void onTaskAdded(Task newtask);

}
public void setTaskDialogListener(TaskDialogListener tdl){
        this.listener = tdl;
}
private TaskDialogListener listener;

private Task newTask;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle instance){
        View v = inflater.inflate(R.layout.tasklayout,container, false);
        calView = (CalendarView)v.findViewById(R.id.calview);
        calView.setVisibility(View.INVISIBLE);
        spnOcc = (Spinner)v.findViewById(R.id.spnOcc);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.occurance, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spnOcc.setAdapter(adapter);
        spnOcc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = spnOcc.getSelectedItem().toString();
                Log.v("Before",selected);
                switch (selected.toLowerCase()) {
                    case "weekdays" : {
                        Log.v("spinner",selected);
                        calView.setVisibility(View.INVISIBLE);
                        break;
                    }
                    case "daily" :{
                        Log.v("spinner",selected);
                        calView.setVisibility(View.INVISIBLE);
                        break;
                    }
                    case  "select":{
                        calView.setVisibility(View.VISIBLE);
                        Log.v("spinner","select");
                        break;
                    }
                    default:
                    {
                        Log.v("spinner","default");
                        break;
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnAdd = (Button)v.findViewById(R.id.btnAdd);
        btnCancel =(Button)v.findViewById(R.id.btnCancel);
        etName = (EditText)v.findViewById(R.id.etName);
        etDescription = (EditText)v.findViewById(R.id.etDescription);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("TaskDialog","Add");
                newTask = new Task();
                newTask.setName(etName.getText().toString());
                newTask.setDescription(etDescription.getText().toString());
                etName.setText("");
                etDescription.setText("");
                //instance.putString("taskname", newTask.getName());
                //instance.putString("description", newTask.getDescription());
                listener.onTaskAdded(newTask);
                tdl.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("TaskDialog:","cancel");
                tdl.dismiss();
            }
        });
        return v;
    }

    @Override
    public Dialog onCreateDialog(Bundle instance){
        super.onCreateDialog(instance);

//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        Dialog tDialog = super.onCreateDialog(instance);
        tDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        tdl = tDialog;
        return tDialog;
    }

    @Override
    public void onAttach(Context context){
    super.onAttach(context);
    try {
        listener = (TaskDialogListener) context;
    }catch(ClassCastException ce){}
    }

}
