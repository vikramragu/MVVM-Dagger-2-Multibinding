package com.example.samplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.samplemvvm.R
import com.example.samplemvvm.dagger.factory.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Named

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory : ViewModelFactory
    lateinit var viewModel: MainActivityViewModel
    /*@Inject
    lateinit var temp : String*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
