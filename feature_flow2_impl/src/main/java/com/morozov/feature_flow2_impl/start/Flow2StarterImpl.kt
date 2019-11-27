package com.morozov.feature_flow2_impl.start

import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import com.morozov.feature_flow2_api.Flow2Starter
import com.morozov.feature_flow2_api.OnScreenChangeListener
import com.morozov.feature_flow2_impl.R
import com.morozov.feature_flow2_impl.ui.DataObject

class Flow2StarterImpl: Flow2Starter {

    override fun start(manager: FragmentManager, container: Int, callback: OnScreenChangeListener) {
        DataObject.changeListener = callback

        val finalHost = NavHostFragment.create(R.navigation.nav_host)
        manager.beginTransaction()
            .replace(container, finalHost)
            .setPrimaryNavigationFragment(finalHost)
            .commitAllowingStateLoss()
    }
}