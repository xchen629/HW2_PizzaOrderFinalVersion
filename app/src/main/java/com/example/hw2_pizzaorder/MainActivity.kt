package com.example.hw2_pizzaorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var sizePrice = 0.00
    var toppingNum = 0.00
    var deliveryPrice = 0.00
    var totalPriceNum = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.pay)
        button.setOnClickListener{
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
        val pizzaList = listOf("BBQ Chicken", "Hawaiian", "Margheritta", "Pepperoni")

        // Create an adapter with 3 parameters: activity (this), layout, list
        val myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pizzaList)

        // set the adapter to listview
        pizza_list.adapter = myAdapter


        // Registering setOnItemClickListener that listens item click events in the listview
        pizza_list.setOnItemClickListener { list, item, position, id ->

            val selectedItem = list.getItemAtPosition(position).toString()

            chooseHeader.text = "Choose your pizza: $selectedItem"
            // Based on the index of position selected, set the corresponding image
            val imageId = when(position){
                0 -> R.drawable.bbq_chicken
                1 -> R.drawable.hawaiian
                2 -> R.drawable.margheritta
                else -> R.drawable.pepperoni
            }


            image_pizza.setImageResource(imageId)
        }
    }

    fun onSizeClicked(view: View){
        if(radioButton1.isChecked){
            sizePrice = 9.99
        }
        else if(radioButton2.isChecked){
            sizePrice = 13.99
        }
        else if(radioButton3.isChecked){
            sizePrice = 15.99
        }
        else{
            sizePrice = 0.00
        }
        calPrice()
    }

    fun onToppingClicked(view: View){
        var count = 0

        if(topping1.isChecked){
            count++
        }
        if(topping2.isChecked){
            count++
        }
        if(topping3.isChecked){
            count++
        }
        if(topping4.isChecked){
            count++
        }
        toppingNum = 1.69 * count
        calPrice()
    }

    fun onSwitchClicked(view: View){
        if (switch1.isChecked){
            switch1.text = ("Yes, $2.00")
            deliveryPrice = 2.00
        }
        else{
            switch1.text = ("No, $0.00")
            deliveryPrice = 0.00
        }
        calPrice()
    }

    private fun calPrice(){
        totalPriceNum = sizePrice + toppingNum + deliveryPrice
        val totalPriceNumFormatted:Double = String.format("%.2f", totalPriceNum).toDouble()
        totalPrice.text = "Total Price: $totalPriceNumFormatted"
    }
}
