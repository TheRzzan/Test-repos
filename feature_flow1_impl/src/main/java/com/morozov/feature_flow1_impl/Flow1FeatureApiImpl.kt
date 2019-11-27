package com.morozov.feature_flow1_impl

import com.morozov.feature_flow1_api.Flow1FeatureApi
import com.morozov.feature_flow1_api.Flow1Starter

class Flow1FeatureApiImpl(private val starter: Flow1Starter): Flow1FeatureApi {

    override fun flow1Starter(): Flow1Starter = starter
}