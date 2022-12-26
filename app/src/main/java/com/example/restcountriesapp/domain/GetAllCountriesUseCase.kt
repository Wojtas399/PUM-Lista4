package com.example.restcountriesapp.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCountriesUseCase @Inject constructor(
  private val countryRepository: CountryRepository
) {
  operator fun invoke(): Flow<List<Country>> {
    return countryRepository.getAllCountries()
  }
}