package com.example.restcountriesapp.domain

import kotlinx.coroutines.flow.Flow

interface CountryRepository {
  fun getAllCountries() : Flow<List<Country>>
}