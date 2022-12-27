package com.example.restcountriesapp.data.api

data class ApiCountry(
  val name: ApiCountryName,
  val capital: ArrayList<String>? = null,
  val flag: String,
)

data class ApiCountryName(
  val official: String,
)
