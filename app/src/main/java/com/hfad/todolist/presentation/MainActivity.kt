package com.hfad.todolist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.widget.ExpandableListView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.hfad.todolist.R
import com.hfad.todolist.databinding.ActivityMainBinding
import com.hfad.todolist.presentation.home.drawer.DrawerHeaderItem
import com.hfad.todolist.presentation.home.drawer.DrawerInnerItem
import com.hfad.todolist.presentation.home.drawer.DrawerExpandableListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val drawerHeaderItems: ArrayList<DrawerHeaderItem> = ArrayList()
    lateinit var drawerExpandableListAdapter: DrawerExpandableListAdapter
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
        drawerExpandableListAdapter = DrawerExpandableListAdapter(drawerHeaderItems)
        expandableLV.setAdapter(drawerExpandableListAdapter)

        // on below line creating an array list for first tech tack and passing it to our tech stack list with tech stack name
        val starTasks: ArrayList<DrawerInnerItem> = ArrayList()
        drawerHeaderItems.add(DrawerHeaderItem(DrawerInnerItem("Star Tasks", R.drawable.star), starTasks))
        val category: ArrayList<DrawerInnerItem> = ArrayList()
        category.add(DrawerInnerItem("All", R.drawable.baseline_folder))
        category.add(DrawerInnerItem("Work", R.drawable.work))
        category.add(DrawerInnerItem("Personal", R.drawable.personal))
        category.add(DrawerInnerItem("Birthday", R.drawable.cake))
        category.add(DrawerInnerItem("Create New", R.drawable.add))
        drawerHeaderItems.add(DrawerHeaderItem(DrawerInnerItem("Category", R.drawable.category), category))

        val theme: ArrayList<DrawerInnerItem> = ArrayList()
        drawerHeaderItems.add(DrawerHeaderItem(DrawerInnerItem("Theme", R.drawable.theme), theme))

        val faq: ArrayList<DrawerInnerItem> = ArrayList()
        drawerHeaderItems.add(DrawerHeaderItem(DrawerInnerItem("FAQ", R.drawable.faq), faq))

        val settings: ArrayList<DrawerInnerItem> = ArrayList()
        drawerHeaderItems.add(DrawerHeaderItem(DrawerInnerItem("Settings", R.drawable.settings), settings))






        // on below line notifying adapter that data has changed.
        drawerExpandableListAdapter.notifyDataSetChanged()

        // on below line adding child click listener for expandable list view.
        expandableLV.setOnChildClickListener(ExpandableListView.OnChildClickListener { parent, v, groupPosition, childPosition, id -> // get the group header
            // on below line we are getting tech stack item from our tech stack list
            val drawerHeaderItem: DrawerHeaderItem = drawerHeaderItems.get(groupPosition)
            // on below line we are getting our programming language item from tech stack item.
            val programmingLanguageDrawerInnerItem: DrawerInnerItem =
                drawerHeaderItem.expandableDrawerInnerItems.get(childPosition)

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
            val drawerHeaderItem: DrawerHeaderItem = drawerHeaderItems.get(groupPosition)
            // displaying toast message on below line.
            drawerHeaderItem.isExpanded = !drawerHeaderItem.isExpanded


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


