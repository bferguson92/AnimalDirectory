package com.example.animaldirectory.adapters

import android.view.LayoutInflater
import android.view.TouchDelegate
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.animaldirectory.R
import com.example.animaldirectory.models.Animal
import org.w3c.dom.Text

class AnimalAdapter(
    private val animalList: List<Animal>,
    private val animalDelegate: AnimalDelegate
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    interface AnimalDelegate {
        fun selectAnimal(animal: Animal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.animal_item_layout, parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.apply {
            animalSpecies.text = animalList[position].species
            viewGroup.setOnClickListener {
                animalDelegate.selectAnimal(animalList[position])
            }

        }
    }

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val animalSpecies: TextView = view.findViewById(R.id.tvSpecies)
        val viewGroup: ConstraintLayout = view.findViewById(R.id.animalLayout)
    }
}