package br.dev.moreira.rdm.ui.home

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import br.dev.moreira.rdm.DatabaseService
import br.dev.moreira.rdm.R
import br.dev.moreira.rdm.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private var activity: Activity? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home , container, false)
        return _binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.model = viewModel
        activity = requireActivity()
        _binding.setActivity(activity)
        _binding.lifecycleOwner = this
        DatabaseService.init(requireContext())


        viewModel.notifySave.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                Snackbar.make(view, R.string.save_success, Snackbar.LENGTH_SHORT).show()
            }
        })
    }
}