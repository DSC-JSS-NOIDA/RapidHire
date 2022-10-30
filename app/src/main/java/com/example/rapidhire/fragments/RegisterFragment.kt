package com.example.rapidhire.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rapidhire.R
import com.example.rapidhire.activites.CandidateProfileScreen
import com.example.rapidhire.databinding.FragmentLogInBinding
import com.example.rapidhire.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.regex.Pattern

class RegisterFragment : Fragment(R.layout.fragment_register) {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var userName: EditText
    private lateinit var userPhone: EditText
    private lateinit var userEmail: EditText
    private lateinit var userPassword: EditText
    private lateinit var signUpBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentRegisterBinding.inflate(inflater,container,false)


        val tvLogin =binding.textView
        tvLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_logInFragment)
        }
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // View Bindings
        userName = view.findViewById(R.id.etusername)
        userPhone = view.findViewById(R.id.phonenumber)
        userEmail = view.findViewById(R.id.etemail)
        userPassword = view.findViewById(R.id.etPassword)
        signUpBtn = view.findViewById(R.id.signUp)

        // Initialising auth object
        auth = Firebase.auth

        signUpBtn.setOnClickListener {
            signUpUser()
        }


    }



    private fun signUpUser() {
        val email = userEmail.text.toString()
        val pass = userPassword.text.toString()
        val phoneNumber = userPhone.text.toString()
        val name = userName.text.toString()

        // check pass
        if (email.isBlank() || pass.isBlank() || phoneNumber.isBlank() || name.isBlank()) {
            Toast.makeText(requireActivity(), "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        // If all credential are correct
        // We call createUserWithEmailAndPassword
        // using auth object and pass the
        // email and pass in it.
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(requireActivity()) {
            if (it.isSuccessful) {
                Toast.makeText(requireActivity(), "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                val i = Intent(requireActivity(), LogInFragment::class.java)
            } else {
                Toast.makeText(requireActivity(), "Singed Up Failed! "  + it.exception, Toast.LENGTH_LONG).show()
            }
        }
    }
    }
