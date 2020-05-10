package com.designtesting.timelineappdev1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources.Theme
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.timetables.*
import java.util.*


class TimetableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //get sharedPreferences
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()


        fun resetMonday() {
            if(!sharedPreferences.getBoolean("Monday_IS_DEFAULT", true) && sharedPreferences.getString("RESET_TIMETABLE", "") == "ALL") {
                return
            }

            editor.putBoolean("Monday_IS_DEFAULT", true)

            when(sharedPreferences.getString("GRADE", "9")) {
                "9" -> {
                    editor.putStringSet("tt_mon",setOf("1${getString(R.string.subject_individuals)}", "2${getString(R.string.subject_science)}", "3${getString(R.string.subject_english)}", "4${getString(R.string.subject_qna)}"))
                }
                "8" -> {
                    editor.putStringSet("tt_mon",setOf("1${getString(R.string.subject_science)}", "2${getString(R.string.subject_art)}", "3${getString(R.string.subject_english)}", "4${getString(R.string.subject_qna)}"))
                        }
                "7" -> {
                    editor.putStringSet("tt_mon",setOf("1${getString(R.string.subject_art)}", "2${getString(R.string.subject_japanese)}", "3${getString(R.string.subject_math)}", "4${getString(R.string.subject_qna)}"))
                                  }
                "OTHER" -> {
                    editor.putStringSet("tt_mon",setOf("1Monday\ntimetable", "2is not set", "3", "4"))

                }
            }


        }

        fun resetTuesday(){
            if(!sharedPreferences.getBoolean("Tuesday_IS_DEFAULT", true) && sharedPreferences.getString("RESET_TIMETABLE", "") == "ALL") {
                return
            }

            editor.putBoolean("Tuesday_IS_DEFAULT", true)
            when(sharedPreferences.getString("GRADE", "9")) {
                "9" -> {
                    editor.putStringSet("tt_tue", setOf("1${getString(R.string.subject_japanese)}", "2${getString(R.string.subject_math)}", "3${getString(R.string.subject_art)}", "4${getString(R.string.subject_qna)}"))
                }
                "8" -> {
                    editor.putStringSet("tt_tue", setOf("1${getString(R.string.subject_japanese)}", "2${getString(R.string.subject_design)}", "3${getString(R.string.subject_math)}", "4${getString(R.string.subject_community)}"))
                }
                "7" -> {
                    editor.putStringSet("tt_tue", setOf("1${getString(R.string.subject_individuals)}", "2${getString(R.string.subject_science)}", "3${getString(R.string.subject_english)}", "4${getString(R.string.subject_qna)}"))
                }
                "OTHER" -> {
                    editor.putStringSet("tt_tue", setOf("1Tuesday\ntimetable", "2is not set", "3", "4"))
                }
            }
        }

        fun resetWednesday() {
            if(!sharedPreferences.getBoolean("Wednesday_IS_DEFAULT", true) && sharedPreferences.getString("RESET_TIMETABLE", "") == "ALL") {
                return
            }

            editor.putBoolean("Wednesday_IS_DEFAULT", true)
            when(sharedPreferences.getString("GRADE", "9")) {
                "9" -> {
                    editor.putStringSet("tt_wed", setOf("1${getString(R.string.subject_design)}", "2${getString(R.string.subject_individuals)}", "3${getString(R.string.subject_science)}", "4"))
                }
                "8" -> {
                    editor.putStringSet("tt_wed", setOf("1${getString(R.string.subject_health)}", "2${getString(R.string.subject_design)}", "3${getString(R.string.subject_individuals)}", "4"))
                }
                "7" -> {
                    editor.putStringSet("tt_wed", setOf("1${getString(R.string.subject_math)}", "2${getString(R.string.subject_japanese)}", "3${getString(R.string.subject_design)}", "4"))
                }
                "OTHER" -> {
                    editor.putStringSet("tt_wed", setOf("1Wednesday\ntimetable", "2is not set", "3", "4"))
                }
            }
        }

        fun resetThursday() {
            if(!sharedPreferences.getBoolean("Thursday_IS_DEFAULT", true) && sharedPreferences.getString("RESET_TIMETABLE", "") == "ALL") {
                return
            }

            editor.putBoolean("Thursday_IS_DEFAULT", true)
            when(sharedPreferences.getString("GRADE", "9")) {
                "9" -> {
                    editor.putStringSet("tt_thu", setOf("1${getString(R.string.subject_art)}", "2${getString(R.string.subject_health)}", "3${getString(R.string.subject_japanese)}", "4${getString(R.string.subject_qna)}"))
                }
                "8" -> {
                    editor.putStringSet("tt_thu", setOf("1${getString(R.string.subject_math)}", "2${getString(R.string.subject_art)}", "3${getString(R.string.subject_japanese)}", "4${getString(R.string.subject_qna)}"))
                }
                "7" -> {
                    editor.putStringSet("tt_thu", setOf("1${getString(R.string.subject_individuals)}", "2${getString(R.string.subject_english)}", "3${getString(R.string.subject_health)}", "4${getString(R.string.subject_qna)}"))
                }
                "OTHER" -> {
                    editor.putStringSet("tt_thu", setOf("1Thursday\ntimetable", "2is not set", "3", "4"))
                }
            }
        }

        fun resetFriday() {
            if(!sharedPreferences.getBoolean("Friday_IS_DEFAULT", true) && sharedPreferences.getString("RESET_TIMETABLE", "") == "ALL") {
                return
            }

            editor.putBoolean("Friday_IS_DEFAULT", true)
            when(sharedPreferences.getString("GRADE", "9")) {
                "9" -> {
                    editor.putStringSet("tt_fri", setOf("1${getString(R.string.subject_design)}", "2${getString(R.string.subject_english)}", "3${getString(R.string.subject_math)}", "4${getString(R.string.subject_qna)}"))
                }
                "8" -> {
                    editor.putStringSet("tt_fri", setOf("1${getString(R.string.subject_individuals)}", "2${getString(R.string.subject_english)}", "3${getString(R.string.subject_science)}", "4${getString(R.string.subject_qna)}"))
                }
                "7" -> {
                    editor.putStringSet("tt_fri", setOf("1${getString(R.string.subject_design)}", "2${getString(R.string.subject_science)}", "3${getString(R.string.subject_art)}", "4${getString(R.string.subject_qna)}"))
                }
                "OTHER" -> {
                    editor.putStringSet("tt_fri", setOf("1Friday\ntimetable", "2is not set", "3", "4"))
                }
            }
        }


        //todo fix timetable editing max string length (within text inputs)
        //sets the sharedpreferences for the timetables to their static defaults if a reset is requested and the user has not already customised them

        if (sharedPreferences.getString("RESET_TIMETABLE", "") != "") {

            when (sharedPreferences.getString("RESET_TIMETABLE", "")) {
                "Monday" -> resetMonday()
                "Tuesday" -> resetTuesday()
                "Wednesday" -> resetWednesday()
                "Thursday" -> resetThursday()
                "Friday" -> resetFriday()
                "ALL" -> {
                    resetMonday()
                    resetTuesday()
                    resetWednesday()
                    resetThursday()
                    resetFriday()
                }
            }

            editor.putString("RESET_TIMETABLE", "")

            editor.apply()
        }

        Thread.sleep(1000)
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
            "blue_light" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_light)
                    "DARK" -> setTheme(R.style.LightStatusBarText_blue_light)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableActivity)) {
                            false -> setTheme(R.style.DarkStatusBarText_blue_light)
                            true -> setTheme(R.style.LightStatusBarText_blue_light)
                        }
                    }
                }
            }
            "blue_middle" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_middle)
                    "DARK" -> setTheme(R.style.LightStatusBarText_blue_middle)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableActivity)) {
                            false -> setTheme(R.style.DarkStatusBarText_blue_middle)
                            true -> setTheme(R.style.LightStatusBarText_blue_middle)
                        }
                    }
                }
            }
            "blue_dark" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_dark)
                    "DARK" -> setTheme(R.style.LightStatusBarText_blue_dark)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableActivity)) {
                            false -> setTheme(R.style.DarkStatusBarText_blue_dark)
                            true -> setTheme(R.style.LightStatusBarText_blue_dark)
                        }
                    }
                }
            }
            "green_middle" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_green_middle)
                    "DARK" -> setTheme(R.style.LightStatusBarText_green_middle)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableActivity)) {
                            false -> setTheme(R.style.DarkStatusBarText_green_middle)
                            true -> setTheme(R.style.LightStatusBarText_green_middle)
                        }
                    }
                }
            }
            "green_dark" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_green_dark)
                    "DARK" -> setTheme(R.style.LightStatusBarText_green_dark)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableActivity)) {
                            false -> setTheme(R.style.DarkStatusBarText_green_dark)
                            true -> setTheme(R.style.LightStatusBarText_green_dark)
                        }
                    }
                }
            }
            "yellow" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_yellow)
                    "DARK" -> setTheme(R.style.LightStatusBarText_yellow)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableActivity)) {
                            false -> setTheme(R.style.DarkStatusBarText_yellow)
                            true -> setTheme(R.style.LightStatusBarText_yellow)
                        }
                    }
                }
            }
            "orange" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_orange)
                    "DARK" -> setTheme(R.style.LightStatusBarText_orange)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableActivity)) {
                            false -> setTheme(R.style.DarkStatusBarText_orange)
                            true -> setTheme(R.style.LightStatusBarText_orange)
                        }
                    }
                }
            }
            "red" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_red)
                    "DARK" -> setTheme(R.style.LightStatusBarText_red)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableActivity)) {
                            false -> setTheme(R.style.DarkStatusBarText_red)
                            true -> setTheme(R.style.LightStatusBarText_red)
                        }
                    }
                }
            }
            "magenta" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_magenta)
                    "DARK" -> setTheme(R.style.LightStatusBarText_magenta)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableActivity)) {
                            false -> setTheme(R.style.DarkStatusBarText_magenta)
                            true -> setTheme(R.style.LightStatusBarText_magenta)
                        }
                    }
                }
            }
            "purple" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_purple)
                    "DARK" -> setTheme(R.style.LightStatusBarText_purple)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableActivity)) {
                            false -> setTheme(R.style.DarkStatusBarText_purple)
                            true -> setTheme(R.style.LightStatusBarText_purple)
                        }
                    }
                }
            }
            "grey_light" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_grey_light)
                    "DARK" -> setTheme(R.style.LightStatusBarText_grey_light)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableActivity)) {
                            false -> setTheme(R.style.DarkStatusBarText_grey_light)
                            true -> setTheme(R.style.LightStatusBarText_grey_light)
                        }
                    }
                }
            }
            "grey_dark" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_grey_dark)
                    "DARK" -> setTheme(R.style.LightStatusBarText_grey_dark)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableActivity)) {
                            false -> setTheme(R.style.DarkStatusBarText_grey_dark)
                            true -> setTheme(R.style.LightStatusBarText_grey_dark)
                        }
                    }
                }
            }
        }

        //set the status bar color to the accent color so that it blends in with the rest of this specific layout
        val window: Window = window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val typedValue = TypedValue()
            val theme: Theme = this.theme
            theme.resolveAttribute(R.attr.colorAccent, typedValue, true)
            @ColorInt val color = typedValue.data

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.timetables)


        val settingsButton: ImageButton = findViewById(R.id.settingsButton)
        settingsButton.setOnClickListener {
            val intent = Intent(this, TimetableSettings::class.java)
            startActivity(intent)
        }



        val fragmentAdapter = PagerAdapter(supportFragmentManager, this)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)

        val viewPager: ViewPager = findViewById(R.id.viewpager_main)

        when (android.text.format.DateFormat.format("EEEE", Date())){
            "Monday" -> viewPager.setCurrentItem(0, false)
            "Tuesday" -> viewPager.setCurrentItem(1, false)
            "Wednesday" -> viewPager.setCurrentItem(2, false)
            "Thursday" -> viewPager.setCurrentItem(3, false)
            "Friday" -> viewPager.setCurrentItem(4, false)
        }

    }


    //launch mainactivity when the user presses the back button
    override fun onBackPressed() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }
}