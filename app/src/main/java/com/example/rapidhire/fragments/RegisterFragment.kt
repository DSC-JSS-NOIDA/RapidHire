package com.example.rapidhire.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.rapidhire.R


class RegisterFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_register, container, false)
        val tvLogin = view.findViewById<TextView>(R.id.signUp)
        tvLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_logInFragment)
        }

        return view
    }



}