package com.designtesting.timelineappdev1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class TimetableSettings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //store preferences to sharedPreferences
        val sharedPreferences: SharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()


        //create function that returns true if the OS's dark theme is enabled
        fun isDarkThemeActive(activity: Activity): Boolean {
            return activity.resources.configuration.uiMode and
                    Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
        }

        //set app light/dark state
        when (sharedPreferences.getString("THEME", "LIGHT")) {
            "LIGHT" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            "DARK" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            "SYSTEM" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }

        //set app accent colour and status bar text colour (based on light/dark status)
        when (sharedPreferences.getString("ACCENT", "blue_middle")) {
            "blue_light" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_light)
                "DARK" -> setTheme(R.style.LightStatusBarText_blue_light)
                "SYSTEM" -> {when(isDarkThemeActive(this@TimetableSettings)){
                    false -> setTheme(R.style.DarkStatusBarText_blue_light)
                    true -> setTheme(R.style.LightStatusBarText_blue_light)
                }}}}
            "blue_middle" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_middle)
                "DARK" -> setTheme(R.style.LightStatusBarText_blue_middle)
                "SYSTEM" -> {when(isDarkThemeActive(this@TimetableSettings)){
                    false -> setTheme(R.style.DarkStatusBarText_blue_middle)
                    true -> setTheme(R.style.LightStatusBarText_blue_middle)
                }}}}
            "blue_dark" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_dark)
                "DARK" -> setTheme(R.style.LightStatusBarText_blue_dark)
                "SYSTEM" -> {when(isDarkThemeActive(this@TimetableSettings)){
                    false -> setTheme(R.style.DarkStatusBarText_blue_dark)
                    true -> setTheme(R.style.LightStatusBarText_blue_dark)
                }}}}
            "green_middle" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_green_middle)
                "DARK" -> setTheme(R.style.LightStatusBarText_green_middle)
                "SYSTEM" -> {when(isDarkThemeActive(this@TimetableSettings)){
                    false -> setTheme(R.style.DarkStatusBarText_green_middle)
                    true -> setTheme(R.style.LightStatusBarText_green_middle)
                }}}}
            "green_dark" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_green_dark)
                "DARK" -> setTheme(R.style.LightStatusBarText_green_dark)
                "SYSTEM" -> {when(isDarkThemeActive(this@TimetableSettings)){
                    false -> setTheme(R.style.DarkStatusBarText_green_dark)
                    true -> setTheme(R.style.LightStatusBarText_green_dark)
                }}}}
            "yellow" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_yellow)
                "DARK" -> setTheme(R.style.LightStatusBarText_yellow)
                "SYSTEM" -> {when(isDarkThemeActive(this@TimetableSettings)){
                    false -> setTheme(R.style.DarkStatusBarText_yellow)
                    true -> setTheme(R.style.LightStatusBarText_yellow)
                }}}}
            "orange" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_orange)
                "DARK" -> setTheme(R.style.LightStatusBarText_orange)
                "SYSTEM" -> {when(isDarkThemeActive(this@TimetableSettings)){
                    false -> setTheme(R.style.DarkStatusBarText_orange)
                    true -> setTheme(R.style.LightStatusBarText_orange)
                }}}}
            "red" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_red)
                "DARK" -> setTheme(R.style.LightStatusBarText_red)
                "SYSTEM" -> {when(isDarkThemeActive(this@TimetableSettings)){
                    false -> setTheme(R.style.DarkStatusBarText_red)
                    true -> setTheme(R.style.LightStatusBarText_red)
                }}}}
            "magenta" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_magenta)
                "DARK" -> setTheme(R.style.LightStatusBarText_magenta)
                "SYSTEM" -> {when(isDarkThemeActive(this@TimetableSettings)){
                    false -> setTheme(R.style.DarkStatusBarText_magenta)
                    true -> setTheme(R.style.LightStatusBarText_magenta)
                }}}}
            "purple" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_purple)
                "DARK" -> setTheme(R.style.LightStatusBarText_purple)
                "SYSTEM" -> {when(isDarkThemeActive(this@TimetableSettings)){
                    false -> setTheme(R.style.DarkStatusBarText_purple)
                    true -> setTheme(R.style.LightStatusBarText_purple)
                }}}}
            "grey_light" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_grey_light)
                "DARK" -> setTheme(R.style.LightStatusBarText_grey_light)
                "SYSTEM" -> {when(isDarkThemeActive(this@TimetableSettings)){
                    false -> setTheme(R.style.DarkStatusBarText_grey_light)
                    true -> setTheme(R.style.LightStatusBarText_grey_light)
                }}}}
            "grey_dark" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_grey_dark)
                "DARK" -> setTheme(R.style.LightStatusBarText_grey_dark)
                "SYSTEM" -> {when(isDarkThemeActive(this@TimetableSettings)){
                    false -> setTheme(R.style.DarkStatusBarText_grey_dark)
                    true -> setTheme(R.style.LightStatusBarText_grey_dark)
                }}}}
        }
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timetables_settings)

        fun launchEditor() {
            startActivity(Intent(applicationContext, TimetableEditor::class.java))
        }



        val mondayButton: Button = findViewById(R.id.buttonMonday)
        mondayButton.setOnClickListener {
            editor.putString("EDITING_DAY", "Monday");editor.apply();Thread.sleep(350)
            launchEditor()
        }

        val tuesdayButton: Button = findViewById(R.id.buttonTuesday)
        tuesdayButton.setOnClickListener {
            editor.putString("EDITING_DAY", "Tuesday");editor.apply();Thread.sleep(350)
            launchEditor()
        }


        val wednesdayButton: Button = findViewById(R.id.buttonWednesday)
        wednesdayButton.setOnClickListener {
            editor.putString("EDITING_DAY", "Wednesday");editor.apply();Thread.sleep(350)
            launchEditor()
        }


        val thursdayButton: Button = findViewById(R.id.buttonThursday)
        thursdayButton.setOnClickListener {
            editor.putString("EDITING_DAY", "Thursday");editor.apply();Thread.sleep(350)
            launchEditor()
        }


        val fridayButton: Button = findViewById(R.id.buttonFriday)
        fridayButton.setOnClickListener {
            editor.putString("EDITING_DAY", "Friday");editor.apply();Thread.sleep(350)
            launchEditor()
        }


    }

    override fun onBackPressed() {
        startActivity(Intent(applicationContext, TimetableActivity::class.java))
    }
}