package com.example.hurgadhotel.hotelPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
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
        hotelViewModel.hotel.observe(viewLifecycleOwner) { hotelInfo ->
            val photos = hotelInfo?.image_urls
            val adapter = photos?.let { PhotoCarouselAdapter(it) }
            binding.photoPager.adapter = adapter
            createAndUpdateDotIndicator(photos)

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

        binding.toChooseNumberBtn.setOnClickListener {
            val bundle = Bundle().apply {
                putString("hotelName", hotelViewModel.hotel.value?.name)
            }
            it.findNavController().navigate(R.id.action_hotelFragment_to_roomFragment, bundle)
        }
    }

    private fun createAndUpdateDotIndicator(photos: ArrayList<String>?) {
        if (photos?.indices != null) {
            for (i in photos.indices) {
                val dot = ImageView(requireContext())
                dot.setImageResource(R.drawable.indicator_dot)
                dot.isSelected = (i == 0)
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(8, 0, 8, 0)
                dot.layoutParams = params
                binding.indicatorLayout.addView(dot)
            }

            binding.photoPager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    for (i in 0 until binding.indicatorLayout.childCount) {
                        binding.indicatorLayout.getChildAt(i).isSelected = (i == position)
                    }
                }
            })
        }
    }
}