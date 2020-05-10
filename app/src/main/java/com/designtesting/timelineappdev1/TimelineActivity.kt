package com.designtesting.timelineappdev1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.qap.ctimelineview.TimelineRow
import org.qap.ctimelineview.TimelineViewAdapter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class TimelineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timeline_layout)

        //get sharedPreferences
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val timelineRowsList: ArrayList<TimelineRow> = ArrayList()


        //Sat May 09 15:33:01 GMT+09:00 2020

        @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        fun generateDate(ddMMyyyyHHmm: String): Date {
            val sdf: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy/hh/mm", Locale.getDefault());
            return Date(sdf.parse(ddMMyyyyHHmm).time)
        }


        fun findFirstNotInSet(values:Set<Int>):Int {
            for (i in 1 until Integer.MAX_VALUE) {
                if (!values.contains(i)) {
                    return i
                }
            }
            return 0
        }

        fun stringSetToIntSet(values:MutableSet<String>):Set<Int> {
            val output = mutableSetOf<Int>()
            for (i in values) {
                output.add(i.toInt())
            }
            return output
        }

        fun getDayName(newDate: String): String {
            return when (generateDate(newDate).day) {
                0 -> getString(R.string.sunday)
                1 -> getString(R.string.monday)
                2 -> getString(R.string.tuesday)
                3 -> getString(R.string.wednesday)
                4 -> getString(R.string.thursday)
                5 -> getString(R.string.friday)
                6 -> getString(R.string.saturday)
                else -> "error #01"
            }
        }

        fun getMonthName(newDate: String): String {
            return when (generateDate(newDate).month) {
                0 -> getString(R.string.january)
                1 -> getString(R.string.february)
                2 -> getString(R.string.march)
                3 -> getString(R.string.april)
                4 -> getString(R.string.may)
                5 -> getString(R.string.june)
                6 -> getString(R.string.july)
                7 -> getString(R.string.august)
                8 -> getString(R.string.september)
                9 -> getString(R.string.october)
                10 -> getString(R.string.november)
                11-> getString(R.string.december)
                else -> getString(R.string.january)
            }
        }



        val idList = sharedPreferences.getStringSet("TASK_IDS", setOf("0"))!!.toMutableSet()

        if(idList.count() > 1) {
            for(id in stringSetToIntSet(idList)) {
                if(id != 0) {

                    val taskData = sharedPreferences.getStringSet("TASK_$id", setOf())


                    val newTask = TimelineRow(id+1)

                    newTask.title = taskData!!.sorted().elementAt(0).removePrefix("1")
                    newTask.date = generateDate(taskData.sorted().elementAt(1).removePrefix("2"))
                    newTask.description = taskData.sorted().elementAt(2).removePrefix("3")
                    newTask.backgroundColor = Color.parseColor(taskData.sorted().elementAt(3).removePrefix("4"))
                    newTask.bellowLineColor = Color.parseColor(taskData.sorted().elementAt(3).removePrefix("4"))


                    timelineRowsList.add(newTask)

                }
            }

            val myAdapter: ArrayAdapter<TimelineRow> = TimelineViewAdapter(
                this, 0, timelineRowsList,  //if true, list will be sorted by date
                true
            )


            // Get the ListView and Bind it with the Timeline Adapter
            val myListView: ListView =
                findViewById<View>(R.id.timeline_listView) as ListView
            myListView.setAdapter(myAdapter)



            //handles clicks on the rows
            val adapterListener =
                OnItemClickListener { parent, view, position, id ->
                    editor.putString("EDIT_ID", id.toString())
                    editor.apply()
                    Thread.sleep(400)

                    startActivity(Intent(applicationContext, TimelineAddInterface::class.java))
                }
            myListView.setOnItemClickListener(adapterListener)
        }


        val newTitle = sharedPreferences.getString("NEW_TASK_TITLE", "")



        if(newTitle != "") {

            val id = findFirstNotInSet(stringSetToIntSet(idList))

            val newDate = sharedPreferences.getString("NEW_TASK_DATE", "").toString()

            val newDesc = "${sharedPreferences.getString("NEW_TASK_DESC", "")}\n${getDayName(newDate)}, ${getMonthName(newDate)} ${generateDate(newDate).date}, ${newDate[5]}${newDate[6]}${newDate[7]}${newDate[8]}"
            val newColour = when (sharedPreferences.getString("NEW_TASK_COLOUR", "blue_middle")) {
                "blue_light" -> "#51C3F0"
                "blue_middle" -> "#5180F0"
                "blue_dark" -> "#3F51B5"
                "green_middle" -> "#5CFC51"
                "green_dark" -> "#00C853"
                "yellow" -> "#FFD600"
                "orange" -> "#FF5722"
                "red" -> "#FC5151"
                "magenta" -> "#E040FB"
                "purple" -> "#5E35B1"
                "grey_light" -> "#B3B3B3"
                "grey_dark" -> "#515151"
                else -> "#5180F0"
            }

            val newTask = TimelineRow(id+1)
            
            newTask.title = newTitle
            newTask.date = generateDate(newDate)
            newTask.description = newDesc
            newTask.backgroundColor = Color.parseColor(newColour)
            newTask.bellowLineColor = Color.parseColor(newColour)



            editor.putStringSet("TASK_$id", setOf("1$newTitle", "2" + sharedPreferences.getString("NEW_TASK_DATE", "").toString(),
                "3$newDesc", "4$newColour"
            ))

            idList.add(id.toString())

            editor.putStringSet("TASK_IDS", idList)



            editor.putString("NEW_TASK_TITLE", "")
            
            editor.apply()


            timelineRowsList.add(newTask)

            val myAdapter: ArrayAdapter<TimelineRow> = TimelineViewAdapter(
                this, 0, timelineRowsList,  //if true, list will be sorted by date
                true
            )


            // Get the ListView and Bind it with the Timeline Adapter
            val myListView: ListView =
                findViewById<View>(R.id.timeline_listView) as ListView
            myListView.setAdapter(myAdapter)



            //handles clicks on the rows
            val adapterListener =
                OnItemClickListener { parent, view, position, id ->

                    //todo EDITOR
                    val row = timelineRowsList[position]
                    Toast.makeText(this@TimelineActivity, row.title, Toast.LENGTH_SHORT).show()
                }
            myListView.setOnItemClickListener(adapterListener)
        }


        val createButton: Button = findViewById(R.id.createButton)
        createButton.setOnClickListener{


            val intent = Intent(this, TimelineAddInterface::class.java)
            startActivity(intent)


        }









    }

    override fun onBackPressed() {

        startActivity(Intent(applicationContext, MainActivity::class.java))

    }
}