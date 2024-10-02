package com.example.kalkulatorbmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.kalkulatorbmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnHitung.setOnClickListener {

                if (binding.etHeight.text.isNotEmpty() && binding.etWeight.text.isNotEmpty()) {
                    val Nama = findViewById<View>(R.id.etnama) as EditText
                    val nama = findViewById<View>(R.id.nama) as TextView
                    val Usia = findViewById<View>(R.id.etusia) as EditText
                    val usia = findViewById<View>(R.id.usia) as TextView
                    val height = (binding.etHeight.text.toString()).toInt()
                    val weight = (binding.etWeight.text.toString()).toInt()
                    val BMI = calculateBMI(height, weight)

                    binding.bmi.text = BMI.toString()
                    nama.text = Nama.text.toString()
                    usia.text = Usia.text.toString()
                    binding.bmi.visibility = View.VISIBLE

                    if (BMI < 18.5) {
                        binding.statuswho.text = "Kurus"
                    } else if (BMI > 18.5 && BMI < 24.9) {
                        binding.statuswho.text = "Normal"
                    } else if (BMI > 25.0 && BMI < 29.9) {
                        binding.statuswho.text = "Gendut"
                    } else if (BMI > 30.0 && BMI < 40.0) {
                        binding.statuswho.text = "Obesitas"
                    } else if (BMI > 40.1 && BMI < 50.0) {
                        binding.statuswho.text = "Obesitas morbid"
                    } else if (BMI > 50.1) {
                        binding.statuswho.text = "Obesitas Parah"
                    }

                    if (BMI < 18.5) {
                        binding.statusasia.text = "Kurus"
                    } else if (BMI >= 18.5 && BMI <= 22.9) {
                        binding.statusasia.text = "Normal"
                    } else if (BMI >= 23.0 && BMI <= 24.9) {
                        binding.statusasia.text = "Gendut"
                    } else if (BMI >= 25.0 && BMI <= 29.9) {
                        binding.statusasia.text = "Menuju Obesitas"
                    } else if (BMI >= 30.0 && BMI <= 40.0) {
                        binding.statusasia.text = "Obesitas"
                    } else if (BMI >= 40.1 && BMI <= 50.0) {
                        binding.statusasia.text = "Obesitas morbid"
                    } else if (BMI > 50) {
                        binding.statusasia.text = "Obesitas Parah"
                    }

                    binding.nama.visibility = View.VISIBLE
                    binding.usia.visibility = View.VISIBLE
                    binding.bmiTV.visibility = View.VISIBLE
                    binding.bmi.visibility = View.VISIBLE
                    binding.who.visibility = View.VISIBLE
                    binding.statuswho.visibility = View.VISIBLE
                    binding.asian.visibility = View.VISIBLE
                    binding.statusasia.visibility = View.VISIBLE
                    binding.ReCalculate.visibility = View.VISIBLE
                    binding.btnHitung.visibility = View.GONE
                } else {
                    Toast.makeText(
                        this, "please enter the valid height and weight",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            binding.ReCalculate.setOnClickListener {
                ResetEverything()
            }
        }

        private fun ResetEverything() {
            binding.btnHitung.visibility = View.VISIBLE
            binding.ReCalculate.visibility = View.GONE
            binding.etnama.text.clear()
            binding.etusia.text.clear()
            binding.etHeight.text.clear()
            binding.etWeight.text.clear()
            binding.nama.text = " "
            binding.usia.text = " "
            binding.statuswho.text = " "
            binding.statusasia.text = " "
            binding.who.visibility = View.GONE
            binding.asian.visibility = View.GONE
            binding.bmi.text = " "
            binding.bmiTV.visibility = View.GONE
        }

        private fun calculateBMI(height: Int, weight: Int): Float {

            val Height_in_metre = height.toFloat() / 100
            val BMI = weight.toFloat() / (Height_in_metre * Height_in_metre)

            return BMI
        }
    }



