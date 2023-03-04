package ir.aris.digikala.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.aris.digikala.data.datastore.DataStoreRepository
import ir.aris.digikala.data.datastore.DataStoreRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Singleton
    @Provides
    fun provideDateStoreRepository(@ApplicationContext app: Context): DataStoreRepository =
        DataStoreRepositoryImpl(app)

}
