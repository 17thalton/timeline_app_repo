package com.designtesting.timelineappdev1

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AlertDialog.Builder
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.textfield.TextInputEditText


class TimetableEditor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //store preferences to sharedPreferences
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
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
            "blue_light" -> {
                when (sharedPreferences.getString("THEME", "LIGHT")) {
                    "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_light)
                    "DARK" -> setTheme(R.style.LightStatusBarText_blue_light)
                    "SYSTEM" -> {
                        when (isDarkThemeActive(this@TimetableEditor)) {
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
                        when (isDarkThemeActive(this@TimetableEditor)) {
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
                        when (isDarkThemeActive(this@TimetableEditor)) {
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
                        when (isDarkThemeActive(this@TimetableEditor)) {
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
                        when (isDarkThemeActive(this@TimetableEditor)) {
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
                        when (isDarkThemeActive(this@TimetableEditor)) {
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
                        when (isDarkThemeActive(this@TimetableEditor)) {
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
                        when (isDarkThemeActive(this@TimetableEditor)) {
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
                        when (isDarkThemeActive(this@TimetableEditor)) {
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
                        when (isDarkThemeActive(this@TimetableEditor)) {
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
                        when (isDarkThemeActive(this@TimetableEditor)) {
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
                        when (isDarkThemeActive(this@TimetableEditor)) {
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
            val theme: Resources.Theme = this.theme
            theme.resolveAttribute(R.attr.colorAccent, typedValue, true)
            @ColorInt val color = typedValue.data

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.timetable_editor)

        val editingDay = sharedPreferences.getString("EDITING_DAY", "")

        val period1Input: TextInputEditText = findViewById(R.id.inputPeriod1)

        val period2Input: TextInputEditText = findViewById(R.id.inputPeriod2)
        val period2Locker: Button = findViewById(R.id.lockerPeriod2)

        val period3Input: TextInputEditText = findViewById(R.id.inputPeriod3)
        val period3Locker: Button = findViewById(R.id.lockerPeriod3)

        val period4Input: TextInputEditText = findViewById(R.id.inputPeriod4)
        val period4Locker: Button = findViewById(R.id.lockerPeriod4)

        val period5Input: TextInputEditText = findViewById(R.id.inputPeriod5)
        val period5Locker: Button = findViewById(R.id.lockerPeriod5)

        val period6Input: TextInputEditText = findViewById(R.id.inputPeriod6)
        val period6Locker: Button = findViewById(R.id.lockerPeriod6)

        fun lockPeriod2(lock: Boolean) {
            if (lock) {

                //locks and unlocks the text input by toggling the visibility of a button that is placed over the input box
                //used this method because there were unknown issues with toggling the on/off property of the input field itself
                period2Locker.visibility = View.VISIBLE
                period2Input.setText("")
                period2Input.hint =
                    "${getString(R.string.period_2)}\n${getString(R.string.fill_out_previous)}"
            } else {
                period2Locker.visibility = View.INVISIBLE
                period2Input.hint = getString(R.string.period_2)
            }
        }

        fun lockPeriod3(lock: Boolean) {
            if (lock) {
                period3Locker.visibility = View.VISIBLE
                period3Input.setText("")
                period3Input.hint =
                    "${getString(R.string.period_3)}\n${getString(R.string.fill_out_previous)}"
            } else {
                period3Locker.visibility = View.INVISIBLE
                period3Input.hint = getString(R.string.period_3)
            }
        }

        fun lockPeriod4(lock: Boolean) {
            if (lock) {
                period4Locker.visibility = View.VISIBLE
                period4Input.setText("")
                period4Input.hint =
                    "${getString(R.string.period_4)}\n${getString(R.string.fill_out_previous)}"
            } else {
                period4Locker.visibility = View.INVISIBLE
                period4Input.hint = getString(R.string.period_4)
            }
        }

        fun lockPeriod5(lock: Boolean) {
            if (lock) {
                period5Locker.visibility = View.VISIBLE
                period5Input.setText("")
                if (editingDay == "Wednesday") {
                    period5Input.hint =
                        "${getString(R.string.period_5_club)}\n${getString(R.string.fill_out_previous)}"
                } else {
                    period5Input.hint =
                        "${getString(R.string.period_5)}\n${getString(R.string.fill_out_previous)}"
                }
            } else {
                period5Locker.visibility = View.INVISIBLE
                if (editingDay == "Wednesday") {
                    period5Input.hint = getString(R.string.period_5_club)
                } else {
                    period5Input.hint = getString(R.string.period_5)
                }
            }
        }

        fun lockPeriod6(lock: Boolean) {
            if (lock) {
                period6Locker.visibility = View.VISIBLE
                period6Input.setText("")
                period6Input.hint =
                    "${getString(R.string.period_6_club)}\n${getString(R.string.fill_out_previous)}"
            } else {
                period6Locker.visibility = View.INVISIBLE
                period6Input.hint = getString(R.string.period_6_club)
            }
        }

        period1Input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s)) {
                    lockPeriod2(true)
                    lockPeriod3(true)
                    lockPeriod4(true)
                    lockPeriod5(true)
                    lockPeriod6(true)
                } else {
                    lockPeriod2(false)
                }
            }
        })
        period2Input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s)) {
                    lockPeriod3(true)
                    lockPeriod4(true)
                    lockPeriod5(true)
                    lockPeriod6(true)
                } else {
                    lockPeriod3(false)
                }
            }
        })
        period3Input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s)) {
                    lockPeriod4(true)
                    lockPeriod5(true)
                    lockPeriod6(true)
                } else {
                    lockPeriod4(false)
                }
            }
        })
        period4Input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s)) {
                    lockPeriod5(true)
                    lockPeriod6(true)
                } else {
                    lockPeriod5(false)
                }
            }
        })
        period5Input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s)) {
                    lockPeriod6(true)
                } else {
                    lockPeriod6(false)
                }
            }
        })

        val titleText: TextView = findViewById(R.id.timetableEditText)

        when (editingDay) {
            "Monday" -> titleText.text = getString(R.string.monday)
            "Tuesday" -> titleText.text = getString(R.string.tuesday)
            "Wednesday" -> titleText.text = getString(R.string.wednesday)
            "Thursday" -> titleText.text = getString(R.string.thursday)
            "Friday" -> titleText.text = getString(R.string.friday)
        }

        if (editingDay == "Wednesday") {
            period5Input.hint = getString(R.string.period_5_club)
            period6Input.visibility = View.INVISIBLE
        }

        lockPeriod2(true)
        lockPeriod3(true)
        lockPeriod4(true)
        lockPeriod5(true)
        lockPeriod6(true)

        val saveButton: Button = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            var key = ""

            when (editingDay) {
                "Monday" -> {
                    key = "tt_mon"
                }
                "Tuesday" -> {
                    key = "tt_tue"
                }
                "Wednesday" -> {
                    key = "tt_wed"
                }
                "Thursday" -> {
                    key = "tt_thu"
                }
                "Friday" -> {
                    key = "tt_fri"
                }
            }

            editor.putStringSet(
                key,
                setOf(
                    "1${period1Input.text.toString()}",
                    "2${period2Input.text.toString()}",
                    "3${period3Input.text.toString()}",
                    "4${period4Input.text.toString()}",
                    "5${period5Input.text.toString()}",
                    "6${period6Input.text.toString()}"
                )
            )

            editor.putBoolean("TIMETABLE_IS_DEFAULT", false)

            editor.apply()
            Thread.sleep(400)

            startActivity(Intent(applicationContext, TimetableSettings::class.java))
        }

        val resetButton: Button = findViewById(R.id.resetButton)
        resetButton.setOnClickListener{
            val builder = Builder(this@TimetableEditor)
            builder.setTitle(getString(R.string.reset_to_default))
            builder.setMessage(getString(R.string.only_this_day))
            builder.setCancelable(true)

            builder.setPositiveButton(getString(R.string.option_ok)) { _, _ ->
                editor.putBoolean("TIMETABLE_IS_DEFAULT", true)
                editor.putBoolean("RESET_TIMETABLE", true)
                editor.apply()
                Thread.sleep(400)
                startActivity(Intent(applicationContext, TimetableSettings::class.java))
            }

            builder.setNegativeButton(getString(R.string.option_cancel)) { dialog, _ ->
                dialog.cancel()
            }


            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }

    }

    override fun onBackPressed() {

        //if the back button is pressed, then an alert dialog appears asking the user if they want to exit without saving

        val builder = Builder(this@TimetableEditor)
        builder.setTitle(getString(R.string.return_to_timetable))
        builder.setMessage(getString(R.string.any_unsaved_changes))
        builder.setCancelable(true)

        builder.setPositiveButton(getString(R.string.option_ok)) { _, _ ->
            //if the user selects ok then the previous activity is launched
            startActivity(Intent(applicationContext, TimetableSettings::class.java))
        }

        builder.setNegativeButton(getString(R.string.option_cancel)) { dialog, _ ->
            //if the user selects cancel then the dialog box is canceled
            dialog.cancel()
        }


        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}