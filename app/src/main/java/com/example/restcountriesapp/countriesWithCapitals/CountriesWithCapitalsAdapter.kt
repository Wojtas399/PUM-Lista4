package com.example.restcountriesapp.countriesWithCapitals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restcountriesapp.R

class CountriesWithCapitalsAdapter(
  private val countriesWithCapitals: List<CountryWithCapital>
) :
  RecyclerView.Adapter<CountriesWithCapitalsAdapter.CountriesWithCapitalsViewHolder>() {
  override fun getItemCount(): Int = countriesWithCapitals.size

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): CountriesWithCapitalsViewHolder {
    return CountriesWithCapitalsViewHolder(
      LayoutInflater.from(parent.context).inflate(
        R.layout.country_capital_item,
        parent,
        false,
      )
    )
  }

  override fun onBindViewHolder(
    holder: CountriesWithCapitalsViewHolder,
    position: Int
  ) {
    val countryWithCapital: CountryWithCapital = countriesWithCapitals[position]
    holder.bind(countryWithCapital)
  }

  inner class CountriesWithCapitalsViewHolder(view: View) :
    RecyclerView.ViewHolder(view) {
    private val countryTextView: TextView =
      view.findViewById(R.id.caCountryName)
    private val capitalTextView: TextView =
      view.findViewById(R.id.caCapitalName)

    fun bind(countryWithCapital: CountryWithCapital) {
      countryTextView.text = countryWithCapital.country
      capitalTextView.text = countryWithCapital.capital
    }
  }
}