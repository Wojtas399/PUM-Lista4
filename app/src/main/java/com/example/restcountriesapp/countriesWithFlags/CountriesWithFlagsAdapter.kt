package com.example.restcountriesapp.countriesWithFlags

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restcountriesapp.R

class CountriesWithFlagsAdapter(
  private val countriesWithFlags: List<CountryWithFlag>
) :
  RecyclerView.Adapter<CountriesWithFlagsAdapter.CountriesWithFlagsViewHolder>() {
  override fun getItemCount(): Int = countriesWithFlags.size

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): CountriesWithFlagsViewHolder {
    return CountriesWithFlagsViewHolder(
      LayoutInflater.from(parent.context).inflate(
        R.layout.country_flag_item,
        parent,
        false
      )
    )
  }

  override fun onBindViewHolder(
    holder: CountriesWithFlagsViewHolder,
    position: Int
  ) {
    val countryWithFlag: CountryWithFlag = countriesWithFlags[position]
    holder.bind(countryWithFlag)
  }

  inner class CountriesWithFlagsViewHolder(view: View) :
    RecyclerView.ViewHolder(view) {
    private val countryTextView: TextView =
      view.findViewById(R.id.cfCountryName)
    private val flagTextView: TextView = view.findViewById(R.id.cfFlag)

    fun bind(countryWithFlag: CountryWithFlag) {
      countryTextView.text = countryWithFlag.country
      flagTextView.text = countryWithFlag.flag
    }
  }
}