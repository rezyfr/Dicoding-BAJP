package com.rezyfr.dicoding.bajp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.databinding.FragmentMainBinding
import com.rezyfr.dicoding.bajp.ui.detail.DetailActivity
import com.rezyfr.dicoding.bajp.utils.Constant
import com.rezyfr.dicoding.bajp.utils.hideLoadingDialog
import com.rezyfr.dicoding.bajp.utils.showLoadingDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment(), MovieItemAdapter.ItemClickListener,
    TvItemAdapter.ItemClickListener {

    private lateinit var binding: FragmentMainBinding
    private lateinit var key: String
    private val movieAdapter = MovieItemAdapter(this)
    private val tvAdapter = TvItemAdapter(this)

    private val vm by viewModels<ListViewModel>()

    companion object {
        private const val ARG_KEY = "arg_key"
        fun newInstance(key: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_KEY, key)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        key = arguments?.getString(ARG_KEY) ?: ""
        requireContext().showLoadingDialog()

        activity?.let {
            if (key == Constant.KEY_MOVIE) {
                vm.movieList().observe(viewLifecycleOwner, ::observeMovieList)
                binding.rvList.adapter = movieAdapter

            } else {
                vm.tvList().observe(viewLifecycleOwner, ::observeTvList)
                binding.rvList.adapter = tvAdapter
            }
        }
    }

    private fun observeMovieList(movies: List<MovieEntity>) {
        lifecycleScope.launch {
            movieAdapter.updateData(movies)
            hideLoadingDialog()
        }
    }

    private fun observeTvList(tv: List<TvEntity>) {
        lifecycleScope.launch {
            tvAdapter.updateData(tv)
            hideLoadingDialog()
        }
    }

    override fun onItemClicked(view: View, data: MovieEntity) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(Constant.FRAGMENT_KEY, key)
        intent.putExtra(Constant.ITEM_ID, data.id)
        startActivity(intent)
    }

    override fun onItemClicked(view: View, data: TvEntity) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(Constant.FRAGMENT_KEY, key)
        intent.putExtra(Constant.ITEM_ID, data.id)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        hideLoadingDialog()
    }
}