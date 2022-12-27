package com.example.restcountriesapp.countriesWithCapitals

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

data class CountriesWithCapitalsState(
  val countriesWithCapitals: List<CountryWithCapital>? = null,
)

@HiltViewModel
class CountriesWithCapitalsViewModel @Inject constructor(
  private val getAllCountriesUseCase: GetAllCountriesUseCase,
) : ViewModel() {
  private val _state = MutableStateFlow(CountriesWithCapitalsState())

  val state: StateFlow<CountriesWithCapitalsState> = _state.asStateFlow()

  init {
    viewModelScope.launch {
      val countries: List<Country> = getAllCountriesUseCase()
      _state.update { currentState ->
        currentState.copy(
          countriesWithCapitals = countries.map { mapCountry(it) }
            .sortedBy { it.country }
        )
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