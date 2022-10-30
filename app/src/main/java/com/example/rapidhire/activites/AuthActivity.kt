package com.example.rapidhire.activites

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.fragment.NavHostFragment
import com.example.rapidhire.R
import com.example.rapidhire.databinding.ActivityAuthBinding
import com.example.rapidhire.fragments.LogInFragment
import com.example.rapidhire.fragments.RegisterFragment

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    private lateinit var btnReg: Button
    private lateinit var btnLog: Button
    private lateinit var loginfrag: Fragment
    private lateinit var regfrag: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnLog=findViewById(R.id.btnloginFrag)
        btnReg = findViewById(R.id.btnregFrag)
        loginfrag = LogInFragment()
        regfrag = RegisterFragment()

        btnLog.setOnClickListener {
            replaceFragment(loginfrag)
        }
        btnReg.setOnClickListener {
            replaceFragment(regfrag)
        }
    }

    private fun replaceFragment(fragment : Fragment ) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
        fragmentTransaction.commit()
    }
}
