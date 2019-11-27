package com.morozov.feature_flow1_impl.ui.screen1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.morozov.feature_flow1_api.OnScreen1ClickListener
import com.morozov.feature_flow1_impl.R
import kotlinx.android.synthetic.main.fragment_screen1.*

class Screen1Fragment: Fragment() {

    companion object {
        const val TAG = "Flow1Screen1Fragment"
    }

    var listener: OnScreen1ClickListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_screen1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonNext.setOnClickListener {
            listener?.onScreenClicked(0)
        }
    }
}