package search.example.com.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import search.example.com.features.MainActivity


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindsMainActivity(): MainActivity

}