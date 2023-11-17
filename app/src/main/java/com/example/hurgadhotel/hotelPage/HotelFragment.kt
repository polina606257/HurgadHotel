package com.example.hurgadhotel.hotelPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.hurgadhotel.R
import com.example.hurgadhotel.databinding.FragmentHotelBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HotelFragment : Fragment() {
    private lateinit var binding: FragmentHotelBinding
    private val hotelViewModel by viewModel<HotelViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHotelBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        hotelViewModel.hotel.observe(viewLifecycleOwner)  { hotelInfo ->
            val photos = hotelInfo?.image_urls
            val adapter = photos?.let { PhotoCarouselAdapter(it) }
            binding.hotelPhotoPager.adapter = adapter
        }

        binding.toChooseNumberBtn.setOnClickListener {
            val bundle = Bundle().apply {
                putString("hotelName", hotelViewModel.hotel.value?.name)
            }
            it.findNavController().navigate(R.id.action_hotelFragment_to_roomFragment, bundle)
        }
    }
}