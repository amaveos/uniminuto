package com.example.petshopapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petshopapp.R
import com.example.petshopapp.model.Product

/**
 * Adaptador para mostrar la lista de productos en un RecyclerView.
 * Usa CardView para cada item, mostrando imagen, nombre, descripción y precio.
 */
class ProductAdapter(
    private val products: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    /**
     * ViewHolder que mantiene las referencias a las vistas de cada tarjeta de producto.
     * Evita llamadas repetidas a findViewById mejorando el rendimiento.
     */
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProduct: ImageView = itemView.findViewById(R.id.imgProduct)
        val txtName: TextView = itemView.findViewById(R.id.txtProductName)
        val txtDescription: TextView = itemView.findViewById(R.id.txtProductDescription)
        val txtPrice: TextView = itemView.findViewById(R.id.txtProductPrice)

        init {
            // Listener para manejar el clic en cada producto
            itemView.setOnClickListener {
                onItemClick(products[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.imgProduct.setImageResource(product.imageResId)
        holder.txtName.text = product.name
        holder.txtDescription.text = product.description
        holder.txtPrice.text = "$${String.format("%.2f", product.price)}"
    }

    override fun getItemCount(): Int = products.size
}
