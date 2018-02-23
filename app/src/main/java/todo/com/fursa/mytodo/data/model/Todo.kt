package todo.com.fursa.mytodo.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "TodoTable")
data class Todo(
        @ColumnInfo(name = "todoTitle") var todoTitle: String,
        @ColumnInfo(name = "todoText") var todoText: String) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0

    override fun toString(): String {
        return "Todo(todoTitle='$todoTitle', todoText='$todoText')"
    }


}