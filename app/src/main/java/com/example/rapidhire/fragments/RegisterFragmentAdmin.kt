package com.example.rapidhire.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rapidhire.R


class RegisterFragmentAdmin : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register_admin, container, false)
        val tvLogin = view.findViewById<TextView>(R.id.tv_signin)
        tvLogin.setOnClickListener {
            // Code logic to navigate from "fragment_register_admin" layout to "fragment_login" layout
        }
        return view
    }
}