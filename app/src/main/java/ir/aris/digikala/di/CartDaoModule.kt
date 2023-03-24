package ir.aris.digikala.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.aris.digikala.data.db.CartDao
import ir.aris.digikala.data.db.DigikalaDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CartDaoModule {

    @Provides
    @Singleton
    fun provideCartDao(
        database: DigikalaDatabase
    ): CartDao = database.cartDao()
}