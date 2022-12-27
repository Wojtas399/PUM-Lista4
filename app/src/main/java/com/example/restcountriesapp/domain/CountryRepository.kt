package com.example.restcountriesapp.domain

interface CountryRepository {
  suspend fun getAllCountries() : List<Country>
}