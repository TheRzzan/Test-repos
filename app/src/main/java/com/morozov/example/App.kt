package com.morozov.example

import android.app.Application
import com.morozov.feature_flow1_api.Flow1FeatureApi
import com.morozov.feature_flow1_api.Flow1Starter
import com.morozov.feature_flow1_impl.Flow1FeatureApiImpl
import com.morozov.feature_flow1_impl.start.Flow1StarterImpl
import com.morozov.feature_flow2_api.Flow2FeatureApi
import com.morozov.feature_flow2_api.Flow2Starter
import com.morozov.feature_flow2_impl.Flow2FeatureApiImpl
import com.morozov.feature_flow2_impl.start.Flow2StarterImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class App: Application() {

    companion object{
        private val flow1Module = Kodein.Module("flow1") {
            bind<Flow1Starter>() with singleton { Flow1StarterImpl() }
            bind<Flow1FeatureApi>() with singleton { Flow1FeatureApiImpl(instance()) }
        }

        private val flow2Module = Kodein.Module("flow2") {
            bind<Flow2Starter>() with singleton { Flow2StarterImpl() }
            bind<Flow2FeatureApi>() with singleton { Flow2FeatureApiImpl(instance()) }
        }

        val kodein = Kodein.lazy {
            import(flow1Module)
            import(flow2Module)
        }
    }
}