package com.example.miushop.ui

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.example.miushop.R

/**
 * Fragmento de detalle de mascota con funcionalidades multimedia.
 *
 * Integra tres tipos de recursos multimedia:
 * - Imagen: se carga directamente con setImageResource()
 * - Video: se reproduce con VideoView + MediaController
 * - Audio: se maneja con MediaPlayer para descripciones de cuidado
 *
 * Se libera el MediaPlayer en onDestroyView() para evitar fugas de memoria
 * (memory leaks), siguiendo las buenas prácticas de Boyer (2018).
 */
class PetDetailFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false

    companion object {
        /**
         * Factory method para crear el fragmento con los datos de la mascota.
         * Usa Bundle para pasar argumentos de forma segura entre fragmentos.
         */
        fun newInstance(pet: com.example.miushop.model.Pet): PetDetailFragment {
            val fragment = PetDetailFragment()
            val args = Bundle().apply {
                putInt("petId", pet.id)
                putString("petName", pet.name)
                putString("petBreed", pet.breed)
                putString("petAge", pet.age)
                putString("petDescription", pet.description)
                putInt("petImage", pet.imageResId)
                pet.videoResId?.let { putInt("petVideo", it) }
                pet.audioResId?.let { putInt("petAudio", it) }
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pet_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener referencias a las vistas
        val imgPet: ImageView = view.findViewById(R.id.imgPetDetail)
        val txtName: TextView = view.findViewById(R.id.txtPetDetailName)
        val txtBreed: TextView = view.findViewById(R.id.txtPetDetailBreed)
        val txtAge: TextView = view.findViewById(R.id.txtPetDetailAge)
        val txtDescription: TextView = view.findViewById(R.id.txtPetDetailDescription)
        val videoView: VideoView = view.findViewById(R.id.videoViewPet)
        val btnPlayAudio: Button = view.findViewById(R.id.btnPlayAudio)

        // Cargar datos de la mascota desde los argumentos
        arguments?.let { args ->
            imgPet.setImageResource(args.getInt("petImage"))
            txtName.text = args.getString("petName", "")
            txtBreed.text = args.getString("petBreed", "")
            txtAge.text = args.getString("petAge", "")
            txtDescription.text = args.getString("petDescription", "")

            // === CONFIGURACIÓN DE VIDEO ===
            // Se usa VideoView con MediaController para reproducir videos locales
            // desde la carpeta res/raw. El MediaController agrega controles
            // de play/pause/seek automáticamente.
            if (args.containsKey("petVideo")) {
                val videoUri = Uri.parse(
                    "android.resource://${requireContext().packageName}/${args.getInt("petVideo")}"
                )
                videoView.setVideoURI(videoUri)

                // MediaController proporciona controles de reproducción estándar
                val mediaController = MediaController(requireContext())
                mediaController.setAnchorView(videoView)
                videoView.setMediaController(mediaController)

                videoView.visibility = View.VISIBLE
            } else {
                videoView.visibility = View.GONE
            }

            // === CONFIGURACIÓN DE AUDIO ===
            // Se usa MediaPlayer para reproducir descripciones de audio
            // sobre el cuidado de cada mascota. Se implementa toggle play/pause
            // y se libera el recurso al destruir la vista.
            if (args.containsKey("petAudio")) {
                btnPlayAudio.visibility = View.VISIBLE

                btnPlayAudio.setOnClickListener {
                    if (isPlaying) {
                        // Pausar reproducción
                        mediaPlayer?.pause()
                        btnPlayAudio.text = "▶ Escuchar cuidados"
                        isPlaying = false
                    } else {
                        if (mediaPlayer == null) {
                            // Crear nueva instancia de MediaPlayer con el recurso de audio
                            mediaPlayer = MediaPlayer.create(
                                requireContext(),
                                args.getInt("petAudio")
                            )
                            // Listener para cuando termina la reproducción
                            mediaPlayer?.setOnCompletionListener {
                                btnPlayAudio.text = "▶ Escuchar cuidados"
                                isPlaying = false
                            }
                        }
                        mediaPlayer?.start()
                        btnPlayAudio.text = "⏸ Pausar audio"
                        isPlaying = true
                    }
                }
            } else {
                btnPlayAudio.visibility = View.GONE
            }
        }
    }

    /**
     * Liberar MediaPlayer al destruir la vista para evitar fugas de memoria.
     * Esto es crítico en Android: si no se libera, el recurso de audio
     * queda abierto consumiendo memoria y posiblemente el hilo de audio.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release()
        mediaPlayer = null
        isPlaying = false
    }
}
