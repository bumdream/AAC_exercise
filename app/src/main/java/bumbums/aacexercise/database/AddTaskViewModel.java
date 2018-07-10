package bumbums.aacexercise.database;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

public class AddTaskViewModel extends ViewModel {

    private LiveData<TaskEntry> task;

    public AddTaskViewModel(AppDatabase database,int taskId){
        task = database.taskDao().loadTaskById(taskId);
    }

    public LiveData<TaskEntry> getTask() {
        return task;
    }
}
