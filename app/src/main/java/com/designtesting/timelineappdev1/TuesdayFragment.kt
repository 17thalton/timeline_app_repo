package com.designtesting.timelineappdev1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TuesdayFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //get sharedPreferences
        val sharedPreferences: SharedPreferences = context!!.getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        val set = sharedPreferences.getStringSet("tt_tue", setOf())!!.sorted()

        when (set.count()){
            4 -> {
                val myInflatedView: View =
                    inflater.inflate(R.layout.fragment_tuesday_4, container, false)
                val period1text: TextView = myInflatedView.findViewById(R.id.tue_4_period_1)
                period1text.text = set.elementAt(0).removePrefix("1")

                val period2text: TextView = myInflatedView.findViewById(R.id.tue_4_period_2)
                period2text.text = set.elementAt(1).removePrefix("2")

                val period3text: TextView = myInflatedView.findViewById(R.id.tue_4_period_3)
                period3text.text = set.elementAt(2).removePrefix("3")

                val period4text: TextView = myInflatedView.findViewById(R.id.tue_4_period_4)
                period4text.text = set.elementAt(3).removePrefix("4")

                // Inflate the layout for this fragment
                return myInflatedView
            }
            5 -> {
                val myInflatedView: View =
                    inflater.inflate(R.layout.fragment_tuesday_5, container, false)
                val period1text: TextView = myInflatedView.findViewById(R.id.tue_5_period_1)
                period1text.text = set.elementAt(0).removePrefix("1")

                val period2text: TextView = myInflatedView.findViewById(R.id.tue_5_period_2)
                period2text.text = set.elementAt(1).removePrefix("2")

                val period3text: TextView = myInflatedView.findViewById(R.id.tue_5_period_3)
                period3text.text = set.elementAt(2).removePrefix("3")

                val period4text: TextView = myInflatedView.findViewById(R.id.tue_5_period_4)
                period4text.text = set.elementAt(3).removePrefix("4")

                val period5text: TextView = myInflatedView.findViewById(R.id.tue_5_period_5)
                period5text.text = set.elementAt(4).removePrefix("5")

                return myInflatedView
            }
            6 -> {
                val inflatedView: View =
                    inflater.inflate(R.layout.fragment_tuesday_6, container, false)
                val period1text: TextView = inflatedView.findViewById(R.id.tue_6_period_1)
                period1text.text = set.elementAt(0).removePrefix("1")

                val period2text: TextView = inflatedView.findViewById(R.id.tue_6_period_2)
                period2text.text = set.elementAt(1).removePrefix("2")

                val period3text: TextView = inflatedView.findViewById(R.id.tue_6_period_3)
                period3text.text = set.elementAt(2).removePrefix("3")

                val period4text: TextView = inflatedView.findViewById(R.id.tue_6_period_4)
                period4text.text = set.elementAt(3).removePrefix("4")

                val period5text: TextView = inflatedView.findViewById(R.id.tue_6_period_5)
                period5text.text = set.elementAt(4).removePrefix("5")

                val period6text: TextView = inflatedView.findViewById(R.id.tue_6_period_6)
                period6text.text = set.elementAt(5).removePrefix("6")

                return inflatedView
            }
        }


        val inflatedView: View =
            inflater.inflate(R.layout.fragment_tuesday_5, container, false)

        return inflatedView


    }

}
