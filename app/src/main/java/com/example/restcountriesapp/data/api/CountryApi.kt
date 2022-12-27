package com.example.restcountriesapp.data.api

import retrofit2.http.GET

interface CountryApi {
  @GET("all")
  suspend fun getAllCountries(): List<ApiCountry>
}