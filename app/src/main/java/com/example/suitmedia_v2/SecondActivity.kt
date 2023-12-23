package com.example.suitmedia_v2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suitmedia_v2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)

        var received:String = ""
        val extras = intent.extras
        if (extras != null) {
            if (extras.containsKey("firstname")) {
                received = intent.getStringExtra("firstname").toString()+" "+intent.getStringExtra("lastname").toString()
            }else{
                received = intent.getStringExtra("MESSAGE").toString()
                val intent = intent
            }
        }
        binding.nama.text = received



        setContentView(binding.root)


        binding.choose.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
        binding.back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}