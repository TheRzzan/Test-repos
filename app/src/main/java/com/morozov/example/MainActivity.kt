package com.morozov.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.morozov.feature_flow1_api.Flow1FeatureApi
import com.morozov.feature_flow1_api.OnScreen1ClickListener
import com.morozov.feature_flow2_api.Flow2FeatureApi
import com.morozov.feature_flow2_api.OnScreenChangeListener
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein = App.kodein

    private val flow1Api: Flow1FeatureApi by instance()
    private val flow2Api: Flow2FeatureApi by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flow1.setOnClickListener {
            clearBackStack()
            flow1Api.flow1Starter().startScreen1(supportFragmentManager, R.id.contentMain, object : OnScreen1ClickListener {
                override fun onScreenClicked(id: Int) {
                    flow1Api.flow1Starter().startScreen2(supportFragmentManager, R.id.contentMain)
                }
            })
        }

        flow2.setOnClickListener {
            clearBackStack()
            flow2Api.flow2Starter().start(supportFragmentManager, R.id.contentMain, object : OnScreenChangeListener {
                override fun onScreen1() {
                    Toast.makeText(applicationContext, "Screen 1 flow 2", Toast.LENGTH_SHORT).show()
                }

                override fun onScreen2() {
                    Toast.makeText(applicationContext, "Screen 2 flow 2", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun clearBackStack() {
        var i = 0

        while (i < supportFragmentManager.backStackEntryCount) {
            supportFragmentManager.popBackStack()
            i++
        }
    }
}
