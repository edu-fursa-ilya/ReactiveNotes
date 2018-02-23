package todo.com.fursa.mytodo.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {
    private var mApplication: Application

    constructor(mApplication: Application) {
        this.mApplication = mApplication
    }

    @Singleton
    @Provides
    fun provideContext() = mApplication.applicationContext!!

}