package com.example.restcountriesapp

import com.example.restcountriesapp.data.CountryRepositoryImpl
import com.example.restcountriesapp.data.api.CountryApiClient
import com.example.restcountriesapp.data.api.CountryApi
import com.example.restcountriesapp.domain.CountryRepository
import dagger.Provides
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  @Singleton
  @Provides
  fun provideCountryAPI(
    countryClient: CountryApiClient,
  ): CountryApi {
    return countryClient.buildApi(CountryApi::class.java)
  }

  @Provides
  @Singleton
  fun provideCountryRepository(
    countryApi: CountryApi,
  ): CountryRepository {
    return CountryRepositoryImpl(countryApi)
  }
}