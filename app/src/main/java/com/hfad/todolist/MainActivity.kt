package com.hfad.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.widget.ExpandableListView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.hfad.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val drawerItems: ArrayList<DrawerItem> = ArrayList()
    lateinit var expandableListAdapter: ExpandableListAdapter
    lateinit var expandableLV: ExpandableListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)


        val builder = AppBarConfiguration.Builder(navController.graph)
        builder.setOpenableLayout(binding.drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navController)

//        binding.drawerLayout.addDrawerListener(object: DrawerListener {
//            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
//            }
//
//            override fun onDrawerOpened(drawerView: View) {
//
//            }
//
//            override fun onDrawerClosed(drawerView: View) {
//            }
//
//            override fun onDrawerStateChanged(newState: Int) {
//            }
//        })

        binding.drawerButton.setOnClickListener {
            binding.drawerLayout.openDrawer(Gravity.LEFT)
        }
        // initializing all variables with their ids on below line.
        expandableLV = findViewById(R.id.idExpandableListView)

        // on below licustomne initializing our adapter and setting this adapter to expandable list view.
        expandableListAdapter = ExpandableListAdapter(drawerItems)
        expandableLV.setAdapter(expandableListAdapter)

        // on below line creating an array list for first tech tack and passing it to our tech stack list with tech stack name
        val lng1: ArrayList<Item> = ArrayList()
        lng1.add(Item("Java",R.drawable.calendar))
        lng1.add(Item("Kotlin",R.drawable.category))
        drawerItems.add(DrawerItem(Item("Android Development",R.drawable.smile), lng1))

        // on below line creating an array list for second tech tack and passing it to our tech stack list with tech stack name
//        val lng2: ArrayList<String> = ArrayList()
//        lng2.add("Objective c")
//        lng2.add("Swift")
//        drawerItems.add(DrawerItem("IOS Development", lng2))
//
//        // on below line creating an array list for third tech tack and passing it to our tech stack list with tech stack name
//        val lng3: ArrayList<String> = ArrayList()
//        lng3.add("HTML")
//        lng3.add("CSS")
//        drawerItems.add(DrawerItem("Web Development", lng3))

        // on below line notifying adapter that data has changed.
        expandableListAdapter.notifyDataSetChanged()

        // on below line adding child click listener for expandable list view.
        expandableLV.setOnChildClickListener(ExpandableListView.OnChildClickListener { parent, v, groupPosition, childPosition, id -> // get the group header
            // on below line we are getting tech stack item from our tech stack list
            val drawerItem: DrawerItem = drawerItems.get(groupPosition)
            // on below line we are getting our programming language item from tech stack item.
            val programmingLanguageItem: Item =
                drawerItem.expandableItems.get(childPosition)
            // on below line we are displaying toast message
//            Toast.makeText(
//                baseContext,
//                categoryItem.category + "/" + programmingLanguageItem,
//                Toast.LENGTH_LONG
//            ).show()
            false
        })

        // on below line adding click listener for expandable list view.
        expandableLV.setOnGroupClickListener(ExpandableListView.OnGroupClickListener { parent, v, groupPosition, id -> // get the group header
            // on below line we are getting our tech stack item
            val drawerItem: DrawerItem = drawerItems.get(groupPosition)
            // displaying toast message on below line.
            //   Toast.makeText(baseContext, categoryItem.category, Toast.LENGTH_LONG).show()
            false
        })



    }
        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            menuInflater.inflate(R.menu.menu_toolbar, menu)
            return super.onCreateOptionsMenu(menu)
        }
}


