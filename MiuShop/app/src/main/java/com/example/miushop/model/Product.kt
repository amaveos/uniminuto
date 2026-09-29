package com.example.miushop.model

/**
 * Modelo de datos para un producto de la tienda de mascotas.
 * Contiene información básica del producto y recursos multimedia asociados.
 */
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageResId: Int,       // Recurso drawable de la imagen del producto
    val videoResId: Int? = null, // Recurso raw del video (opcional)
    val audioResId: Int? = null  // Recurso raw del audio descriptivo (opcional)
)
