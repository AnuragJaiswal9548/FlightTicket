package com.example.flightticket
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val tv1 =findViewById<TextView>(R.id.tv1)
        val tv2 =findViewById<TextView>(R.id.tv2)
        val tv3 =findViewById<TextView>(R.id.tv3)
        val tv4 =findViewById<TextView>(R.id.tv4)
        val tv5 =findViewById<TextView>(R.id.tv5)
        val tv6 =findViewById<TextView>(R.id.tv6)
        val tv7 =findViewById<TextView>(R.id.tv7)
        val bundle =intent.extras
        if(bundle !=null){
            tv1.text ="Name = ${bundle.getString("Name")}"
            tv2.text ="Email = ${bundle.getString("Email")}"
            tv3.text ="Date = ${bundle.getString("Date")}"
            tv4.text ="Gender = ${bundle.getString("Radio")}"
            tv5.text="Start= ${bundle.getString("Start")}"
            tv6.text="Destination= ${bundle.getString("Destination")}"
            tv7.text="Checkbox= ${bundle.getString("Checkbox")}"
        }
    } }