package com.example.restcountriesapp.countriesAndCapitals

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
import com.example.restcountriesapp.databinding.FragmentCountriesAndCapitalsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CountriesAndCapitals : Fragment() {
  private lateinit var binding: FragmentCountriesAndCapitalsBinding
  private val viewModel: CountriesAndCapitalsViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding =
      FragmentCountriesAndCapitalsBinding.inflate(inflater, container, false)

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

  private fun setContent(state: CountriesAndCapitalsState) {
    state.countriesWithCapitals?.let { setRecyclerView(it) }
  }

  private fun setRecyclerView(countriesWithCapitals: List<CountryWithCapital>) {
    binding.recyclerView.apply {
      adapter = CountriesAndCapitalsAdapter(countriesWithCapitals)
      layoutManager = LinearLayoutManager(requireContext())
    }
  }
}