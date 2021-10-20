package com.discretesolutions.recurrenttasks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class TaskDialog extends DialogFragment {
private EditText etName;
private EditText etDescription;

public interface TaskDialogListener{
    public void onTaskAdded(DialogFragment dialog);
}
private TaskDialogListener listener;

private Task newTask;
    @Override
    public Dialog onCreateDialog(Bundle instance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflator = requireActivity().getLayoutInflater();
        inflator.inflate(R.layout.tasklayout,null);
        Dialog tDialog = builder.create();
        etName = tDialog.findViewById(R.id.etName);
        etDescription = tDialog.findViewById(R.id.etDescription);
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
