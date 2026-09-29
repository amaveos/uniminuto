package com.example.petshopapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petshopapp.R
import com.example.petshopapp.adapter.ProductAdapter
import com.example.petshopapp.model.Product

/**
 * Fragmento que muestra el catálogo de productos de la tienda.
 * Usa RecyclerView con LinearLayoutManager para una lista vertical
 * de productos con imagen, nombre, descripción y precio.
 */
class CatalogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerProducts)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Datos de ejemplo para el catálogo de productos
        val products = listOf(
            Product(1, "Alimento Premium Perro", "Alimento balanceado para perros adultos 15kg",
                45.99, R.drawable.ic_product_placeholder),
            Product(2, "Juguete Interactivo Gato", "Juguete con plumas y cascabel para gatos",
                12.50, R.drawable.ic_product_placeholder),
            Product(3, "Cama Ortopédica", "Cama ortopédica para mascotas medianas",
                35.00, R.drawable.ic_product_placeholder),
            Product(4, "Collar GPS Rastreador", "Collar con rastreo GPS en tiempo real",
                89.99, R.drawable.ic_product_placeholder),
            Product(5, "Kit de Aseo Canino", "Incluye cepillo, shampoo y cortaúñas",
                28.75, R.drawable.ic_product_placeholder)
        )

        // Configurar adaptador con listener de clic
        val adapter = ProductAdapter(products) { product ->
            Toast.makeText(
                requireContext(),
                "Producto: ${product.name} - $${product.price}",
                Toast.LENGTH_SHORT
            ).show()
        }
        recyclerView.adapter = adapter
    }
}
