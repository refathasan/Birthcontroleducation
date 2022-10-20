package com.refathasan.birthcontroleducation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
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
        drawerLayout = findViewById(R.id.main_drawer)
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

        navigationView.setNavigationItemSelectedListener { item -> //TODO("Not yet implemented")
            when (item.itemId) {
                R.id.why_contra -> {
                    load_fragment(Why_Contra_Fragment())
                }
                R.id.types_contra -> {
                    load_fragment(Contra_types_Fragment())
                }
                R.id.male_options -> {
                    load_fragment(Male_Otions_Fragment())
                }
                R.id.female_options -> {
                    load_fragment(Female_Otions_Fragment())
                }
                R.id.option_statistics -> {
                    load_fragment(Stat_Fragment())
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    private fun load_fragment(fragment: Fragment) {
///        TODO("Not yet implemented")
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container, fragment)
        fragmentTransaction.commit()
    }
}