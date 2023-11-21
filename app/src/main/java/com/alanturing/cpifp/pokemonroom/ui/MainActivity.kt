package com.alanturing.cpifp.pokemonroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alanturing.cpifp.pokemonroom.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}