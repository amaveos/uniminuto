# HolaAndroid 🤖

Proyecto de la actividad **Foro Android Dev Hub** — Desarrollo de Software en Plataformas Móviles, UNIMINUTO.

## Descripción

Aplicación Android nativa desarrollada en **Kotlin** que muestra un mensaje de bienvenida y un botón interactivo:

- Al iniciar, la pantalla muestra **"¡Hola, Android!"** centrado en la pantalla.
- Al presionar el botón **"Presionar"**, el mensaje cambia a **"¡Botón presionado!"**.

## Tecnologías utilizadas

| Tecnología | Uso |
|---|---|
| **Kotlin** | Lenguaje de programación principal |
| **Android Studio** | IDE de desarrollo |
| **ConstraintLayout** | Layout para posicionamiento de elementos |
| **Material Components** | Componentes de UI (botones, temas) |
| **Gradle (KTS)** | Sistema de construcción |

## Estructura del proyecto

```
HolaAndroid/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/holaandroid/
│   │   │   └── MainActivity.kt          ← Lógica principal
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   └── activity_main.xml     ← Diseño de la interfaz
│   │   │   └── values/
│   │   │       ├── strings.xml
│   │   │       ├── colors.xml
│   │   │       └── themes.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```

## Configuración del entorno

- **Android Studio**: Quail 4 | 2026.1.4
- **SDK**: API 34 (Android 14)
- **Min SDK**: API 24 (Android 7.0)
- **Kotlin**: 1.9.22
- **Gradle**: 8.2
- **Emulador**: Pixel 7, API 34

## Cómo ejecutar

1. Clonar este repositorio
2. Abrir el proyecto en Android Studio
3. Esperar la sincronización de Gradle
4. Ejecutar en emulador o dispositivo físico (Run > Run 'app')

## Capturas de pantalla

### Mensaje inicial
La aplicación muestra "¡Hola, Android!" centrado en la pantalla con un botón verde debajo.

### Después de presionar el botón
El mensaje cambia dinámicamente a "¡Botón presionado!" sin recargar la actividad.

## Análisis del código

### MainActivity.kt
- `AppCompatActivity`: Clase base que garantiza compatibilidad con versiones anteriores de Android.
- `onCreate()`: Método del ciclo de vida donde se inicializa la actividad.
- `setContentView()`: Vincula el layout XML con la actividad.
- `findViewById()`: Obtiene referencias a los widgets del layout.
- `setOnClickListener {}`: Lambda de Kotlin que maneja el evento de clic del botón.

### activity_main.xml
- `ConstraintLayout`: Layout eficiente que posiciona elementos mediante restricciones.
- `chainStyle="packed"`: Agrupa los elementos verticalmente en el centro.
- Unidades `sp` para texto (accesibilidad) y `dp` para márgenes (densidad de pantalla).

## Referencias

- Roy, A. (2019). *The android game developer's handbook* (pp. 49-74). Packt Publishing.
- Smyth, N. (2021). *Android Studio 4.2. Development essentials* (pp. 21-29). Java Edition.
- [Android Studio Documentation](https://developer.android.com/studio)
- [Android Jetpack](https://developer.android.com/jetpack)
