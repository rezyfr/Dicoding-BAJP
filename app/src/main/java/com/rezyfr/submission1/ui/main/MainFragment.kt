package com.rezyfr.submission1.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rezyfr.submission1.data.ItemEntity
import com.rezyfr.submission1.databinding.FragmentMainBinding
import com.rezyfr.submission1.ui.detail.DetailActivity
import com.rezyfr.submission1.utils.Constant

class MainFragment : Fragment(), MainListAdapter.ItemClickListener {

    private lateinit var binding: FragmentMainBinding
    private lateinit var key: String

    private val vm by viewModels<MainViewModel>()

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

        activity?.let {
            val data = vm.getDataList(key)

            val adapter = MainListAdapter(this)
            adapter.updateData(data)

            binding.rvList.adapter = adapter
        }

    }

    companion object {
        private const val ARG_KEY = "arg_key"
        fun newInstance(key: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_KEY, key)
                }
            }
    }

    override fun onItemClicked(view: View, data: ItemEntity) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(Constant.FRAGMENT_KEY, key)
        intent.putExtra(Constant.ITEM_ID, data.id)
        startActivity(intent)
    }
}