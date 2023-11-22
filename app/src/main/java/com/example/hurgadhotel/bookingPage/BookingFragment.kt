package com.example.hurgadhotel.bookingPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.domain.modul.Hotel
import com.example.hurgadhotel.databinding.FragmentBookingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookingFragment : Fragment() {
    private lateinit var binding: FragmentBookingBinding
    private val bookingViewModel by viewModel<BookingViewModel>()
    private lateinit var hotel: Hotel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hotel = arguments?.getSerializable("hotel") as Hotel
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        bookingViewModel.bookingInfo.observe(viewLifecycleOwner) { bookingInfo ->
            binding.hotelName.text = hotel.name
            binding.hotelAddress.text = hotel.adress
            binding.rating.text = hotel.rating.toString()
            binding.ratingName.text = hotel.rating_name
            binding.rating.text = bookingInfo?.rating.toString()
            binding.ratingName.text = bookingInfo?.ratingName
            binding.hotelName.text = bookingInfo?.hotelName
            binding.departureCity.text = bookingInfo?.departure
            binding.arrivalCity.text = bookingInfo?.arrivalCountry
            binding.dates.text =
                "${bookingInfo?.tourDateStart} - ${bookingInfo?.tourDateStop}"
            binding.numberOfNights.text =
                "${bookingInfo?.numberOfNights} ночей"
            binding.room.text = bookingInfo?.room
            binding.food.text = bookingInfo?.nutrition
        }
    }
}


