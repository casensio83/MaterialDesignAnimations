package com.example.materialdesignanimations.presentation

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.View
import com.example.materialdesignanimations.AnimationType
import com.example.materialdesignanimations.R
import kotlinx.android.synthetic.main.activity_main.*

const val animation_type = "animationType"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonExplodeXml.setOnClickListener { goToActivity(AnimationType.EXPLODE_XML) }
        buttonExplodeCode.setOnClickListener { goToActivity(AnimationType.EXPLODE_CODE) }
        buttonFadeXml.setOnClickListener { goToActivity(AnimationType.FADE_XML) }
        buttonFadeCode.setOnClickListener { goToActivity(AnimationType.FADE_CODE) }
        buttonSlideXml.setOnClickListener { goToActivity(AnimationType.SLIDE_XML) }
        buttonSlideCode.setOnClickListener { goToActivity(AnimationType.SLIDE_CODE) }
        sharedElements.setOnClickListener { goToSharedElementsActivity() }
    }

    private fun goToActivity(animationType: AnimationType) {
        val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this)
        val intent = Intent(this, AnimationActivity::class.java)
        intent.putExtra(animation_type, animationType)
        startActivity(intent, options.toBundle())
    }

    private fun goToSharedElementsActivity() {
        val pairTitle = Pair<View, String>(sharedElementsTv, "sharedElementsTitle")
        val pairImage = Pair<View, String>(sharedElementsIv, "sharedElementsImage")

        val options = ActivityOptions.makeSceneTransitionAnimation(this, pairTitle, pairImage)
        val intent = Intent(this, SharedElementsActivity::class.java)
        startActivity(intent, options.toBundle())
    }
}
