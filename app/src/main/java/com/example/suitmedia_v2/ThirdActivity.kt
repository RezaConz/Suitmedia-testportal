package com.example.suitmedia_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.suitmedia_v2.databinding.ActivityThirdBinding
import com.example.suitmedia_v2.network.APIService
import com.example.suitmedia_v2.network.models.BaseClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val recycler = binding.recyclerView
//        Build Retrofit service
        val retrofit = Retrofit.Builder().baseUrl(APIService.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        val service = retrofit.create(APIService::class.java)

//end retrofit


//        Call Retrofit methods now in asynchronous mode
//        Alternatively you can make functions in APIService suspendable and launch those functions in coroutinescope
//
        service.getAllUsers().also { it ->
            it.enqueue(object : Callback<BaseClass> {
                override fun onResponse(call: Call<BaseClass>, response: Response<BaseClass>) {
                    response.body()?.data.also {
//                        We know have the data just set the adapter for recyclerview
                        recycler.adapter = ItemAdapter(this@ThirdActivity, it!!)
                    }
                }

                override fun onFailure(call: Call<BaseClass>, t: Throwable) {
                    Toast.makeText(this@ThirdActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
        }


//


    }
}