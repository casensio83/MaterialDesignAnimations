package com.example.materialdesignanimations.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionInflater
import android.view.Gravity
import com.example.materialdesignanimations.AnimationType
import com.example.materialdesignanimations.R

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        initAnimation(intent.getSerializableExtra(animation_type) as AnimationType)
    }

    private fun initAnimation(animationType: AnimationType) {
        when (animationType) {
            AnimationType.EXPLODE_XML -> {
                val explodeTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode)
                window.enterTransition = explodeTransition
            }

            AnimationType.EXPLODE_CODE -> {
                val explodeTransition = Explode()
                explodeTransition.duration = 1000
                window.enterTransition = explodeTransition
            }

            AnimationType.FADE_XML -> {
                val fadeTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade)
                window.enterTransition = fadeTransition
            }

            AnimationType.FADE_CODE -> {
                val fadeTransition = Fade()
                fadeTransition.duration = 1000
                window.enterTransition = fadeTransition
            }

            AnimationType.SLIDE_XML -> {
                val slideTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide)
                window.enterTransition = slideTransition
            }

            AnimationType.SLIDE_CODE -> {
                val slideTransition = Slide()
                slideTransition.duration = 1000
                slideTransition.slideEdge = Gravity.RIGHT
                window.enterTransition = slideTransition
            }
        }
    }
}
