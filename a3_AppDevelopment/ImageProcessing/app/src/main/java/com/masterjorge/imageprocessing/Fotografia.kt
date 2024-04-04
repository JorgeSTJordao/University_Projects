package com.masterjorge.imageprocessing

import android.hardware.Camera
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.masterjorge.imageprocessing.databinding.ActivityFotografiaBinding

class Fotografia : AppCompatActivity() {

    lateinit var camera: Camera
    lateinit var frameLayout: FrameLayout
    lateinit var cameraPreview: CameraPreview

    //private var mPreview: CameraPreview? = null

    lateinit var binding: ActivityFotografiaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFotografiaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        frameLayout = binding.flFrame

        //Abrir um processo que executa a câmera
        camera = Camera.open()

        //Mostra a câmera (Inicia a classe "CameraPreview")
        cameraPreview = CameraPreview(this, camera)
        frameLayout.addView(cameraPreview)

    }
}
