package todo.com.fursa.mytodo.di.module

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import todo.com.fursa.mytodo.data.room.MyDatabase
import javax.inject.Singleton

@Module
class RoomModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideAppDatabase(): MyDatabase {
        return Room.databaseBuilder(context, MyDatabase::class.java, "Todo.db")
                .allowMainThreadQueries()
                .build()
    }

    @Singleton
    @Provides
    fun provideAppDAO(database: MyDatabase) = database.todoDAO()
}