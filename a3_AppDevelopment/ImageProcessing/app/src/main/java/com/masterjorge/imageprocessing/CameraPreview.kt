package com.masterjorge.imageprocessing

import android.content.Context
import android.content.res.Configuration
import android.hardware.Camera
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.io.IOException


//Classe responsável por exibir os dados da imagem em tempo real, considerando que ainda não...
//capturamos os valores


//SurfaceView: classe pai
class CameraPreview(context: Context, val camera: Camera) : SurfaceView(context), SurfaceHolder.Callback {


    private val mHolder: SurfaceHolder = holder.apply {
        addCallback(this@CameraPreview)
        
        setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        val params: Camera.Parameters = camera.parameters

        //Alterar a orientação da câmera

        if(this.resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE){
            params.set("orientation", "portrait")
            camera.setDisplayOrientation(90)
            params.setRotation(90)
        } else {
            params.set("orientation", "landscape")
            camera.setDisplayOrientation(0)
            params.setRotation(0)
        }

        camera.parameters = params

        try {
            camera.setPreviewDisplay(holder)
            camera.startPreview()
        }catch (e: IOException){
            e.printStackTrace()
        }

    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        TODO("Not yet implemented")
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        TODO("Not yet implemented")
    }
}