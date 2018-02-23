package todo.com.fursa.mytodo.data.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import todo.com.fursa.mytodo.data.model.Todo

@Dao
interface TodoDAO {

    @Query("SELECT * FROM TodoTable")
    fun selectAll(): Flowable<List<Todo>>

    @Insert
    fun save(todo: Todo)
}