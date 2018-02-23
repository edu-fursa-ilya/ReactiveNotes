package todo.com.fursa.mytodo.di.component

import dagger.Component
import todo.com.fursa.mytodo.di.module.ApplicationModule
import todo.com.fursa.mytodo.di.module.RoomModule
import todo.com.fursa.mytodo.ui.activities.MainActivity
import todo.com.fursa.mytodo.ui.mvp.MainPresenter
import todo.com.fursa.mytodo.utils.TodoApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, RoomModule::class])
interface ApplicationComponent {
    //for injecting
    fun inject(mainActivity: MainActivity)
    fun inject(app: TodoApplication)
    fun inject(mainPresenter: MainPresenter)
}