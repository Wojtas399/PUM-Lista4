package com.example.restcountriesapp.data

import com.example.restcountriesapp.data.api.CountryApi
import com.example.restcountriesapp.data.api.ApiCountry
import com.example.restcountriesapp.domain.Country
import com.example.restcountriesapp.domain.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
  private val countryApi: CountryApi,
) : CountryRepository {
  override suspend fun getAllCountries(): List<Country> =
    countryApi.getAllCountries().map { mapApiCountryToDomainCountry(it) }

  private fun mapApiCountryToDomainCountry(apiCountry: ApiCountry): Country =
    Country(
      name = apiCountry.name.official,
      capital = apiCountry.capital?.first() ?: "unknown",
      flag = apiCountry.flag,
    )
}