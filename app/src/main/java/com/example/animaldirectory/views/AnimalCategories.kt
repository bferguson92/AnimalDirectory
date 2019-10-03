package com.example.animaldirectory.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.animaldirectory.R
import kotlinx.android.synthetic.main.activity_animal_categories.*

class AnimalCategories : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_categories)
        setUpView()
    }

    private fun setUpView() {
        val categoryList = arrayOf("Mammals", "Reptile", "Amphibians", "Bird")

        lvAnimalCategories.adapter = ArrayAdapter(
            this,
            R.layout.animal_category_item_layout,
            R.id.tvCategory, categoryList)


        lvAnimalCategories.setOnItemClickListener{parent, view, position, id ->
            when(parent.getItemAtPosition(position)){
                "Mammals" -> {
                    val intent = Intent(this, AnimalList::class.java)
                    val mammalList = arrayOf("Otter", "Dolphin")
                    intent.putExtra("animal",mammalList)
                    startActivity(intent)
                }
            }
        }
    }
}
