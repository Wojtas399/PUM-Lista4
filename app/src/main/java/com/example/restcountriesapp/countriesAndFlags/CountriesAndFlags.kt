package com.example.restcountriesapp.countriesAndFlags

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.restcountriesapp.R

class CountriesAndFlags : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(
      R.layout.fragment_countries_and_flags,
      container,
      false
    )
  }
}