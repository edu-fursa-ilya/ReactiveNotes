package todo.com.fursa.mytodo.utils

import android.app.Application
import todo.com.fursa.mytodo.di.component.ApplicationComponent
import todo.com.fursa.mytodo.di.component.DaggerApplicationComponent
import todo.com.fursa.mytodo.di.module.ApplicationModule
import todo.com.fursa.mytodo.di.module.RoomModule

class TodoApplication : Application() {

   companion object {
       lateinit var component: ApplicationComponent
   }

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .roomModule(RoomModule(this))
                .build()

        component.inject(this)
    }

}
