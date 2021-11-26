package com.example.puzzledroid

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main2.parentCoordinatorLayout

import android.graphics.BitmapFactory
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_juego_from_photo.*
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlin.text.toInt as toInt1



class JuegoFromPhoto : AppCompatActivity() {

    private val cameraRequest = 1888

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_from_photo)

        if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), cameraRequest)


            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, cameraRequest)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        parentCoordinatorLayout.addDraggableChild(draggableCard1)
        parentCoordinatorLayout.addDraggableChild(draggableCard2)
        parentCoordinatorLayout.addDraggableChild(draggableCard3)
        parentCoordinatorLayout.addDraggableChild(draggableCard4)
        parentCoordinatorLayout.addDraggableChild(draggableCard5)
        parentCoordinatorLayout.addDraggableChild(draggableCard6)
        parentCoordinatorLayout.addDraggableChild(draggableCard7)
        parentCoordinatorLayout.addDraggableChild(draggableCard8)
        parentCoordinatorLayout.addDraggableChild(draggableCard9)



        var Counter = 0
        val Contador: TextView = findViewById(R.id.Counter)
        Contador.text = Counter.toString()
        if (Counter != null) {
            parentCoordinatorLayout.setViewDragListener(object :
                DraggableCoordinatorLayout.ViewDragListener {
                override fun onViewCaptured(view: View, i: Int) {
                }

                override fun onViewReleased(view: View, v: Float, v1: Float) {
                    val helper = Helper()
                    Counter += 1
                    val win = helper.resolve(view, parentCoordinatorLayout, resources, Counter)
                    val Contador: TextView = findViewById(R.id.Counter)
                    Contador.text = Counter.toString()
                    if (win) {
                        val intent = Intent(this@JuegoFromPhoto, MainActivity::class.java);
                       
                        startActivity(intent);
                        finish();
                    }
                }
            })
        }

    }

    private fun SetCardswithImages(photo : Bitmap) {
        val bm = photo

        val imageCropper = ImageCropper()
        val imagecropped = imageCropper.splitBitmap(bm, 3, 3, 9)



        image1.setImageBitmap(imagecropped?.get(0))
        image1.elevation= 1F
        fondo1.elevation =0F
        image2.setImageBitmap(imagecropped?.get(3))
        image2.elevation= 1F
        fondo2.elevation =0F
        image3.setImageBitmap(imagecropped?.get(6))
        image3.elevation= 1F
        fondo3.elevation =0F
        image4.setImageBitmap(imagecropped?.get(1))
        image4.elevation= 1F
        fondo4.elevation =0F
        image5.setImageBitmap(imagecropped?.get(4))
        image5.elevation= 1F
        fondo5.elevation =0F
        image6.setImageBitmap(imagecropped?.get(7))
        image6.elevation= 1F
        fondo6.elevation =0F
        image7.setImageBitmap(imagecropped?.get(2))
        image7.elevation= 1F
        fondo7.elevation =0F
        image8.setImageBitmap(imagecropped?.get(5))
        image8.elevation= 1F
        fondo8.elevation =0F
        image9.setImageBitmap(imagecropped?.get(8))
        image9.elevation= 1F
        fondo9.elevation =0F





    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == cameraRequest) {
             val photo = data?.extras?.get("data") as Bitmap

            SetCardswithImages(photo)

        }
    }




}
