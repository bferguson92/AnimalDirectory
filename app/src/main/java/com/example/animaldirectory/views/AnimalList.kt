package com.example.animaldirectory.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.VERTICAL
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animaldirectory.R
import com.example.animaldirectory.adapters.AnimalAdapter
import com.example.animaldirectory.models.Animal
import kotlinx.android.synthetic.main.activity_animals.*

class AnimalList : AppCompatActivity(), AnimalAdapter.AnimalDelegate {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)
        setUpView()
    }

    private fun setUpView() {
        var animalList = intent.getParcelableArrayListExtra<Animal>("animal")
        for (animal in animalList) {
            Log.d("ANIMAL", animal.species)
        }
        rvAnimals.adapter = AnimalAdapter(animalList, this)
        rvAnimals.layoutManager = LinearLayoutManager(this)

        val itemDecorator  = DividerItemDecoration(this, VERTICAL)
        rvAnimals.addItemDecoration(itemDecorator)
    }

    override fun selectAnimal(animal: Animal) {
        val intent = Intent(this, ShowAnimal::class.java)
        intent.putExtra("animal", animal)
        startActivity(intent)
    }

}
