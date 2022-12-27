package com.example.restcountriesapp.countriesWithCapitals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restcountriesapp.databinding.FragmentCountriesWithCapitalsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CountriesWithCapitals : Fragment() {
  private lateinit var binding: FragmentCountriesWithCapitalsBinding
  private val viewModel: CountriesWithCapitalsViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding =
      FragmentCountriesWithCapitalsBinding.inflate(inflater, container, false)

    collectViewModel()

    return binding.root
  }

  private fun collectViewModel() {
    viewLifecycleOwner.lifecycleScope.launch {
      viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel.state.collect { setContent(it) }
      }
    }
  }

  private fun setContent(state: CountriesWithCapitalsState) {
    state.countriesWithCapitals?.let { setRecyclerView(it) }
  }

  private fun setRecyclerView(countriesWithCapitals: List<CountryWithCapital>) {
    binding.recyclerView.apply {
      adapter = CountriesWithCapitalsAdapter(countriesWithCapitals)
      layoutManager = LinearLayoutManager(requireContext())
    }
  }
}