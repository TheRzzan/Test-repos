package com.morozov.feature_flow1_api

import androidx.fragment.app.FragmentManager

interface Flow1Starter {

    fun start(manager: FragmentManager, container: Int, callback: OnF1ScreenChangeListener)
}