package com.example.restcountriesapp.countriesWithFlags

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
import com.example.restcountriesapp.databinding.FragmentCountriesWithFlagsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CountriesWithFlags : Fragment() {
  private lateinit var binding: FragmentCountriesWithFlagsBinding
  private val viewModel: CountriesWithFlagsViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding =
      FragmentCountriesWithFlagsBinding.inflate(inflater, container, false)

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

  private fun setContent(state: CountriesWithFlagsState) {
    state.countriesWithFlags?.let { setRecyclerView(it) }
  }

  private fun setRecyclerView(countriesWithFlags: List<CountryWithFlag>) {
    binding.recyclerView.apply {
      adapter = CountriesWithFlagsAdapter(countriesWithFlags)
      layoutManager = LinearLayoutManager(requireContext())
    }
  }
}