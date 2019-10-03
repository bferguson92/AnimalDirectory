package com.example.animaldirectory.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.animaldirectory.R
import com.example.animaldirectory.models.Animal
import kotlinx.android.synthetic.main.activity_animal_categories.*

class AnimalCategories : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_categories)
        setUpView()
    }

    private fun setUpView() {
        val categoryList = arrayListOf("Mammals", "Reptile", "Amphibians", "Birds")

        lvAnimalCategories.adapter = ArrayAdapter(
            this,
            R.layout.animal_category_item_layout,
            R.id.tvCategory, categoryList
        )


        lvAnimalCategories.setOnItemClickListener { parent, view, position, id ->
            when (parent.getItemAtPosition(position)) {
                "Mammals" -> startAnimalList()
                "Reptile" -> startAnimalList()
                "Amphibians" -> startAnimalList()
                "Birds" -> startAnimalList()
            }
        }
    }

    fun startAnimalList() {
        val intent = Intent(this, AnimalList::class.java)
        val mammalList = arrayListOf<Animal>()

        val monkey = Animal(
            "Deer",
            "Mammal",
            "20'",
            "3000lbs",
            "sound_file_string"
        )

        val bear = Animal(
            "Bear",
            "Mammal",
            "2.6 meter'",
            "800 kilograms",
            "sound_file_string"
        )

        mammalList.add(monkey)
        mammalList.add(bear)


        intent.putParcelableArrayListExtra("animal", mammalList)
        startActivity(intent)


    }
}
