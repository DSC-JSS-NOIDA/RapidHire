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
import com.example.rapidhire.activites.AuthActivity
import com.example.rapidhire.activites.CandidateProfileScreen
import com.example.rapidhire.databinding.FragmentLogInBinding
import com.google.firebase.auth.FirebaseAuth

class LogInFragment : Fragment(R.layout.fragment_log_in) {
    private lateinit var binding: FragmentLogInBinding
    lateinit var etName: EditText
    lateinit var etPass: EditText
    lateinit var auth: FirebaseAuth
    private lateinit var btnLogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentLogInBinding.inflate(inflater,container,false)
        val view=binding.root
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val tvRegister = view.findViewById<TextView>(R.id.textView)
        etName = view.findViewById(R.id.etName)
        etPass = view.findViewById(R.id.enterPass)
        btnLogin = view.findViewById(R.id.logIn)

        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            login()
        }
        /*tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_registerFragment)
        }*/
    }
    private fun login() {
        val email = etName.text.toString()
        val pass = etPass.text.toString()
        // calling signInWithEmailAndPassword(email, pass)
        // function using Firebase auth object
        // On successful response Display a Toast
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(requireActivity()) { task ->
            val i = Intent(requireActivity(), CandidateProfileScreen::class.java)
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Toast.makeText(requireActivity(), "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                startActivity(i)
            } else {
                Toast.makeText(requireActivity(), "Log In failed ", Toast.LENGTH_SHORT).show()
                // If sign in fails, display a message to the user.
            }
        }
    }
}
