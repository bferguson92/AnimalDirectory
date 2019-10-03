package com.example.animaldirectory.views

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.animaldirectory.R
import com.example.animaldirectory.models.Animal
import kotlinx.android.synthetic.main.activity_show_animal.*

class ShowAnimal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_animal)

        val animal = intent.getParcelableExtra<Animal>("animal")
        if (animal != null) {
            tvAnimalName.text = animal.species
            tvAnimalCategory.text = animal.category
            tvAnimalHeight.text = animal.avgHeight
            tvAnimalWeight.text = animal.avgWeight

        }
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnPlaySound -> playSound()
        }
    }

    fun playSound() {

        var sound = MediaPlayer.create(this, R.raw.roar)
        sound.start()
    }
}
