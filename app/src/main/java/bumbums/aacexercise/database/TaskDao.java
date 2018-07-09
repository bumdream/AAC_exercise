package bumbums.aacexercise.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TaskDao {
    @Query("SELECT * from task ORDER BY priority")
    LiveData<List<TaskEntry>> loadAllTask();


    //삽입,수정,삭제는 우리가 변화를 알 필요가 지금은 없으므로 LiveData 를 사용하지 않는다.
    @Insert
    void insertTask(TaskEntry taskEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(TaskEntry taskEntry);

    @Delete
    void deleteTask(TaskEntry taskEntry);

    @Query("SELECT * from task WHERE id = :id")
    TaskEntry loadTaskById(int id);
}
