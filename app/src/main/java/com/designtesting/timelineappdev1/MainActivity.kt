package com.designtesting.timelineappdev1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.*
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import java.util.*


class MainActivity : AppCompatActivity()
    //, NavigationView.OnNavigationItemSelectedListener
{

    override fun onCreate(savedInstanceState: Bundle?) {

        //Retrieves saved variables
        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

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



        //Launch FirstTime activity (program) if user has not started the app before
        if (sharedPreferences.getBoolean("FIRST_TIME", true)) {
            val myIntent = Intent(this@MainActivity, FirstTime::class.java)
            this@MainActivity.startActivity(myIntent)
            finish()
        }

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
                "SYSTEM" -> {when(isDarkThemeActive(this@MainActivity)){
                        false -> setTheme(R.style.DarkStatusBarText_blue_light)
                        true -> setTheme(R.style.LightStatusBarText_blue_light)
                    }}}}
            "blue_middle" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_middle)
                "DARK" -> setTheme(R.style.LightStatusBarText_blue_middle)
                "SYSTEM" -> {when(isDarkThemeActive(this@MainActivity)){
                        false -> setTheme(R.style.DarkStatusBarText_blue_middle)
                        true -> setTheme(R.style.LightStatusBarText_blue_middle)
                    }}}}
            "blue_dark" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_dark)
                "DARK" -> setTheme(R.style.LightStatusBarText_blue_dark)
                "SYSTEM" -> {when(isDarkThemeActive(this@MainActivity)){
                        false -> setTheme(R.style.DarkStatusBarText_blue_dark)
                        true -> setTheme(R.style.LightStatusBarText_blue_dark)
                    }}}}
            "green_middle" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_green_middle)
                "DARK" -> setTheme(R.style.LightStatusBarText_green_middle)
                "SYSTEM" -> {when(isDarkThemeActive(this@MainActivity)){
                        false -> setTheme(R.style.DarkStatusBarText_green_middle)
                        true -> setTheme(R.style.LightStatusBarText_green_middle)
                    }}}}
            "green_dark" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_green_dark)
                "DARK" -> setTheme(R.style.LightStatusBarText_green_dark)
                "SYSTEM" -> {when(isDarkThemeActive(this@MainActivity)){
                        false -> setTheme(R.style.DarkStatusBarText_green_dark)
                        true -> setTheme(R.style.LightStatusBarText_green_dark)
                    }}}}
            "yellow" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_yellow)
                "DARK" -> setTheme(R.style.LightStatusBarText_yellow)
                "SYSTEM" -> {when(isDarkThemeActive(this@MainActivity)){
                        false -> setTheme(R.style.DarkStatusBarText_yellow)
                        true -> setTheme(R.style.LightStatusBarText_yellow)
                    }}}}
            "orange" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_orange)
                "DARK" -> setTheme(R.style.LightStatusBarText_orange)
                "SYSTEM" -> {when(isDarkThemeActive(this@MainActivity)){
                        false -> setTheme(R.style.DarkStatusBarText_orange)
                        true -> setTheme(R.style.LightStatusBarText_orange)
                    }}}}
            "red" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_red)
                "DARK" -> setTheme(R.style.LightStatusBarText_red)
                "SYSTEM" -> {when(isDarkThemeActive(this@MainActivity)){
                        false -> setTheme(R.style.DarkStatusBarText_red)
                        true -> setTheme(R.style.LightStatusBarText_red)
                    }}}}
            "magenta" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_magenta)
                "DARK" -> setTheme(R.style.LightStatusBarText_magenta)
                "SYSTEM" -> {when(isDarkThemeActive(this@MainActivity)){
                        false -> setTheme(R.style.DarkStatusBarText_magenta)
                        true -> setTheme(R.style.LightStatusBarText_magenta)
                    }}}}
            "purple" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_purple)
                "DARK" -> setTheme(R.style.LightStatusBarText_purple)
                "SYSTEM" -> {when(isDarkThemeActive(this@MainActivity)){
                        false -> setTheme(R.style.DarkStatusBarText_purple)
                        true -> setTheme(R.style.LightStatusBarText_purple)
                    }}}}
            "grey_light" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_grey_light)
                "DARK" -> setTheme(R.style.LightStatusBarText_grey_light)
                "SYSTEM" -> {when(isDarkThemeActive(this@MainActivity)){
                        false -> setTheme(R.style.DarkStatusBarText_grey_light)
                        true -> setTheme(R.style.LightStatusBarText_grey_light)
                    }}}}
            "grey_dark" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_grey_dark)
                "DARK" -> setTheme(R.style.LightStatusBarText_grey_dark)
                "SYSTEM" -> {when(isDarkThemeActive(this@MainActivity)){
                        false -> setTheme(R.style.DarkStatusBarText_grey_dark)
                        true -> setTheme(R.style.LightStatusBarText_grey_dark)
                    }}}}
        }





        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)


/*
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val drawer:DrawerLayout = findViewById(R.id.drawer_layout)

        val MenuButton: ImageButton = findViewById(R.id.menuButton)

        //runs when user clicks on menu button
        MenuButton.setOnClickListener {

            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START)
            }
            else{
                drawer.openDrawer(GravityCompat.START)
            }
        }
*/


        val settingsButton: ImageButton = findViewById(R.id.settingsButtonMain)
        settingsButton.setOnClickListener{
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        val managebacButton: ImageButton = findViewById(R.id.managebacButtonMain)
        managebacButton.setOnClickListener{
            val intent = Intent(this, Managebac::class.java)
            startActivity(intent)
        }

        val timetableButton: ImageButton = findViewById(R.id.timetableButtonMain)
        timetableButton.setOnClickListener{
            val intent = Intent(this, TimetableActivity::class.java)
            startActivity(intent)
        }

        val timelineButton: ImageButton = findViewById(R.id.timelineButtonMain)
        timelineButton.setOnClickListener{
            val intent = Intent(this, TimelineActivity::class.java)
            startActivity(intent)
        }





    }

/*
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val drawer:DrawerLayout = findViewById(R.id.drawer_layout)

        when (item.itemId) {
            R.id.nav_timetables -> {
                val intent = Intent(this, TimetableActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_managebac -> {
                val intent = Intent(this, Managebac::class.java)
                startActivity(intent)
            }
            R.id.nav_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)

            }
        }

        drawer.closeDrawer(GravityCompat.START)
        return true

    }
*/

    //on back press, close side menu if it is open
    //otherwise,  exit to home screen
    override fun onBackPressed() {

        val drawer:DrawerLayout = findViewById(R.id.drawer_layout)

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        }
        else{
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}
