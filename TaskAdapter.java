package com.example.assignmentone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {
    private Context context;
    private List<Task> tasksList;

    public TaskAdapter(Context context, List<Task> tasksList) {
        super(context, 0, tasksList);
        this.context = context;
        this.tasksList = tasksList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.task_adapter, parent, false);
        }

        Task currentTask = tasksList.get(position);

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView dueDateTextView = convertView.findViewById(R.id.dueDateTextView);
        TextView statusTextView = convertView.findViewById(R.id.statusTextView);

        titleTextView.setText(currentTask.getTitle());
        dueDateTextView.setText(String.valueOf(currentTask.getDueDate())); // Assuming dueDate is of type Date
        statusTextView.setText(currentTask.isCompleted() ? "Completed" : "Pending");

        return convertView;
    }
}
