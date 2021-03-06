package com.designtesting.timelineappdev1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import android.widget.*
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.*
import kotlinx.android.synthetic.main.settings.*
import java.util.*

class SettingsActivity : AppCompatActivity() {

    var userHasInteracted = false

    //function that sets variable to true when the user touches the screen, and also dismisses the accent colour popup window
    override fun onUserInteraction() {
        userHasInteracted = true

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        //store preferences to sharedPreferences
        val sharedPreferences: SharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        //create shortcut tp sharedPreferences
        val editor = sharedPreferences.edit()



        //create function that returns true if the OS's dark theme is enabled
        fun isDarkThemeActive(activity: Activity): Boolean {
            return activity.resources.configuration.uiMode and
                    Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
        }

        //set app light/dark state
        when (sharedPreferences.getString("THEME", "LIGHT")) {
            "LIGHT" -> setDefaultNightMode(MODE_NIGHT_NO)
            "DARK" -> setDefaultNightMode(MODE_NIGHT_YES)
            "SYSTEM" -> setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)
        }

        //set app accent colour and status bar text colour (based on light/dark status)
        when (sharedPreferences.getString("ACCENT", "blue_middle")) {
            "blue_light" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_light)
                "DARK" -> setTheme(R.style.LightStatusBarText_blue_light)
                "SYSTEM" -> {when(isDarkThemeActive(this@SettingsActivity)){
                    false -> setTheme(R.style.DarkStatusBarText_blue_light)
                    true -> setTheme(R.style.LightStatusBarText_blue_light)
                }}}}
            "blue_middle" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_middle)
                "DARK" -> setTheme(R.style.LightStatusBarText_blue_middle)
                "SYSTEM" -> {when(isDarkThemeActive(this@SettingsActivity)){
                    false -> setTheme(R.style.DarkStatusBarText_blue_middle)
                    true -> setTheme(R.style.LightStatusBarText_blue_middle)
                }}}}
            "blue_dark" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_dark)
                "DARK" -> setTheme(R.style.LightStatusBarText_blue_dark)
                "SYSTEM" -> {when(isDarkThemeActive(this@SettingsActivity)){
                    false -> setTheme(R.style.DarkStatusBarText_blue_dark)
                    true -> setTheme(R.style.LightStatusBarText_blue_dark)
                }}}}
            "green_middle" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_green_middle)
                "DARK" -> setTheme(R.style.LightStatusBarText_green_middle)
                "SYSTEM" -> {when(isDarkThemeActive(this@SettingsActivity)){
                    false -> setTheme(R.style.DarkStatusBarText_green_middle)
                    true -> setTheme(R.style.LightStatusBarText_green_middle)
                }}}}
            "green_dark" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_green_dark)
                "DARK" -> setTheme(R.style.LightStatusBarText_green_dark)
                "SYSTEM" -> {when(isDarkThemeActive(this@SettingsActivity)){
                    false -> setTheme(R.style.DarkStatusBarText_green_dark)
                    true -> setTheme(R.style.LightStatusBarText_green_dark)
                }}}}
            "yellow" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_yellow)
                "DARK" -> setTheme(R.style.LightStatusBarText_yellow)
                "SYSTEM" -> {when(isDarkThemeActive(this@SettingsActivity)){
                    false -> setTheme(R.style.DarkStatusBarText_yellow)
                    true -> setTheme(R.style.LightStatusBarText_yellow)
                }}}}
            "orange" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_orange)
                "DARK" -> setTheme(R.style.LightStatusBarText_orange)
                "SYSTEM" -> {when(isDarkThemeActive(this@SettingsActivity)){
                    false -> setTheme(R.style.DarkStatusBarText_orange)
                    true -> setTheme(R.style.LightStatusBarText_orange)
                }}}}
            "red" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_red)
                "DARK" -> setTheme(R.style.LightStatusBarText_red)
                "SYSTEM" -> {when(isDarkThemeActive(this@SettingsActivity)){
                    false -> setTheme(R.style.DarkStatusBarText_red)
                    true -> setTheme(R.style.LightStatusBarText_red)
                }}}}
            "magenta" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_magenta)
                "DARK" -> setTheme(R.style.LightStatusBarText_magenta)
                "SYSTEM" -> {when(isDarkThemeActive(this@SettingsActivity)){
                    false -> setTheme(R.style.DarkStatusBarText_magenta)
                    true -> setTheme(R.style.LightStatusBarText_magenta)
                }}}}
            "purple" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_purple)
                "DARK" -> setTheme(R.style.LightStatusBarText_purple)
                "SYSTEM" -> {when(isDarkThemeActive(this@SettingsActivity)){
                    false -> setTheme(R.style.DarkStatusBarText_purple)
                    true -> setTheme(R.style.LightStatusBarText_purple)
                }}}}
            "grey_light" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_grey_light)
                "DARK" -> setTheme(R.style.LightStatusBarText_grey_light)
                "SYSTEM" -> {when(isDarkThemeActive(this@SettingsActivity)){
                    false -> setTheme(R.style.DarkStatusBarText_grey_light)
                    true -> setTheme(R.style.LightStatusBarText_grey_light)
                }}}}
            "grey_dark" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_grey_dark)
                "DARK" -> setTheme(R.style.LightStatusBarText_grey_dark)
                "SYSTEM" -> {when(isDarkThemeActive(this@SettingsActivity)){
                    false -> setTheme(R.style.DarkStatusBarText_grey_dark)
                    true -> setTheme(R.style.LightStatusBarText_grey_dark)
                }}}}
        }

        //set the status bar color to the accent color so that it blends in with the rest of this specific layout
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val typedValue = TypedValue()
            val theme: Resources.Theme = this.theme
            theme.resolveAttribute(R.attr.colorAccent, typedValue, true)
            @ColorInt val color = typedValue.data

            val window: Window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }

        //Set app language based on saved variable
        when (sharedPreferences.getString("LANGUAGE", "ENGLISH")) {
            "ENGLISH" -> {
                val locale = Locale("en")
                Locale.setDefault(locale)
                val config = Configuration()
                config.locale = locale
                baseContext.resources.updateConfiguration(
                    config,
                    baseContext.resources.displayMetrics
                )
            }
            "JAPANESE" -> {
                val locale = Locale("ja")
                Locale.setDefault(locale)
                val config = Configuration()
                config.locale = locale
                baseContext.resources.updateConfiguration(
                    config,
                    baseContext.resources.displayMetrics
                )
            }
        }

        //display activity
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)


        //create variable for the theme spinner (drop-down menu)
        val ThemeSpinner: Spinner = findViewById(R.id.spinner_theme_selection)

        //set theme spinner position based on which setting has already been selected
        when (sharedPreferences.getString("THEME", "LIGHT")) {
            "LIGHT" -> ThemeSpinner.setSelection(0, true)
            "DARK" -> ThemeSpinner.setSelection(1, true)
            "SYSTEM" -> ThemeSpinner.setSelection(2, true)
        }

        //create functions that detect user input on ThemeSpinner
        ThemeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            //triggers when user selects an item on the spinner
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                //check if user has actually touched the screen to bypass bug that causes these funcions to trigger at runtime
                if (userHasInteracted) {
                    when (pos) {
                        0 -> editor.putString("THEME", "LIGHT")
                        1 -> editor.putString("THEME", "DARK")
                        2 -> editor.putString("THEME", "SYSTEM")
                    }

                    //apply changes
                    editor.apply()

                    //wait to provide time for saving because the activity will be changed soon
                    Thread.sleep(350)

                    //start MainActivity, which will redirect to this activity
                    //(needed to essentially reset app so that the selected theme is immediately displayed)
                    startActivity(
                        Intent(applicationContext, SettingsActivity::class.java)
                    )
                }
            }
        }


        //create variable for the language spinner (drop-down menu)
        val LanguageSpinner: Spinner = findViewById(R.id.spinner_language_selection)

        //set language spinner position based on which setting has already been selected
        when (sharedPreferences.getString("LANGUAGE", "ENGLISH")) {
            "ENGLISH" -> LanguageSpinner.setSelection(0, true)
            "JAPANESE" -> LanguageSpinner.setSelection(1, true)
        }

        //create functions that detect user input on LanguageSpinner
        LanguageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            //triggers when user selects an item on the spinner
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                //check if user has actually touched the screen to bypass bug that causes these funcions to trigger at runtime
                if (userHasInteracted) {

                    //save setting based on the currently selected position
                    when (pos) {
                        0 -> editor.putString("LANGUAGE", "ENGLISH")
                        1 -> editor.putString("LANGUAGE", "JAPANESE")
                    }

                    editor.putString("RESET_TIMETABLE", "ALL")


                    //apply changes
                    editor.apply()

                    //wait to provide time for saving because the activity will be changed soon
                    Thread.sleep(400)

                    //start MainActivity, which will redirect to this activity
                    //(needed to essentially reset app so that the selected language is immediately displayed)
                    startActivity(Intent(applicationContext, SettingsActivity::class.java))
                }
            }
        }

        //create variable for the grade spinner (drop-down menu)
        val GradeSpinner: Spinner = findViewById(R.id.spinner_grade_selection)

        //set grade spinner position based on which setting has already been selected
        when (sharedPreferences.getString("GRADE", "9")) {
            "9" -> GradeSpinner.setSelection(0)
            "8" -> GradeSpinner.setSelection(1)
            "7" -> GradeSpinner.setSelection(2)
            "OTHER" -> GradeSpinner.setSelection(3)

        }

        //create functions that detect user input on GradeSpinner
        GradeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                //check if user has actually touched the screen to bypass bug that causes these funcions to trigger at runtime
                if (userHasInteracted) {
                    //save setting based on the currently selected position

                    when (pos) {
                        0 -> editor.putString("GRADE", "9")
                        1 -> editor.putString("GRADE", "8")
                        2 -> editor.putString("GRADE", "7")
                        3 -> editor.putString("GRADE", "OTHER")
                    }

                    editor.putString("RESET_TIMETABLE", "ALL")

                    //apply changes
                    editor.apply()
                }
            }
        }



        //setup for accent colour selection popup
        val layoutInflater = baseContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = layoutInflater.inflate(R.layout.accent_popup, null)
        val popupWindow = PopupWindow(popupView,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)

        //button that inflates accent colour popup when pressed
        val AccentButton: ImageButton = findViewById(R.id.accentButton)
        AccentButton.setOnClickListener {
            popupWindow.showAsDropDown(popupTether, 0, 0)
            spinner_language_selection.visibility = View.INVISIBLE
            text_select_language.visibility = View.INVISIBLE
            text_select_grade.visibility = View.INVISIBLE
            spinner_grade_selection.visibility = View.INVISIBLE
            spinner_theme_selection.visibility = View.INVISIBLE
            text_select_theme.visibility = View.INVISIBLE
        }

        fun showViews() {
            spinner_language_selection.visibility = View.VISIBLE
            text_select_language.visibility = View.VISIBLE
            text_select_grade.visibility = View.VISIBLE
            spinner_grade_selection.visibility = View.VISIBLE
            spinner_theme_selection.visibility = View.VISIBLE
            text_select_theme.visibility = View.VISIBLE
        }

        //button within the popup that dismisses it
        val btnDismiss = popupView.findViewById<View>(R.id.dismissButton) as ImageButton
        btnDismiss.setOnClickListener {
            popupWindow.dismiss()
            showViews()
        }



        //buttons for each accent colour that apply the colour and then restart the app so that the changes take place
        val button_blue_light = popupView.findViewById<View>(R.id.button_blue_light) as ImageButton
        button_blue_light.setOnClickListener {
            
            editor.putString("ACCENT", "blue_light");editor.apply();Thread.sleep(400)
            startActivity(Intent(applicationContext, SettingsActivity::class.java))

        }
        val button_blue_middle = popupView.findViewById<View>(R.id.button_blue_middle) as ImageButton
        button_blue_middle.setOnClickListener {
            
            editor.putString("ACCENT", "blue_middle");editor.apply();Thread.sleep(400)
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
        val button_blue_dark = popupView.findViewById<View>(R.id.button_blue_dark) as ImageButton
        button_blue_dark.setOnClickListener {
            
            editor.putString("ACCENT", "blue_dark");editor.apply();Thread.sleep(400)
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
        val button_green_middle = popupView.findViewById<View>(R.id.button_green_middle) as ImageButton
        button_green_middle.setOnClickListener {
            
            editor.putString("ACCENT", "green_middle");editor.apply();Thread.sleep(400)
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
        val button_green_dark = popupView.findViewById<View>(R.id.button_green_dark) as ImageButton
        button_green_dark.setOnClickListener {
            
            editor.putString("ACCENT", "green_dark");editor.apply();Thread.sleep(400)
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
        val button_yellow = popupView.findViewById<View>(R.id.button_yellow) as ImageButton
        button_yellow.setOnClickListener {
            
            editor.putString("ACCENT", "yellow");editor.apply();Thread.sleep(400)
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
        val button_orange = popupView.findViewById<View>(R.id.button_orange) as ImageButton
        button_orange.setOnClickListener {
            
            editor.putString("ACCENT", "orange");editor.apply();Thread.sleep(400)
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
        val button_red = popupView.findViewById<View>(R.id.button_red) as ImageButton
        button_red.setOnClickListener {
            
            editor.putString("ACCENT", "red");editor.apply();Thread.sleep(400)
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
        val button_magenta = popupView.findViewById<View>(R.id.button_magenta) as ImageButton
        button_magenta.setOnClickListener {
            
            editor.putString("ACCENT", "magenta");editor.apply();Thread.sleep(400)
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
        val button_purple = popupView.findViewById<View>(R.id.button_purple) as ImageButton
        button_purple.setOnClickListener {
            
            editor.putString("ACCENT", "purple");editor.apply();Thread.sleep(400)
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
        val button_grey_light = popupView.findViewById<View>(R.id.button_grey_light) as ImageButton
        button_grey_light.setOnClickListener {
            
            editor.putString("ACCENT", "grey_light");editor.apply();Thread.sleep(400)
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
        val button_grey_dark = popupView.findViewById<View>(R.id.button_grey_dark) as ImageButton
        button_grey_dark.setOnClickListener {
            
            editor.putString("ACCENT", "grey_dark");editor.apply();Thread.sleep(400)
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
    }

    //exit to main menu
    override fun onBackPressed() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }
}
