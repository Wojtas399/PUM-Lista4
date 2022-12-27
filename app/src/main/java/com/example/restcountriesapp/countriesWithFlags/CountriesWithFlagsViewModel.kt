package com.example.restcountriesapp.countriesWithFlags

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restcountriesapp.domain.Country
import com.example.restcountriesapp.domain.GetAllCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CountryWithFlag(
  val country: String,
  val flag: String,
)

data class CountriesWithFlagsState(
  val countriesWithFlags: List<CountryWithFlag>? = null,
)

@HiltViewModel
class CountriesWithFlagsViewModel @Inject constructor(
  private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel() {
  private val _state = MutableStateFlow(CountriesWithFlagsState())

  val state: StateFlow<CountriesWithFlagsState> = _state.asStateFlow()

  init {
    viewModelScope.launch {
      val countries: List<Country> = getAllCountriesUseCase()
      _state.update { currentState ->
        currentState.copy(
          countriesWithFlags = countries.map { mapCountry(it) }
            .sortedBy { it.country }
        )
      }
    }
  }

  private fun mapCountry(country: Country): CountryWithFlag {
    return CountryWithFlag(
      country = country.name,
      flag = country.flag,
    )
  }
}