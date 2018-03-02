package search.example.com.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import search.example.com.GithubSearchApplication
import search.example.com.di.builder.ActivityBuilder
import search.example.com.di.module.ApplicationModule
import search.example.com.di.module.NetworkModule
import javax.inject.Singleton

/**
 * Dagger component.
 */

@Singleton
@Component(
            modules = arrayOf(
                    AndroidSupportInjectionModule::class,
                    ApplicationModule::class,
                    NetworkModule::class,
                    ActivityBuilder::class)
)
interface ApplicationComponent {

    fun inject(app: GithubSearchApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: GithubSearchApplication) : Builder

        fun build(): ApplicationComponent
    }


}