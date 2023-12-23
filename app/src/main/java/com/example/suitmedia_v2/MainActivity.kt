package com.example.suitmedia_v2

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.suitmedia_v2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)

        binding.check.setOnClickListener {
            if (binding.palindrome.text.isNotEmpty()){
                if ( checkPalindrome(binding.palindrome.text.toString())){
                    builder
                        .setMessage("isPalindrome")
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                }else{
                    builder
                        .setMessage("notPalindrome")
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                }
            }else {
                Toast.makeText( this, "Silahkan isi terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }

        binding.next.setOnClickListener {
            if (binding.nama.text.isNotEmpty()){
                val message = binding.nama.text.toString()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("MESSAGE", message)
                startActivity(intent)
            }
        }
    }

    private fun checkPalindrome(cek:String):Boolean{
        val cleanedSentence = cek.replace("\\s+".toRegex(), "").toLowerCase()
        return cleanedSentence == cleanedSentence.reversed()
    }
}