package com.morozov.feature_flow1_api

import androidx.fragment.app.FragmentManager

interface Flow1Starter {

    fun startScreen1(manager: FragmentManager, container: Int, callback: OnScreen1ClickListener)
    fun startScreen2(manager: FragmentManager, container: Int)
}