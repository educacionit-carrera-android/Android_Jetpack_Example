package com.example.androidjetpackexample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.androidjetpackexample.data.OnBoarding
import com.example.androidjetpackexample.databinding.FragmentOnboardingContentBinding

class OnBoardingContentFragment : Fragment() {

    private var _binding: FragmentOnboardingContentBinding? = null
    private val binding get() = _binding!!
    private var onBoarding: OnBoarding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            onBoarding = it.getParcelable(ON_BOARDING) as OnBoarding?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            imageView.setImageDrawable(getDrawable(requireContext(), onBoarding?.imagen ?: -1))
            textViewTitulo.text = onBoarding?.titulo
            textViewSubtitulo.text = onBoarding?.descripcion
        }
    }

    companion object {
        private const val ON_BOARDING = "OnBoarding"

        fun newInstance(onBoarding: OnBoarding): OnBoardingContentFragment {
            val args = bundleOf(
                ON_BOARDING to onBoarding
            )

            val fragment = OnBoardingContentFragment()
            fragment.arguments = args
            return fragment
        }
    }
}