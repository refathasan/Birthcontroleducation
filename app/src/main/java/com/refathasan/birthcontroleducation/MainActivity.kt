package com.refathasan.birthcontroleducation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    /**Note:: lateinit var = late initial variable
     * A variable which will be initial later stage of the program
     *
     */
    //Declare Drawer Layout
    lateinit var drawerLayout: DrawerLayout

    //Declare Navigation View
    lateinit var navigationView: NavigationView

    //Declare Toolbar
    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initialize Drawer Layout
        drawerLayout = findViewById(R.id.drawer_layout)
        //Initialize Navigation View
        navigationView = findViewById(R.id.navigationView)
        //Initialize Toolbar
        toolbar = findViewById(R.id.toolbar)
        /**
         * TODO:: setSupportActionBar(toolbar)
         * This method used to replace the actual default bar of the android activity
         * It will help to customize the toolbar and use it
         */
        setSupportActionBar(toolbar)
        /**
         * TODO:: Set method ActionBarDrawerToggle()
         * This method Contains 5 things
         * 1. Activity Object Reference
         * 2. Drawer Object
         * 3. Toolbar Object
         * 4. Drawer Oen Flag
         * 5. Drawer Close Flag
         */
        val toggle =
            ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        /**
         * TODO:: addDrawerListener(toggle)
         * This method will help to use the toggle in action. By using this  method the toggle is going to in action
         */
        drawerLayout.addDrawerListener(toggle)
        /**
         * TODO:: syncState(); this method sync the toggle. Check it is open or close
         */
        toggle.syncState()

        /**navigationView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            if()
            }
        })**/
    }
}