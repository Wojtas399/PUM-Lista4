package com.example.restcountriesapp.data

import com.example.restcountriesapp.domain.Country
import com.example.restcountriesapp.domain.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CountryRepositoryImpl : CountryRepository {
  override fun getAllCountries(): Flow<List<Country>> {
    return flow {
      emit(
        listOf(
          Country(
            name = "Country 1",
            capital = "Capital 1",
            flag = "🏳🇦🇹",
          ),
          Country(
            name = "Country 2",
            capital = "Capital 2",
            flag = "🏳️‍⚧️",
          ),
          Country(
            name = "Country 3",
            capital = "Capital 3",
            flag = "🇨🇬",
          ),
          Country(
            name = "Country 4",
            capital = "Capital 4",
            flag = "🇨🇳",
          ),
        ),
      )
    }
  }
}