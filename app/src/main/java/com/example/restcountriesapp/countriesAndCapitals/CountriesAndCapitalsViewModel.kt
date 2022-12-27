package com.example.restcountriesapp.countriesAndCapitals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restcountriesapp.domain.Country
import com.example.restcountriesapp.domain.GetAllCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CountryWithCapital(
  val country: String,
  val capital: String,
)

data class CountriesAndCapitalsState(
  val countriesWithCapitals: List<CountryWithCapital>? = null,
)

@HiltViewModel
class CountriesAndCapitalsViewModel @Inject constructor(
  private val getAllCountriesUseCase: GetAllCountriesUseCase,
): ViewModel() {
  private val _state = MutableStateFlow(CountriesAndCapitalsState())

  val state: StateFlow<CountriesAndCapitalsState> = _state.asStateFlow()

  init {
    viewModelScope.launch {
      getAllCountriesUseCase().collect { countries ->
        _state.update { currentState ->
          currentState.copy(
            countriesWithCapitals = countries.map { mapCountry(it) }
          )
        }
      }
    }
  }

  private fun mapCountry(country: Country): CountryWithCapital {
    return CountryWithCapital(
      country = country.name,
      capital = country.capital,
    )
  }
}