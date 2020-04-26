package com.example.samplemvvm.view

import androidx.lifecycle.ViewModel
import com.example.mymvvm.network.ClientApi
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val api: ClientApi): ViewModel() {


}