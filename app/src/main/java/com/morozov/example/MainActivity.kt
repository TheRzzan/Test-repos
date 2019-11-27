package com.morozov.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.morozov.feature_flow1_api.Flow1FeatureApi
import com.morozov.feature_flow1_api.OnF1ScreenChangeListener
import com.morozov.feature_flow2_api.Flow2FeatureApi
import com.morozov.feature_flow2_api.OnF2ScreenChangeListener
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

//Some little changes
class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein = App.kodein

    private val flow1Api: Flow1FeatureApi by instance()
    private val flow2Api: Flow2FeatureApi by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flow1.setOnClickListener {
            clearBackStack()
            flow1Api.flow1Starter().start(supportFragmentManager, R.id.contentMain, object : OnF1ScreenChangeListener {
                override fun onScreen1() {
                    showBottomNav()
                }

                override fun onScreen2() {
                    hideBottomNav()
                }
            })
        }

        flow2.setOnClickListener {
            clearBackStack()
            flow2Api.flow2Starter().start(supportFragmentManager, R.id.contentMain, object : OnF2ScreenChangeListener {
                override fun onScreen1() {
                    showBottomNav()
                }

                override fun onScreen2() {
                    hideBottomNav()
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

    private fun showBottomNav() {
        linearBottomNav.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        linearBottomNav.visibility = View.GONE
    }
}
