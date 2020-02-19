package com.example.hw2_pizzaorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var sizePrice = 0.00
    var topping1Num = 0.00
    var topping2Num = 0.00
    var topping3Num = 0.00
    var topping4Num = 0.00
    var deliveryPrice = 0.00
    var totalPriceNum = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pizzaList = listOf("BBQ Chicken", "Hawaiian", "Margheritta", "Pepperoni")

        // Create an adapter with 3 parameters: activity (this), layout, list
        val myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pizzaList)

        // set the adapter to listview
        pizza_list.adapter = myAdapter


        // Registering setOnItemClickListener that listens item click events in the listview
        pizza_list.setOnItemClickListener { list, item, position, id ->

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
        calPrice()
    }

    fun onTopping1Clicked(view: View){
        if(topping1.isChecked){
            topping1Num = 1.69
        }else{
            topping1Num = 0.00
        }
        calPrice()
    }

    fun onTopping2Clicked(view: View){
        if(topping2.isChecked){
            topping2Num = 1.69
        }
        else{
            topping2Num = 0.00
        }
        calPrice()
    }

    fun onTopping3Clicked(view: View){
        if(topping3.isChecked){
            topping3Num = 1.69
        }
        else{
            topping3Num = 0.00
        }
        calPrice()
    }

    fun onTopping4Clicked(view: View){
        if(topping4.isChecked){
            topping4Num = 1.69
        }
        else{
            topping4Num = 0.00
        }
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
        totalPriceNum = sizePrice + topping1Num + topping2Num + topping3Num + topping4Num + deliveryPrice
        totalPrice.text = "Total Price: $totalPriceNum"
    }
}
