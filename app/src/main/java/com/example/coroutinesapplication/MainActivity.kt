package com.example.coroutinesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.coroutinesapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
     var counter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.apply {

            counterbtn.setOnClickListener(){

                textView2.text = counter++.toString()
            }

            button2.setOnClickListener{
                CoroutineScope(Dispatchers.IO).launch {
                    executeAnotherTask()
                }
            }
        }
    }
    private fun executeAnotherTask() {
        for (i in 1..1000000000L){
        }
    }
}