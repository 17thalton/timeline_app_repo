package com.designtesting.timelineappdev1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.TypedValue
import android.view.*
import android.widget.*
import androidx.annotation.ColorInt
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.settings.*
import kotlinx.android.synthetic.main.timeline_add_element.*

class TimelineAddInterface : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //get sharedPreferences
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
                        when (isDarkThemeActive(this@TimelineAddInterface)) {
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
                        when (isDarkThemeActive(this@TimelineAddInterface)) {
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
                        when (isDarkThemeActive(this@TimelineAddInterface)) {
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
                        when (isDarkThemeActive(this@TimelineAddInterface)) {
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
                        when (isDarkThemeActive(this@TimelineAddInterface)) {
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
                        when (isDarkThemeActive(this@TimelineAddInterface)) {
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
                        when (isDarkThemeActive(this@TimelineAddInterface)) {
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
                        when (isDarkThemeActive(this@TimelineAddInterface)) {
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
                        when (isDarkThemeActive(this@TimelineAddInterface)) {
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
                        when (isDarkThemeActive(this@TimelineAddInterface)) {
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
                        when (isDarkThemeActive(this@TimelineAddInterface)) {
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
                        when (isDarkThemeActive(this@TimelineAddInterface)) {
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
        setContentView(R.layout.timeline_add_element)

        if(sharedPreferences.getString("EDIT_ID", "") != "") {
            val headerText: TextView = findViewById(R.id.timelineEditHeader)
            headerText.text = getString(R.string.edit_task)
        }

        val saveButton: Button = findViewById(R.id.nextButton)
        
        val titleInput: TextInputEditText = findViewById(R.id.titleTextInput)
        val descInput: TextInputEditText = findViewById(R.id.descTextinput)

        val datePicker: DatePicker = findViewById(R.id.datePicker1)
        datePicker.minDate = System.currentTimeMillis() - 1000;

        var tempColour = ""

        saveButton.setOnClickListener {



            if(TextUtils.isEmpty(titleInput.text)) {
                Toast.makeText(applicationContext,getString(R.string.please_input_a_title),Toast.LENGTH_SHORT).show()
            }
            else {
                val title = titleInput.text.toString()
                val desc = descInput.text.toString()

                //  dd/MM/yyyy/hh/mm

                var dateString = ""

                if(datePicker.dayOfMonth.toString().length == 1){
                    dateString = "0"
                }
                dateString = "$dateString${datePicker.dayOfMonth}/"

                if(datePicker.month + 1.toString().length == 1){
                    val temp = dateString
                    dateString = "${temp}0"
                }

                val date = "$dateString${datePicker.month +1}/${datePicker.year}/23/59"


                var colour = ""

                colour = if(tempColour == "") {
                    sharedPreferences.getString("ACCENT", "blue_middle").toString()
                } else {
                    tempColour
                }



                val editID = sharedPreferences.getString("EDIT_ID", "")
                Toast.makeText(applicationContext,"$editID",Toast.LENGTH_SHORT).show()
                if(editID != "") {

                    colour = when (colour) {
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

                    editor.putStringSet("TASK_$editID", setOf("1$title", "2$date",
                        "3$desc", "4$colour"
                    ))
                }
                else{
                    editor.putString("NEW_TASK_TITLE", title)
                    editor.putString("NEW_TASK_DESC", desc)
                    editor.putString("NEW_TASK_DATE", date)
                    editor.putString("NEW_TASK_COLOUR", colour)

                }

                editor.apply()
                Thread.sleep(400)

                startActivity(Intent(applicationContext, TimelineActivity::class.java))

            }

        }



        //setup for colour selection popup
        val layoutInflater =
            baseContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = layoutInflater.inflate(R.layout.accent_popup, null)
        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        //button that inflates colour popup when pressed
        val colourButton: ImageButton = findViewById(R.id.colourButton)

        colourButton.setOnClickListener {
            popupWindow.showAsDropDown(taskAddToolbar, 68, -100)
        }


        //button within the popup that dismisses it
        val btnDismiss = popupView.findViewById<View>(R.id.dismissButton) as ImageButton
        btnDismiss.setOnClickListener {
            popupWindow.dismiss()
        }



        val colourText: TextView = findViewById(R.id.colourText)
        
        //buttons for each colour that apply the colour and then restart the app so that the changes take place
        val button_blue_light = popupView.findViewById<View>(R.id.button_blue_light) as ImageButton
        button_blue_light.setOnClickListener {

            tempColour = "blue_light"
            popupWindow.dismiss()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                colourButton.background = getDrawable(R.drawable.accent_blue_light)
            }
            else {
                colourText.text = getString(R.string.light_blue)
            }
        }
        val button_blue_middle =
            popupView.findViewById<View>(R.id.button_blue_middle) as ImageButton
        button_blue_middle.setOnClickListener {

            tempColour = "blue_middle"
            popupWindow.dismiss()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                colourButton.background = getDrawable(R.drawable.accent_blue_normal)
            }
            else {
                colourText.text = getString(R.string.middle_blue)
            }
        }
        val button_blue_dark = popupView.findViewById<View>(R.id.button_blue_dark) as ImageButton
        button_blue_dark.setOnClickListener {

            tempColour = "blue_dark"
            popupWindow.dismiss()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                colourButton.background = getDrawable(R.drawable.accent_blue_dark)
            }
            else {
                colourText.text = getString(R.string.dark_blue)
            }
        }
        val button_green_middle =
            popupView.findViewById<View>(R.id.button_green_middle) as ImageButton
        button_green_middle.setOnClickListener {

            tempColour = "green_middle"
            popupWindow.dismiss()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                colourButton.background = getDrawable(R.drawable.accent_green_normal)
            }
            else {
                colourText.text = getString(R.string.middle_green)
            }
        }
        val button_green_dark = popupView.findViewById<View>(R.id.button_green_dark) as ImageButton
        button_green_dark.setOnClickListener {

            tempColour = "green_dark"
            popupWindow.dismiss()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                colourButton.background = getDrawable(R.drawable.accent_green_dark)
            }
            else {
                colourText.text = getString(R.string.dark_green)
            }
        }
        val button_yellow = popupView.findViewById<View>(R.id.button_yellow) as ImageButton
        button_yellow.setOnClickListener {

            tempColour = "yellow"
            popupWindow.dismiss()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                colourButton.background = getDrawable(R.drawable.accent_yellow)
            }
            else {
                colourText.text = getString(R.string.yellow)
            }
        }
        val button_orange = popupView.findViewById<View>(R.id.button_orange) as ImageButton
        button_orange.setOnClickListener {

            tempColour = "orange"
            popupWindow.dismiss()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                colourButton.background = getDrawable(R.drawable.accent_orange)
            }
            else {
                colourText.text = getString(R.string.orange)
            }
        }
        val button_red = popupView.findViewById<View>(R.id.button_red) as ImageButton
        button_red.setOnClickListener {

            tempColour = "red"
            popupWindow.dismiss()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                colourButton.background = getDrawable(R.drawable.accent_red)
            }
            else {
                colourText.text = getString(R.string.red)
            }
        }
        val button_magenta = popupView.findViewById<View>(R.id.button_magenta) as ImageButton
        button_magenta.setOnClickListener {

            tempColour = "magenta"
            popupWindow.dismiss()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                colourButton.background = getDrawable(R.drawable.accent_magenta)
            }
            else {
                colourText.text = getString(R.string.magenta)
            }
        }
        val button_purple = popupView.findViewById<View>(R.id.button_purple) as ImageButton
        button_purple.setOnClickListener {

            tempColour = "purple"
            popupWindow.dismiss()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                colourButton.background = getDrawable(R.drawable.accent_purple)
            }
            else {
                colourText.text = getString(R.string.purple)
            }
        }
        val button_grey_light = popupView.findViewById<View>(R.id.button_grey_light) as ImageButton
        button_grey_light.setOnClickListener {

            tempColour = "grey_light"
            popupWindow.dismiss()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                colourButton.background = getDrawable(R.drawable.accent_grey_light)
            }
            else {
                colourText.text = getString(R.string.light_grey)
            }
        }
        val button_grey_dark = popupView.findViewById<View>(R.id.button_grey_dark) as ImageButton
        button_grey_dark.setOnClickListener {

            tempColour = "grey_dark"
            popupWindow.dismiss()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                colourButton.background = getDrawable(R.drawable.accent_grey_dark)
            }
            else {
                colourText.text = getString(R.string.dark_grey)
            }
        }


    }
    override fun onBackPressed() {

        //if the back button is pressed, then an alert dialog appears asking the user if they want to exit without saving

        val builder = AlertDialog.Builder(this@TimelineAddInterface)
        builder.setTitle(getString(R.string.return_to_timeline))
        builder.setMessage(getString(R.string.any_unsaved_changes))
        builder.setCancelable(true)

        builder.setPositiveButton(getString(R.string.option_ok)) { _, _ ->
            //if the user selects ok then the previous activity is launched
            startActivity(Intent(applicationContext, TimelineActivity::class.java))
        }

        builder.setNegativeButton(getString(R.string.option_cancel)) { dialog, _ ->
            //if the user selects cancel then the dialog box is canceled
            dialog.cancel()
        }


        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
    
}