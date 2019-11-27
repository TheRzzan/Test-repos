package com.morozov.feature_flow2_impl.ui.screen2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.morozov.feature_flow2_impl.R
import com.morozov.feature_flow2_impl.ui.DataObject

class Screen2Fragment: Fragment() {

    companion object {
        const val TAG = "Flow2Screen2Fragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_screen2_f2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataObject.changeListener?.onScreen2()
    }
}