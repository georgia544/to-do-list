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


        // initializing all variables with their ids on below line.
        expandableLV = findViewById(R.id.idExpandableListView)

        // on below licustomne initializing our adapter and setting this adapter to expandable list view.
        expandableListAdapter = ExpandableListAdapter(drawerItems)
        expandableLV.setAdapter(expandableListAdapter)

        // on below line creating an array list for first tech tack and passing it to our tech stack list with tech stack name
        val starTasks: ArrayList<Item> = ArrayList()
        drawerItems.add(DrawerItem(Item("Star Tasks", R.drawable.star), starTasks))
        val category: ArrayList<Item> = ArrayList()
        category.add(Item("All", R.drawable.baseline_folder))
        category.add(Item("Work", R.drawable.work))
        category.add(Item("Personal", R.drawable.personal))
        category.add(Item("Birthday", R.drawable.cake))
        category.add(Item("Create New", R.drawable.add))
        drawerItems.add(DrawerItem(Item("Category", R.drawable.category), category))

        val theme: ArrayList<Item> = ArrayList()
        drawerItems.add(DrawerItem(Item("Theme", R.drawable.theme), theme))

        val faq: ArrayList<Item> = ArrayList()
        drawerItems.add(DrawerItem(Item("FAQ", R.drawable.faq), faq))

        val settings: ArrayList<Item> = ArrayList()
        drawerItems.add(DrawerItem(Item("Settings", R.drawable.settings), settings))






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
            drawerItem.isExpanded = !drawerItem.isExpanded


            //   Toast.makeText(baseContext, categoryItem.category, Toast.LENGTH_LONG).show()
            false
        })


    }
    fun openDrawerMenu() {

        binding.drawerLayout.openDrawer(Gravity.LEFT)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}


