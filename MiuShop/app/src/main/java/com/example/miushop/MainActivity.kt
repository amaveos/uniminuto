package com.example.miushop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.miushop.ui.CatalogFragment
import com.example.miushop.ui.GalleryFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Activity principal de la aplicación MiuShop.
 * Maneja la navegación entre las secciones de Catálogo y Galería
 * mediante un BottomNavigationView.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigation)

        // Cargar el fragmento de catálogo por defecto al iniciar
        if (savedInstanceState == null) {
            loadFragment(CatalogFragment())
        }

        // Listener para cambiar entre las secciones de la app
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_catalog -> {
                    loadFragment(CatalogFragment())
                    true
                }
                R.id.nav_gallery -> {
                    loadFragment(GalleryFragment())
                    true
                }
                else -> false
            }
        }
    }

    /**
     * Reemplaza el fragmento actual en el contenedor principal.
     * Usa replace en lugar de add para evitar acumulación de fragmentos en memoria.
     */
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
