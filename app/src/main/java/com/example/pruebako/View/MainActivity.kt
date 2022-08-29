package com.example.pruebako.View

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pruebako.Controller.Apiservice
import com.example.pruebako.Model.MyInterceptor
import com.example.pruebako.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        binding.btnIngresar.setOnClickListener {

            if (binding.editTexmail.text.toString().trim() == "" && binding.editTextPass.text.toString().trim() =="") {
                Toast.makeText(this@MainActivity, "Por favor llene los campos", Toast.LENGTH_SHORT).show()
            } else {

                displayName()
            }
        }
    }
    private fun displayName() {

        binding.editTexmail.text = binding.editTexmail.text
        binding.editTextPass.text = binding.editTextPass.text
        login()
    }

    private fun getretrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://testandroid.macropay.com.mx")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun login() {

       // storeAPI =StoreAPI.getInstance(this)
        val mail = binding.editTexmail.text.toString().trim()
        val pass = binding.editTextPass.text.toString().trim()

     //   val jsonObject = JSONObject()
        /*    val retrofit = Retrofit.Builder()
                .baseUrl(Const.URL_BASE)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()*/

      /*  val jsonObject = JSONObject()
        jsonObject.put("mail", mail)
        jsonObject.put("password", pass)
*/
        val fields: HashMap<String?, RequestBody?> = HashMap()
        fields["email"] =mail.toRequestBody("text/plain".toMediaTypeOrNull())
        fields["password"] =pass.toRequestBody("text/plain".toMediaTypeOrNull())

     //   val jsonObjectString = jsonObject.toString()

      //  val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())
        CoroutineScope(Dispatchers.IO).launch{

            val response=getretrofit().create(Apiservice::class.java).uploadEmployeeData(fields)
              val pupies = response.body()

                if (response.isSuccessful){
                   val mitoken= pupies?.token
                    Log.d("JSON_PRINT","vhjvjh"+mitoken)
                    var paso_params = Intent(this@MainActivity, Barcode::class.java)
                        paso_params.putExtra("mitoken",mitoken)
                         startActivity(paso_params)

                }else
                {
                    Log.d("ERROR_RETROFIT",response.code().toString())
                }
        }

    }



}
