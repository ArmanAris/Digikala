package ir.aris.digikala.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.aris.digikala.data.network.ProfileApiInterface
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ProfileApiInterfaceModule {

    @Singleton
    @Provides
    fun provideProfileApiService(retrofit: Retrofit) : ProfileApiInterface =
        retrofit.create(ProfileApiInterface::class.java)

}