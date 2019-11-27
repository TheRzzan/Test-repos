package com.morozov.feature_flow2_api

import androidx.fragment.app.FragmentManager

interface Flow2Starter {

    fun start(manager: FragmentManager, container: Int, callback: OnF2ScreenChangeListener)
}