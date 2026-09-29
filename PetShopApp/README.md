# PetShop App

Aplicación móvil Android para una tienda de mascotas desarrollada con Kotlin y Android Studio.

## Funcionalidades

- **Catálogo de productos**: Lista de productos con imágenes, descripciones y precios usando RecyclerView + CardView.
- **Galería de mascotas**: Cuadrícula de mascotas disponibles con GridLayoutManager.
- **Reproducción de video**: VideoView con MediaController para videos de mascotas.
- **Reproductor de audio**: MediaPlayer para descripciones de cuidado de mascotas.
- **Navegación**: BottomNavigationView para cambiar entre secciones.

## Estructura del proyecto

```
PetShopApp/
├── app/src/main/
│   ├── java/com/example/petshopapp/
│   │   ├── MainActivity.kt
│   │   ├── adapter/
│   │   │   ├── ProductAdapter.kt
│   │   │   └── PetAdapter.kt
│   │   ├── model/
│   │   │   ├── Product.kt
│   │   │   └── Pet.kt
│   │   └── ui/
│   │       ├── CatalogFragment.kt
│   │       ├── GalleryFragment.kt
│   │       └── PetDetailFragment.kt
│   └── res/
│       ├── layout/
│       ├── menu/
│       ├── values/
│       └── raw/ (archivos de audio y video)
```

## Requisitos

- Android Studio Arctic Fox o superior
- Kotlin 1.9+
- SDK mínimo: API 24 (Android 7.0)

## Autor

Ana Maria Velez Ossa - UNIMINUTO  
Desarrollo de Software en Plataformas Móviles (NRC-69887)
