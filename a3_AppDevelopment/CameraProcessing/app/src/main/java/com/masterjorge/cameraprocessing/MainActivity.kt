package com.example.cameraprocessing

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.masterjorge.cameraprocessing.databinding.ActivityMainBinding

//https://harshitabambure.medium.com/how-to-capture-image-using-camera-in-android-kotlin-329bb8410212
//https://mujeebkhan1831.medium.com/how-to-pass-object-between-activities-in-android-kotlin-b7bfbfa4a574
//https://www.youtube.com/watch?v=tFoPbT91NvM&list=PLam6bY5NszYOGk7-8S9F3K4YpjLt2nKv8&index=2
//https://medium.com/@dugguRK/capture-photo-browse-gallery-android-8b966f3b58b7
//https://developer.android.com/codelabs/camerax-getting-started#1

class MainActivity : AppCompatActivity() {
    private val REQUEST_IMAGE_CAPTURE = 1
    private val REQUEST_CAMERA_PERMISSION = 2
    private val REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION = 3

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCamera.setOnClickListener {
            if (allPermissionsGranted()){
                dispatchTakePictureIntent()
            } else {
                requestPermissions()
            }
        }
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "Camera não encontrada", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap

            val intent = Intent(this, ProcessingActivity::class.java)
            intent.putExtra("imageBitmap", imageBitmap)
            startActivity(intent)
        }
    }

    private fun requestPermissions(){
        activityResultLauncher.launch(REQUIRED_PERMISSIONS)
    }

    private val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions())
    {
        permissions ->

        var permissionGranted = true
        permissions.entries.forEach{
            if (it.key in REQUIRED_PERMISSIONS && it.value == false)
                permissionGranted = false
        }
        if (!permissionGranted) {
            Toast.makeText(baseContext, "Permissão negada", Toast.LENGTH_LONG).show()
        } else {
            dispatchTakePictureIntent()
        }
    }


    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) ==
                PackageManager.PERMISSION_GRANTED
    }

    companion object {
        private val REQUIRED_PERMISSIONS =
            mutableListOf (
                Manifest.permission.CAMERA,
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }
}