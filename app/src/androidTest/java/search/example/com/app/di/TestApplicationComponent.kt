package search.example.com.app.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import search.example.com.app.TestGithubSearchApplication
import search.example.com.di.builder.ActivityBuilder
import search.example.com.di.module.ApplicationModule
import javax.inject.Singleton

/**
 * Test Dagger component.
 */

@Singleton
@Component(
            modules = arrayOf(
                    AndroidSupportInjectionModule::class,
                    ApplicationModule::class,
                    MockModule::class,
                    ActivityBuilder::class)
)
interface TestApplicationComponent {

    fun inject(app: TestGithubSearchApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application) : Builder

        fun build(): TestApplicationComponent

    }

}