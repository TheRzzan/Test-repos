package com.morozov.feature_flow1_impl.ui.screen2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.morozov.feature_flow1_impl.R

class Screen2Fragment: Fragment() {

    companion object {
        const val TAG = "Flow1Screen2Fragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_screen2, container, false)
    }
}