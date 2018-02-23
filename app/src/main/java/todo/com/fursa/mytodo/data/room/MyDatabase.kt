package todo.com.fursa.mytodo.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import todo.com.fursa.mytodo.data.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun todoDAO() : TodoDAO
}