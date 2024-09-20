package com.example.cameraprocessing

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.masterjorge.cameraprocessing.databinding.ActivityMainBinding
import com.masterjorge.cameraprocessing.databinding.ActivityProcessingBinding
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import kotlin.math.max
import kotlin.math.min


class ProcessingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProcessingBinding

    private val HIGHEST_COLOR_VALUE = 255
    private val LOWEST_COLOR_VALUE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProcessingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var imageBitmap = intent.getParcelableExtra<Bitmap>("imageBitmap")!!
        var newBitmap_ = displayImage(imageBitmap)

        //Botões da filtro
        val sobelButton = binding.btSobel
        val grayButton = binding.btCinza
        val normalButton = binding.btNormal
        val sepiaButton = binding.btSepia
        val negativeButton = binding.btNegative
        val brightnessButton = binding.btBrightness
        val contrastButton = binding.button3
        val returnButton = binding.fabReturn
        val saveButton = binding.fabSave

        //Seekbar
        val sbBrightness = binding.sbBrightness
        val sbContrast = binding.sbConstrast

        //O filtro contém uma seekbar?
        var isSeekBar = false

        returnButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        saveButton.setOnClickListener {
            saveImage(newBitmap_, this, "ImageProcessing")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        normalButton.setOnClickListener {
            isSeekBar = false
            newBitmap_ = displayImage(imageBitmap)
        }
        contrastButton.setOnClickListener {
            isSeekBar = true
        }
        brightnessButton.setOnClickListener {
            isSeekBar = true
        }
        negativeButton.setOnClickListener {
            isSeekBar = false
            newBitmap_ = negativeProcessing(imageBitmap)
        }
        grayButton.setOnClickListener {
            isSeekBar = false
            newBitmap_ = grayProcessing(imageBitmap)
        }
        sepiaButton.setOnClickListener {
            isSeekBar = false
            newBitmap_ = sepiaProcessing(imageBitmap)
        }
        sobelButton.setOnClickListener {
            //newBitmap_ = sobelProcessing(imageBitmap)
        }

        sbBrightness.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (isSeekBar) {
                    newBitmap_ = brightnessProcessing(imageBitmap, progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        sbContrast.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (isSeekBar) {
                    newBitmap_ = contrastProcessing(imageBitmap, progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }

    private fun saveImage(bitmap: Bitmap, context: Context, folderName: String) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            val values = contentValues()
            values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/" + folderName)
            values.put(MediaStore.Images.Media.IS_PENDING, true)

            val uri: Uri? =
                context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
            if (uri != null) {
                saveImageToStream(bitmap, context.contentResolver.openOutputStream(uri))
                values.put(MediaStore.Images.Media.IS_PENDING, false)
                context.contentResolver.update(uri, values, null, null)
            }
        } else {
            val directory =
                File(Environment.getExternalStorageDirectory().toString() + " " + folderName)

            if (!directory.exists()) {
                directory.mkdirs()
            }
            val fileName = System.currentTimeMillis().toString() + ".png"
            val file = File(directory, fileName)
            saveImageToStream(bitmap, FileOutputStream(file))

            if (file.absolutePath != null) {
                val values = contentValues()
                values.put(MediaStore.Images.Media.DATA, file.absolutePath)
                // .DATA is deprecated in API 29
                context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
            }
        }
    }

    private fun saveImageToStream(bitmap: Bitmap, outputStream: OutputStream?) {
        if (outputStream != null) {
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
                outputStream.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun contentValues(): ContentValues {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/png")
        values.put(MediaStore.Images.Media.DATE_ADDED, System.currentTimeMillis() / 1000);
        values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
        return values
    }

    private fun displayImage(imageBitmapAux: Bitmap): Bitmap {
        binding.imgViewer.setImageBitmap(imageBitmapAux)
        binding.imgViewer.visibility = View.VISIBLE

        return imageBitmapAux
    }

    private fun contrastProcessing(imageBitmapAux: Bitmap, progress: Int): Bitmap {
        val newBitmap = imageBitmapAux.copy(Bitmap.Config.ARGB_8888, true)

        var imageHeight = newBitmap.height
        var imageWidth = newBitmap.width

        imageWidth -= 1
        imageHeight -= 1

        var maxValue = 0
        var minValue = 255

        // Find the original maximum and minimum intensity values
        for (i in 0..imageWidth) {
            for (j in 0..imageHeight) {
                val oldPixel = imageBitmapAux.getPixel(i, j)
                val gray = (Color.red(oldPixel) + Color.green(oldPixel) + Color.blue(oldPixel)) / 3
                maxValue = max(maxValue, gray)
                minValue = min(minValue, gray)
            }
        }

        for (i in 0..imageWidth) {
            for (j in 0..imageHeight) {
                val oldPixel = imageBitmapAux.getPixel(i, j)

                val oldRed = Color.red(oldPixel)
                val oldGreen = Color.green(oldPixel)
                val oldBlue = Color.blue(oldPixel)
                val oldAlpha = Color.alpha(oldPixel)

                val newIntensity = 1.0f + (progress.toFloat() / 100.0f) // Normalize progress to 0.0 - 1.0 range
                val contrastRatio = (maxValue - minValue) / (maxValue + minValue).toFloat()

                // Apply contrast adjustment based on formula
                val adjustedGray = ((oldRed + oldGreen + oldBlue) / 3.0f - minValue) * contrastRatio * newIntensity + minValue

                val newRed = (adjustedGray * 255).toInt()
                val newGreen = (adjustedGray * 255).toInt()
                val newBlue = (adjustedGray * 255).toInt()

                val newPixel = Color.argb(oldAlpha, newRed, newGreen, newBlue)

                newBitmap.setPixel(i, j, newPixel)
            }
        }

        binding.imgViewer.setImageBitmap(newBitmap)
        binding.imgViewer.visibility = View.VISIBLE

        return newBitmap
    }

    private fun brightnessProcessing(imageBitmapAux: Bitmap, progress: Int): Bitmap {

        val newBitmap = imageBitmapAux.copy(Bitmap.Config.ARGB_8888, true)

        var imageHeight = newBitmap.height
        var imageWidth = newBitmap.width

        imageWidth -= 1
        imageHeight -= 1

        for (i in 0..imageWidth) {
            for (j in 0..imageHeight) {
                val oldPixel = imageBitmapAux.getPixel(i, j)

                val oldRed = Color.red(oldPixel)
                val oldBlue = Color.blue(oldPixel)
                val oldGreen = Color.green(oldPixel)
                val oldAlpha = Color.alpha(oldPixel)

                fun conversion(color: Int, valorAlterado: Float): Int {
                    val scaledValue = color * (1 + valorAlterado)

                    if (scaledValue < 0)
                        return 0
                    else if (scaledValue > 255)
                        return 255

                    return scaledValue.toInt()
                }

                val valorAlterado = ((progress - 50f) / 50f)

                val newRed = conversion(oldRed, valorAlterado)
                val newGreen = conversion(oldGreen, valorAlterado)
                val newBlue = conversion(oldBlue, valorAlterado)

                val newPixel = Color.argb(oldAlpha, newRed, newGreen, newBlue)

                newBitmap.setPixel(i, j, newPixel)
            }
        }
        binding.imgViewer.setImageBitmap(newBitmap)
        binding.imgViewer.visibility = View.VISIBLE

        return newBitmap
    }

    private fun grayProcessing(imageBitmapAux: Bitmap): Bitmap {

        val newBitmap = imageBitmapAux.copy(Bitmap.Config.ARGB_8888, true)

        var imageHeight = newBitmap.height
        var imageWidth = newBitmap.width

        Log.e("Image Size", "Altura: ${imageHeight} | Largura ${imageWidth}")

        imageWidth -= 1
        imageHeight -= 1

        for (i in 0..imageWidth) {
            for (j in 0..imageHeight) {
                val oldPixel = imageBitmapAux.getPixel(i, j)

                val oldRed = Color.red(oldPixel)
                val oldBlue = Color.blue(oldPixel)
                val oldGreen = Color.green(oldPixel)
                val oldAlpha = Color.alpha(oldPixel)

                val intensidade = (oldRed + oldBlue + oldGreen) / 3
                val newRed = intensidade
                val newGreen = intensidade
                val newBlue = intensidade

                val newPixel = Color.argb(oldAlpha, newRed, newGreen, newBlue)

                newBitmap.setPixel(i, j, newPixel)
            }
        }
        binding.imgViewer.setImageBitmap(newBitmap)
        binding.imgViewer.visibility = View.VISIBLE

        return newBitmap

    }

    private fun negativeProcessing(imageBitmapAux: Bitmap): Bitmap {
        val newBitmap = imageBitmapAux.copy(Bitmap.Config.ARGB_8888, true)

        var imageHeight = newBitmap.height
        var imageWidth = newBitmap.width


        Log.e("Image Size", "Altura: ${imageHeight} | Largura ${imageWidth}")

        imageWidth -= 1
        imageHeight -= 1

        for (i in 0..imageWidth) {
            for (j in 0..imageHeight) {
                val oldPixel = imageBitmapAux.getPixel(i, j)

                val oldRed = Color.red(oldPixel)
                val oldBlue = Color.blue(oldPixel)
                val oldGreen = Color.green(oldPixel)
                val oldAlpha = Color.alpha(oldPixel)

                val newRed = HIGHEST_COLOR_VALUE - oldRed
                val newGreen = HIGHEST_COLOR_VALUE - oldGreen
                val newBlue = HIGHEST_COLOR_VALUE - oldBlue

                val newPixel = Color.argb(oldAlpha, newRed, newGreen, newBlue)

                newBitmap.setPixel(i, j, newPixel)
            }
        }
        binding.imgViewer.setImageBitmap(newBitmap)
        binding.imgViewer.visibility = View.VISIBLE

        return newBitmap
    }

    private fun sepiaProcessing(imageBitmapAux: Bitmap): Bitmap {
        val newBitmap = imageBitmapAux.copy(Bitmap.Config.ARGB_8888, true)

        var imageHeight = newBitmap.height
        var imageWidth = newBitmap.width

        Log.e("Image Size", "Altura: ${imageHeight} | Largura ${imageWidth}")

        imageWidth -= 1
        imageHeight -= 1

        for (i in 0..imageWidth) {
            for (j in 0..imageHeight) {
                val oldPixel = imageBitmapAux.getPixel(i, j)

                val oldRed = Color.red(oldPixel)
                val oldBlue = Color.blue(oldPixel)
                val oldGreen = Color.green(oldPixel)
                val oldAlpha = Color.alpha(oldPixel)

                var newRed = (0.393 * oldRed + 0.769 * oldGreen + 0.189 * oldBlue).toInt()
                var newGreen = (0.349 * oldRed + 0.686 * oldGreen + 0.168 * oldBlue).toInt()
                var newBlue = (0.272 * oldRed + 0.534 * oldGreen + 0.131 * oldBlue).toInt()


                if (newRed > HIGHEST_COLOR_VALUE)
                    newRed = HIGHEST_COLOR_VALUE

                if (newGreen > HIGHEST_COLOR_VALUE)
                    newGreen = HIGHEST_COLOR_VALUE

                if (newBlue > HIGHEST_COLOR_VALUE)
                    newBlue = HIGHEST_COLOR_VALUE

                val newPixel = Color.argb(oldAlpha, newRed, newGreen, newBlue)

                newBitmap.setPixel(i, j, newPixel)
            }
        }
        binding.imgViewer.setImageBitmap(newBitmap)
        binding.imgViewer.visibility = View.VISIBLE

        return newBitmap
    }

    //private fun sobelProcessing(imageBitmapAux: Bitmap): Bitmap {

    //}
}


//This is the order that can help u understand
//https://harshitabambure.medium.com/how-to-capture-image-using-camera-in-android-kotlin-329bb8410212
//https://mujeebkhan1831.medium.com/how-to-pass-object-between-activities-in-android-kotlin-b7bfbfa4a574
//https://medium.com/@theshivamlko/image-filters-algorithm-721c4189cc54
//https://medium.com/@chathuragunasekera/image-resampling-algorithms-for-pixel-manipulation-bee65dda1488
//https://github.com/theshivamlko/ImageFilterAlogrithm/blob/master/ImageFIlters/app/src/main/java/com/navoki/imagefilters/ImageFilters.java
//https://dyclassroom.com/image-processing-project/how-to-convert-a-color-image-into-sepia-image
//https://hackernoon.com/image-processing-algorithms-adjusting-contrast-and-image-brightness-0y4y318a
//https://docs.rainmeter.net/tips/colormatrix-guide/