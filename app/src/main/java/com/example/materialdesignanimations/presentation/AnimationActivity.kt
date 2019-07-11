package com.example.materialdesignanimations.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.TransitionInflater
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
        }
    }
}
