package com.morozov.feature_flow2_impl.ui.screen1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.morozov.feature_flow2_impl.R
import com.morozov.feature_flow2_impl.ui.DataObject
import kotlinx.android.synthetic.main.fragment_screen1_f2.*

class Screen1Fragment: Fragment() {

    companion object {
        const val TAG = "Flow2Screen1Fragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_screen1_f2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataObject.changeListener?.onScreen1()

        buttonNext.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_screen1Fragment_to_screen2Fragment)
        }
    }
}