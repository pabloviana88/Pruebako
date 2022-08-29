package com.example.pruebako.View

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.pruebako.R
import com.example.pruebako.databinding.ActivityBarcodeBinding
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

class Barcode : AppCompatActivity() {

    private lateinit var binding: ActivityBarcodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivityBarcodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtViebar1.text=binding.txtViebar1.text
        setTitle("Buenas noches Pablo")
        val response=intent.extras
        val mitoken= response?.get("mitoken")

        jsbarcode(mitoken.toString())
    }
    fun jsbarcode(mitoken: String?) {
        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap: Bitmap = barcodeEncoder.encodeBitmap(mitoken,BarcodeFormat.PDF_417, 10, 10)
            val imageViewQrCode = findViewById<View>(R.id.imageViewbar) as ImageView
            imageViewQrCode.setImageBitmap(bitmap)
            binding.txtViebar1.setText("6096 7072 6247 7256")
        } catch (e: Exception) {
        }
    }
}