package com.example.petshopapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petshopapp.R
import com.example.petshopapp.model.Pet

/**
 * Adaptador para la galería de mascotas.
 * Muestra cada mascota en una CardView con su imagen, nombre, raza y edad.
 */
class PetAdapter(
    private val pets: List<Pet>,
    private val onItemClick: (Pet) -> Unit
) : RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    inner class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPet: ImageView = itemView.findViewById(R.id.imgPet)
        val txtPetName: TextView = itemView.findViewById(R.id.txtPetName)
        val txtPetBreed: TextView = itemView.findViewById(R.id.txtPetBreed)
        val txtPetAge: TextView = itemView.findViewById(R.id.txtPetAge)

        init {
            itemView.setOnClickListener {
                onItemClick(pets[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pet, parent, false)
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val pet = pets[position]
        holder.imgPet.setImageResource(pet.imageResId)
        holder.txtPetName.text = pet.name
        holder.txtPetBreed.text = pet.breed
        holder.txtPetAge.text = pet.age
    }

    override fun getItemCount(): Int = pets.size
}
