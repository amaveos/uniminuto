package com.example.petshopapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petshopapp.R
import com.example.petshopapp.adapter.PetAdapter
import com.example.petshopapp.model.Pet

/**
 * Fragmento que muestra la galería de mascotas disponibles.
 * Usa un GridLayoutManager de 2 columnas para mostrar las mascotas
 * en formato de cuadrícula con sus imágenes y datos básicos.
 */
class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerPets)
        // GridLayoutManager con 2 columnas para vista de galería
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        // Datos de ejemplo para la galería de mascotas
        val pets = listOf(
            Pet(1, "Luna", "Labrador Retriever", "2 años",
                "Labrador juguetona y cariñosa, ideal para familias.",
                R.drawable.ic_pet_placeholder),
            Pet(2, "Milo", "Gato Siamés", "1 año",
                "Gato tranquilo y sociable, perfecto para apartamentos.",
                R.drawable.ic_pet_placeholder),
            Pet(3, "Rocky", "Bulldog Francés", "3 años",
                "Bulldog amigable que se lleva bien con niños.",
                R.drawable.ic_pet_placeholder),
            Pet(4, "Nala", "Golden Retriever", "6 meses",
                "Cachorra enérgica y fácil de entrenar.",
                R.drawable.ic_pet_placeholder)
        )

        val adapter = PetAdapter(pets) { pet ->
            // Al hacer clic en una mascota, abrir su detalle con multimedia
            val detailFragment = PetDetailFragment.newInstance(pet)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, detailFragment)
                .addToBackStack(null) // Permite volver con botón atrás
                .commit()
        }
        recyclerView.adapter = adapter
    }
}
