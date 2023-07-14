package com.example.flightticket

import android.app.DatePickerDialog
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image1=findViewById<ImageView>(R.id.image1)
        val ed1 =findViewById<EditText>(R.id.ed1)
        val ed2 =findViewById<EditText>(R.id.ed2)
        val ed5 =findViewById<EditText>(R.id.ed2)
        ed5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(p0).matches())
                    ed5.setError("Invalid Email Add")
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })

        var c = Calendar.getInstance()
        val ed3 =findViewById<EditText>(R.id.ed3)
        ed3.setOnClickListener {

            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                val date= ed3.setText("$i3/${i2 + 1}/$i")
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show()

        }

        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val city2 = arrayOf("Delhi","Ajmer","Bareilly","Rajkot","Lucknow")
        val arrayAdapter2 =ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,city2)
        spinner1.adapter =arrayAdapter2
        spinner1.onItemSelectedListener =object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                city2[p2]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        val spinner2 =findViewById<Spinner>(R.id.spinner2)
        val city1 = arrayOf("Ajmer","DelhiA","Bareilly","Rajkot","Lucknow")
        val arrayAdapter =ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,city1)
        spinner2.adapter =arrayAdapter
        spinner2.onItemSelectedListener =object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            city1[p2]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        val rdGroup = findViewById<RadioGroup>(R.id.radioGroup)
        //SubmitButton
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            val bundle =Bundle()
            val selectbtn: Int = rdGroup.checkedRadioButtonId
            val b1 = findViewById<RadioButton>(selectbtn)
            val str ="${b1.text}"

            bundle.putString("Name",ed1.text.toString())
            bundle.putString("Email",ed2.text.toString())
            bundle.putString("Date",ed3.text.toString())
            bundle.putString("Radio",str.toString())
            bundle.putString("Start","Ajmer")
            bundle.putString("Destination","Bareilly")
            bundle.putString("Checkbox","Policy is Accepted")

            val intent =Intent(this,MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}