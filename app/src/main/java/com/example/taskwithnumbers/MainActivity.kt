package com.example.taskwithnumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.function.Function
import java.util.stream.Collectors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numbers = arrayOf(2, 2, 4, 10, 6, 4, 6, 8, 10, 7, 2, 9, 2, 8, 9, 9, 9, 10)
        count1(numbers)
        count2(numbers)
    }

    //First way
    private fun count1(numbers: Array<Int>) {
        val newNumbers1 = HashSet<Int>()
        for (i in numbers.indices) {
            val counter = numbers.count { it == numbers[i] }
            if (counter%2 != 0) {
                newNumbers1.add(numbers[i])
            }
        }
        Log.i("result1", newNumbers1.toString())
    }

    //Second way
    private fun count2(numbers: Array<Int>) {
        var counter: Int = 0
        val newNumbers = hashSetOf<Int>()
        for (i in numbers.indices) {
            for (j in numbers.indices) {
                if (numbers[i] == numbers[j]) {
                    counter++
                }
                if (j == numbers.size - 1) {
                    counter = if (counter % 2 != 0) {
                        newNumbers.add(numbers[i])
                        0
                    } else {
                        0
                    }
                }
            }
        }
        val newNumbers2 = newNumbers.distinct()
        Log.i("result2", newNumbers2.toString())
    }
    
}