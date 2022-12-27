package com.example.restcountriesapp.domain

import javax.inject.Inject

class GetAllCountriesUseCase @Inject constructor(
  private val countryRepository: CountryRepository
) {
  suspend operator fun invoke(): List<Country> =
    countryRepository.getAllCountries()
}