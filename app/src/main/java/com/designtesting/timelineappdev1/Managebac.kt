package com.designtesting.timelineappdev1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.managebac.*


class Managebac : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {



    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setTheme(R.style.DarkStatusBarText_blue_middle)
        val sharedPreferences: SharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

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
                "SYSTEM" -> {when(isDarkThemeActive(this@Managebac)){
                    false -> setTheme(R.style.DarkStatusBarText_blue_light)
                    true -> setTheme(R.style.LightStatusBarText_blue_light)
                }}}}
            "blue_middle" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_middle)
                "DARK" -> setTheme(R.style.LightStatusBarText_blue_middle)
                "SYSTEM" -> {when(isDarkThemeActive(this@Managebac)){
                    false -> setTheme(R.style.DarkStatusBarText_blue_middle)
                    true -> setTheme(R.style.LightStatusBarText_blue_middle)
                }}}}
            "blue_dark" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_blue_dark)
                "DARK" -> setTheme(R.style.LightStatusBarText_blue_dark)
                "SYSTEM" -> {when(isDarkThemeActive(this@Managebac)){
                    false -> setTheme(R.style.DarkStatusBarText_blue_dark)
                    true -> setTheme(R.style.LightStatusBarText_blue_dark)
                }}}}
            "green_middle" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_green_middle)
                "DARK" -> setTheme(R.style.LightStatusBarText_green_middle)
                "SYSTEM" -> {when(isDarkThemeActive(this@Managebac)){
                    false -> setTheme(R.style.DarkStatusBarText_green_middle)
                    true -> setTheme(R.style.LightStatusBarText_green_middle)
                }}}}
            "green_dark" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_green_dark)
                "DARK" -> setTheme(R.style.LightStatusBarText_green_dark)
                "SYSTEM" -> {when(isDarkThemeActive(this@Managebac)){
                    false -> setTheme(R.style.DarkStatusBarText_green_dark)
                    true -> setTheme(R.style.LightStatusBarText_green_dark)
                }}}}
            "yellow" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_yellow)
                "DARK" -> setTheme(R.style.LightStatusBarText_yellow)
                "SYSTEM" -> {when(isDarkThemeActive(this@Managebac)){
                    false -> setTheme(R.style.DarkStatusBarText_yellow)
                    true -> setTheme(R.style.LightStatusBarText_yellow)
                }}}}
            "orange" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_orange)
                "DARK" -> setTheme(R.style.LightStatusBarText_orange)
                "SYSTEM" -> {when(isDarkThemeActive(this@Managebac)){
                    false -> setTheme(R.style.DarkStatusBarText_orange)
                    true -> setTheme(R.style.LightStatusBarText_orange)
                }}}}
            "red" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_red)
                "DARK" -> setTheme(R.style.LightStatusBarText_red)
                "SYSTEM" -> {when(isDarkThemeActive(this@Managebac)){
                    false -> setTheme(R.style.DarkStatusBarText_red)
                    true -> setTheme(R.style.LightStatusBarText_red)
                }}}}
            "magenta" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_magenta)
                "DARK" -> setTheme(R.style.LightStatusBarText_magenta)
                "SYSTEM" -> {when(isDarkThemeActive(this@Managebac)){
                    false -> setTheme(R.style.DarkStatusBarText_magenta)
                    true -> setTheme(R.style.LightStatusBarText_magenta)
                }}}}
            "purple" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_purple)
                "DARK" -> setTheme(R.style.LightStatusBarText_purple)
                "SYSTEM" -> {when(isDarkThemeActive(this@Managebac)){
                    false -> setTheme(R.style.DarkStatusBarText_purple)
                    true -> setTheme(R.style.LightStatusBarText_purple)
                }}}}
            "grey_light" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_grey_light)
                "DARK" -> setTheme(R.style.LightStatusBarText_grey_light)
                "SYSTEM" -> {when(isDarkThemeActive(this@Managebac)){
                    false -> setTheme(R.style.DarkStatusBarText_grey_light)
                    true -> setTheme(R.style.LightStatusBarText_grey_light)
                }}}}
            "grey_dark" -> {when (sharedPreferences.getString("THEME", "LIGHT")) {
                "LIGHT" -> setTheme(R.style.DarkStatusBarText_grey_dark)
                "DARK" -> setTheme(R.style.LightStatusBarText_grey_dark)
                "SYSTEM" -> {when(isDarkThemeActive(this@Managebac)){
                    false -> setTheme(R.style.DarkStatusBarText_grey_dark)
                    true -> setTheme(R.style.LightStatusBarText_grey_dark)
                }}}}
        }

        super.onCreate(savedInstanceState)

        val USER_AGENT =
            "Mozilla/5.0 (Linux; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + ") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19"


        setContentView(R.layout.managebac)
        val webViewthingy = findViewById<WebView>(R.id.webView)
        webView.settings.userAgentString = USER_AGENT;
        webView!!.settings.javaScriptEnabled = true
        webView.settings.saveFormData = false
        webView.settings.savePassword = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            webViewthingy.importantForAutofill = View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS
        }

        var oldurl = "https://oyis.managebac.com/"
        var olderurl = ""

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            var murl = ""

            override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
                olderurl = oldurl
                oldurl = url.toString()
            }
        }

        webViewthingy.loadUrl("https://oyis.managebac.com/")

        val BackButton: ImageButton = findViewById(R.id.backButton)

        BackButton.setOnClickListener {
            if (olderurl != "") {
                webViewthingy.loadUrl(olderurl)
            }
        }


        val ReloadButton: ImageButton = findViewById(R.id.reloadButton)

        ReloadButton.setOnClickListener {
            webViewthingy.reload()
        }

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)

        when (item.itemId) {
            R.id.nav_timetables -> {
                val intent = Intent(this, FirstTime::class.java)
                startActivity(intent)

            }
            R.id.nav_managebac -> {

            }
            R.id.nav_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)

            }
        }

        drawer.closeDrawer(GravityCompat.START)
        return true

    }
    override fun onBackPressed() {

        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        }
        else{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}



