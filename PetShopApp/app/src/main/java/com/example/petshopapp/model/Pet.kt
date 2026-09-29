package com.example.petshopapp.model

/**
 * Modelo de datos para una mascota disponible en la galería.
 * Incluye recursos multimedia: imagen, video y audio descriptivo.
 */
data class Pet(
    val id: Int,
    val name: String,
    val breed: String,
    val age: String,
    val description: String,
    val imageResId: Int,        // Imagen de la mascota
    val videoResId: Int? = null, // Video de la mascota (opcional)
    val audioResId: Int? = null  // Audio descriptivo sobre su cuidado (opcional)
)
