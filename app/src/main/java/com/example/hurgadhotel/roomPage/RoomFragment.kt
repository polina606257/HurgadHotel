package com.example.hurgadhotel.roomPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hurgadhotel.databinding.FragmentRoomBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoomFragment : Fragment() {
    private lateinit var binding: FragmentRoomBinding
    private val roomViewModel by viewModel<RoomViewModel>()
    private lateinit var roomAdapter: RoomAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRoomBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val hotelName = arguments?.getString("hotelName")
        roomViewModel.rooms.observe(viewLifecycleOwner) { rooms ->
            binding.apply {
                roomAdapter = rooms?.rooms?.let { RoomAdapter(it, requireContext()) }!!
                roomRecyclerView.adapter = roomAdapter
                roomRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            }
            binding.toolbarTitle.text = hotelName
        }
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}