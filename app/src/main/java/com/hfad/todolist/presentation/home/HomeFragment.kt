package com.hfad.todolist.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.hfad.todolist.presentation.MainActivity
import com.hfad.todolist.R
import com.hfad.todolist.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root



        val dataset = arrayOf(HomeCategoryItem(5551L,"fjkc"),
            HomeCategoryItem(45351L,"lol"),
            HomeCategoryItem(451L,"lmao"),
            HomeCategoryItem(451L,"lmao"),
            HomeCategoryItem(451L,"lmao"),
            HomeCategoryItem(451L,"lmao"))

        val customAdapter = HomeCategoriesAdapter(dataset)


        binding.categoriesRecyclerView.adapter = customAdapter

        val dataTasks = arrayOf(HomeTaskItem(564L,"sdsds",54854L,true),
            HomeTaskItem(564L,"sdsds",54854L,true),
            HomeTaskItem(564L,"sdsds",54854L,true))

        val adapterTasks = HomeTasksAdapter(dataTasks)
        binding.tasksRecyclerView.adapter = adapterTasks

        binding.settingsHome.setOnClickListener {
            val popupMenu = PopupMenu(context, binding.settingsHome)
            popupMenu.menuInflater.inflate(R.menu.menu_settings_home, popupMenu.menu)
            popupMenu.show()
        }


        binding.drawerButton.setOnClickListener {
            (activity as MainActivity?)?.openDrawerMenu()
        }
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

