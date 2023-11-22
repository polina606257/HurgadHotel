package com.example.hurgadhotel.hotelPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.hurgadhotel.R
import com.example.hurgadhotel.databinding.FragmentHotelBinding
import com.example.hurgadhotel.utils.createAndUpdateDotIndicator
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
        hotelViewModel.hotel.observe(viewLifecycleOwner) { hotelInfo ->
            val photos = hotelInfo?.image_urls
            val adapter = photos?.let { PhotoCarouselAdapter(it) }
            binding.photoPager.adapter = adapter
            if (photos != null) {
                createAndUpdateDotIndicator(photos, requireContext(), binding.indicatorLayout, binding.photoPager)
            }

            binding.hotelName.text = hotelInfo?.name
            binding.rating.text = hotelInfo?.rating.toString()
            binding.ratingName.text = hotelInfo?.rating_name
            binding.hotelAddress.text = hotelInfo?.adress
            binding.price.text = "от ${hotelInfo?.minimal_price}р"
            binding.priceInfo.text = hotelInfo?.price_for_it
            binding.hotelDescription.text = hotelInfo?.hotelDetails?.description

            for (peculiar in hotelInfo?.hotelDetails?.peculiarities!!) {
                val peculiarView = LayoutInflater.from(context).inflate(
                    R.layout.peculiar_item,
                    binding.peculiarContainer,
                    false
                ).apply {
                    id = View.generateViewId()
                } as TextView

                peculiarView.text = peculiar
                binding.peculiarContainer.addView(peculiarView)
                binding.peculiar.addView(peculiarView)
            }
        }

        binding.toChooseRoomBtn.setOnClickListener {
            if (hotelViewModel.hotel.value != null) {
                val bundle = Bundle().apply {
                    putSerializable("hotel", hotelViewModel.hotel.value)
                }
                it.findNavController().navigate(R.id.action_hotelFragment_to_roomFragment, bundle)
            }
        }
    }
}