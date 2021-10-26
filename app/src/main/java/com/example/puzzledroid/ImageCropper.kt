package com.example.puzzledroid

import android.graphics.Bitmap


 class ImageCropper {

  fun splitBitmap(bitmap: Bitmap, xCount: Int, yCount: Int,piecesNumber:Int): ArrayList<Bitmap>? {
   val pieces: ArrayList<Bitmap> = ArrayList(piecesNumber)

   val image = CropImageToSquare(bitmap,3)[0]
   val width: Int
   val height: Int
   width = image.width / xCount
   height = image.height / yCount
   for (x in 0 until xCount) {
    for (y in 0 until yCount) {
     pieces.add(Bitmap.createBitmap(image, x * width, y * height, width, height))
    }
   }
   return pieces
  }

  fun CropImageToSquare(bitmap: Bitmap,piecesNumber:Int): ArrayList<Bitmap> {

   val pieces: ArrayList<Bitmap> = ArrayList(piecesNumber)
   val width: Int
   val height: Int
   width = bitmap.width
   height = bitmap.height

   //Crop horizontal image to center
   if(width > height)
   {
    val x = (width - height) /2

    pieces.add( Bitmap.createBitmap(bitmap, x ,0, height, height))

   }
   //Crop Veryical image to center
   else if(height > width)
   {
    val y = (height - width) /2
    pieces.add( Bitmap.createBitmap(bitmap, 0 ,y, width, width))
   }
   //Same Height and width, return the same image
   else{
    pieces.add(bitmap)
   }
   return pieces
  }
}