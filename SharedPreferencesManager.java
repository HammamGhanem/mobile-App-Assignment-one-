package com.example.assignmentone;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;
import java.util.ArrayList;
import java.util.List;

public class SharedPreferencesManager {
    private static final String TASKS_KEY = "tasks_key";
    private static final String SHARED_PREFS_NAME = "my_shared_prefs";

    public static List<Task> getTasksFromSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        String tasksJson = sharedPreferences.getString(TASKS_KEY, null);

        if (tasksJson != null) {
            return convertJsonToTaskList(tasksJson);
        } else {
            return new ArrayList<>(); // Return an empty list if no tasks found
        }
    }

    public static void saveTasksToSharedPreferences(Context context, List<Task> tasksList) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String tasksJson = convertTaskListToJson(tasksList);

        editor.putString(TASKS_KEY, tasksJson);
        editor.apply();
    }

    private static String convertTaskListToJson(List<Task> tasksList) {
        JSONArray jsonArray = new JSONArray();
        for (Task task : tasksList) {
           // jsonArray.put(task.toJson());
        }
        return jsonArray.toString();
    }

    private static List<Task> convertJsonToTaskList(String tasksJson) {
        List<Task> tasksList = new ArrayList<>();
        try {
            JSONArray jsonArray = (JSONArray) new JSONTokener(tasksJson).nextValue();
            for (int i = 0; i < jsonArray.length(); i++) {
                Task task = Task.fromJson(jsonArray.getJSONObject(i));
                Task Task = new Task();
                tasksList.add(Task);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tasksList;
    }
}

