package com.example.rapidhire.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rapidhire.R


class LogInFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_log_in, container, false)
        val tvRegister = view.findViewById<TextView>(R.id.tv_register)
        tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_registerFragment)
        }
        return  view
    }
}