package com.example.animaldirectory.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.animaldirectory.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCategoriesOfAnimals.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnCategoriesOfAnimals -> {
                val intent = Intent(this, AnimalCategories::class.java)
                startActivity(intent)
            }
        }

    }
}
