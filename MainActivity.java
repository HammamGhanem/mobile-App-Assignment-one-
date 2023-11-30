package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView tasksListView;
    private List<Task> tasksList;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksListView = findViewById(R.id.tasksListView);
        tasksList = new ArrayList<>(); // Fetch tasks from SharedPreferences using GSON and populate tasksList

        taskAdapter = new TaskAdapter(this, tasksList);
        tasksListView.setAdapter(taskAdapter);

        // Handle click listener for task items to open TaskDetailsActivity
        tasksListView.setOnItemClickListener((parent, view, position, id) -> {
            Task selectedTask = tasksList.get(position);
            // Intent to open TaskDetailsActivity with selectedTask data
        });
    }
}
