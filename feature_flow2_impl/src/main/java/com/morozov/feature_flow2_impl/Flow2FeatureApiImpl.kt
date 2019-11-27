package com.morozov.feature_flow2_impl

import com.morozov.feature_flow2_api.Flow2FeatureApi
import com.morozov.feature_flow2_api.Flow2Starter

class Flow2FeatureApiImpl(private val starter: Flow2Starter): Flow2FeatureApi {

    override fun flow2Starter(): Flow2Starter = starter
}