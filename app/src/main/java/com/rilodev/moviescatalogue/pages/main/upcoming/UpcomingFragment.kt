package com.rilodev.moviescatalogue.pages.main.upcoming

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rilodev.moviescatalogue.core.data.Resource
import com.rilodev.moviescatalogue.core.ui.MovieRvAdapter
import com.rilodev.moviescatalogue.core.ui.ViewModelFactory
import com.rilodev.moviescatalogue.core.utils.Constants
import com.rilodev.moviescatalogue.databinding.FragmentUpcomingBinding
import com.rilodev.moviescatalogue.pages.detailmovie.DetailMovieActivity

class UpcomingFragment : Fragment() {
    private val viewModel: UpcomingViewModel by viewModels {
    ViewModelFactory.getInstance()
}

    private var _binding: FragmentUpcomingBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MovieRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpcomingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        recyclerViewInit()
        loadMovieData()
    }

    private fun loadMovieData() {
        binding.progressCircular.visibility = View.VISIBLE
        viewModel.getUpcoming().observe(viewLifecycleOwner) { result ->
            binding.progressCircular.visibility = View.GONE
            binding.textResult.text = String.format("Loading...")
            when(result) {
                is Resource.Success -> {
                    binding.textResult.visibility = View.GONE
                    if(result.data != null) {
                        binding.textResult.text = ""
                        adapter.setData(result.data)
                    }
                }
                is Resource.Error -> {
                    binding.textResult.visibility = View.VISIBLE
                    binding.textResult.text = result.message
                } else -> {}
            }
        }
    }

    private fun recyclerViewInit() {
        adapter = MovieRvAdapter(requireActivity())

        adapter.onItemClick = { data, view ->
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra(Constants.EXTRA_INTENT_DATA, data)

            val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                requireActivity(),
                androidx.core.util.Pair(view.image, "image"),
            )

            startActivity(intent, optionsCompat.toBundle())
        }

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }
    }
}