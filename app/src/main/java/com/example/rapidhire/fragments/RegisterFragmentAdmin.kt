package com.example.rapidhire.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rapidhire.R
import com.example.rapidhire.databinding.FragmentRegisterAdminBinding
import com.example.rapidhire.databinding.FragmentRegisterBinding


class RegisterFragmentAdmin : Fragment(R.layout.fragment_register_admin) {
    private lateinit var binding: FragmentRegisterAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentRegisterAdminBinding.inflate(inflater,container,false)
        val view = inflater.inflate(R.layout.fragment_register_admin, container, false)
        val tvLogin = binding.tvSignin
        tvLogin.setOnClickListener {

        }
        return binding.root
    }
}