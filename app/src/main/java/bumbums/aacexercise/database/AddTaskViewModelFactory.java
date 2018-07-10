package bumbums.aacexercise.database;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory{

    private final AppDatabase mDb;
    private final int mTaskId;

    public AddTaskViewModelFactory(AppDatabase mDb, int mTaskId) {
        this.mDb = mDb;
        this.mTaskId = mTaskId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AddTaskViewModel(mDb,mTaskId);
    }
}
