package com.example.androidjetpackexample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidjetpackexample.R
import com.example.androidjetpackexample.data.OnBoarding
import com.example.androidjetpackexample.databinding.FragmentOnboardingBinding
import com.example.androidjetpackexample.ui.adapters.OnBoardingSlidePagerAdapter

class OnBoardingContainerFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        crearViewPager()
        binding.textViewHome.setOnClickListener{
            findNavController().navigate(R.id.goToLibros)
        }
    }

    private fun crearViewPager() {
        val fragments = crearFragmentosOnBoarding()
        val adapter = OnBoardingSlidePagerAdapter(
            fragments,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.viewPager.adapter = adapter
    }

    private fun crearFragmentosOnBoarding() = listOf(
        OnBoardingContentFragment.newInstance(
            OnBoarding(
                R.drawable.onboarding_1,
                "Bienvenido!!",
                "En esta app encontrarás todo lo que necesitas para almacenar los libros que desees leer o que te hayan gustado"
            )
        ),
        OnBoardingContentFragment.newInstance(
            OnBoarding(
                R.drawable.onboarding_2,
                "Calidad",
                "Esta app fue construida aplicando las librerías de Jetpack propuestas y creadas por Google."
            )
        )
    )
}