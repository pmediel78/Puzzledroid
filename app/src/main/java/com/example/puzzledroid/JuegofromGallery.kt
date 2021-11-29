package com.example.puzzledroid

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_juego_from_photo.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.draggableCard1
import kotlinx.android.synthetic.main.activity_main2.draggableCard2
import kotlinx.android.synthetic.main.activity_main2.draggableCard3
import kotlinx.android.synthetic.main.activity_main2.draggableCard4
import kotlinx.android.synthetic.main.activity_main2.draggableCard5
import kotlinx.android.synthetic.main.activity_main2.draggableCard6
import kotlinx.android.synthetic.main.activity_main2.draggableCard7
import kotlinx.android.synthetic.main.activity_main2.draggableCard8
import kotlinx.android.synthetic.main.activity_main2.draggableCard9
import kotlinx.android.synthetic.main.activity_main2.parentCoordinatorLayout
import android.graphics.BitmapFactory
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import android.provider.MediaStore





class JuegofromGallery : AppCompatActivity() {
    private val cameraRequest = 1888

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juegofrom_gallery)


        cargarGaleria()

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
                        val intent = Intent(this@JuegofromGallery, MainActivity::class.java);

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

        when {

            requestCode == 1 && resultCode == Activity.RESULT_OK -> {

                val url = data!!.data
                println(url.toString())
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, url)
                println(bitmap)
                if (bitmap != null) {
                    SetCardswithImages(bitmap)
                }
            }
        }
    }

    private fun cargarGaleria() {
        println("galeria")
        val intent = Intent(Intent.ACTION_PICK)
        println("galeria2")
        intent.type = "image/*"
        println("galeria3")
        startActivityForResult(intent, 1)
        println("galeria4")

    }






}