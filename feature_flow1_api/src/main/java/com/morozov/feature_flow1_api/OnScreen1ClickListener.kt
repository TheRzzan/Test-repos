package com.morozov.feature_flow1_api

import java.io.Serializable

interface OnScreen1ClickListener: Serializable {

    fun onScreenClicked(id: Int)
}