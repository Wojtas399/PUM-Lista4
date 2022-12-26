package com.example.restcountriesapp

import com.example.restcountriesapp.data.CountryRepositoryImpl
import com.example.restcountriesapp.domain.CountryRepository
import dagger.Provides
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
  @Provides
  @Singleton
  fun provideCountryRepository() : CountryRepository {
    return CountryRepositoryImpl()
  }
}