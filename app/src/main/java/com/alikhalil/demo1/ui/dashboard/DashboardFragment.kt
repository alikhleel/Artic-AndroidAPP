package com.alikhalil.demo1.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alikhalil.demo1.common.UIState
import com.alikhalil.demo1.data.model.ExhibitionResponse
import com.alikhalil.demo1.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel: DashboardViewModel by viewModels<DashboardViewModel>()

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        observeData(dashboardViewModel.artWork)
        return root
    }

    private fun observeData(artWork: MutableLiveData<UIState<ExhibitionResponse>>) {
        artWork.observe(this.viewLifecycleOwner, Observer { uiState ->
            when (uiState) {
                is UIState.Success -> {
                    binding.textDashboard.text = uiState.responseData?.data?.get(5)?.title
                }

                is UIState.Empty -> {

                }

                is UIState.Error -> {

                }

                is UIState.Loading -> {

                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}