package com.morozov.feature_flow1_impl.start

import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import com.morozov.feature_flow1_api.Flow1Starter
import com.morozov.feature_flow1_api.OnF1ScreenChangeListener
import com.morozov.feature_flow1_impl.R
import com.morozov.feature_flow1_impl.ui.DataObject

class Flow1StarterImpl: Flow1Starter {

    override fun start(manager: FragmentManager, container: Int, callback: OnF1ScreenChangeListener) {
        DataObject.changeListener = callback

        val finalHost = NavHostFragment.create(R.navigation.nav_host_ff1)
        manager.beginTransaction()
            .replace(container, finalHost)
            .setPrimaryNavigationFragment(finalHost)
            .commitAllowingStateLoss()
    }
}