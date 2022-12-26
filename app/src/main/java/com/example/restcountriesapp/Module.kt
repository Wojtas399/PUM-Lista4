package com.example.restcountriesapp

import com.example.restcountriesapp.data.CountryRepositoryImpl
import com.example.restcountriesapp.domain.CountryRepository
import dagger.Provides
import javax.inject.Singleton

object Module {
  @Provides
  @Singleton
  fun provideCountryRepository() : CountryRepository {
    return CountryRepositoryImpl()
  }
}