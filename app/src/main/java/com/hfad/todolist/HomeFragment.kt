package com.hfad.todolist

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.hfad.todolist.databinding.FragmentHomeBinding

class HomeFragment:Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.settingsHome.setOnClickListener {
            val popupMenu= PopupMenu(context, binding.settingsHome)
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

