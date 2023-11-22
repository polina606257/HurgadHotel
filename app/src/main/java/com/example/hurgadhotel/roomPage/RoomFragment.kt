package com.example.hurgadhotel.roomPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.modul.Hotel
import com.example.hurgadhotel.R
import com.example.hurgadhotel.databinding.FragmentRoomBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoomFragment : Fragment() {
    private lateinit var binding: FragmentRoomBinding
    private val roomViewModel by viewModel<RoomViewModel>()
    private lateinit var roomAdapter: RoomAdapter
    private lateinit var hotel: Hotel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRoomBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hotel = arguments?.getSerializable("hotel") as Hotel
        roomViewModel.rooms.observe(viewLifecycleOwner) { rooms ->
            binding.apply {
                if (rooms != null) {
                    roomAdapter = RoomAdapter(rooms.rooms, requireContext()) { onChooseRoomClicked()}
                    binding.roomRecyclerView.adapter = roomAdapter
                    binding.roomRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                }
            }
            binding.toolbarTitle.text = hotel.name
        }
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun onChooseRoomClicked() {
        val bundle = Bundle().apply {
            putSerializable("hotel", hotel)
        }
        findNavController().navigate(R.id.action_roomFragment_to_bookingFragment, bundle)
    }
}