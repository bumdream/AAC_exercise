package bumbums.aacexercise;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import bumbums.aacexercise.database.AppDatabase;
import bumbums.aacexercise.database.TaskEntry;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG,"Actively retrieving the tasks from the Database");
        //LiveData 를 사용하기 때문에 Ui-thread 외부에서 접근하게 되므로 Executor 가 필요없다.
        tasks = database.taskDao().loadAllTask();
    }

    public LiveData<List<TaskEntry>> getTasks(){
        return tasks;
    }

}
