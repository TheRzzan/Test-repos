package com.morozov.feature_flow1_impl.start

import androidx.fragment.app.FragmentManager
import com.morozov.feature_flow1_api.Flow1Starter
import com.morozov.feature_flow1_api.OnScreen1ClickListener
import com.morozov.feature_flow1_impl.ui.screen1.Screen1Fragment
import com.morozov.feature_flow1_impl.ui.screen2.Screen2Fragment

class Flow1StarterImpl: Flow1Starter {

    override fun startScreen1(manager: FragmentManager, container: Int, callback: OnScreen1ClickListener) {
        val fragment = Screen1Fragment()
        fragment.listener = callback
        manager
            .beginTransaction()
            .replace(container, fragment)
//            .addToBackStack(Screen1Fragment.TAG)
            .commitAllowingStateLoss()
    }

    override fun startScreen2(manager: FragmentManager, container: Int) {
        manager
            .beginTransaction()
            .replace(container, Screen2Fragment())
            .addToBackStack(Screen1Fragment.TAG)
            .commitAllowingStateLoss()
    }
}