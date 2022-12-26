package com.example.restcountriesapp.data

import com.example.restcountriesapp.domain.Country
import com.example.restcountriesapp.domain.CountryRepository
import kotlinx.coroutines.flow.Flow

class CountryRepositoryImpl : CountryRepository {
  override fun getAllCountries(): Flow<List<Country>> {
    TODO("Not yet implemented")
  }
}