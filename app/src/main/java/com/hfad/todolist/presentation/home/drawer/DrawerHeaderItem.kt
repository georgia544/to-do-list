package com.hfad.todolist.presentation.home.drawer

data class DrawerHeaderItem(
    var headerDrawerInnerItem: DrawerInnerItem,
    var expandableDrawerInnerItems: ArrayList<DrawerInnerItem>,
    var isExpanded:Boolean=false
)
