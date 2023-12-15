package com.hfad.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView


// Creating a custom list view adapter on below line.
class CustomListViewAdapter(
    // creating a list for our tech stack on below line and passing tech stack item to it.
    private val drawerExpandableList: List<DrawerItem>,
) : BaseExpandableListAdapter() {

    // on below line we have to return the size of group in our case is tech stack for programming languages
    override fun getGroupCount(): Int {
        return drawerExpandableList.size
    }

    // below method is use to return size of child list in our case is language list
    override fun getChildrenCount(groupPosition: Int): Int {
        val itemsList = drawerExpandableList.get(groupPosition).drawerItemList
        return itemsList.size
    }

    // on below line we are returning the group from our tech stack list.
    override fun getGroup(groupPosition: Int): Any {
        return drawerExpandableList.get(groupPosition)
    }

    // below method is use to return the item for our child list
    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        // on below line we are getting our programming language list from tech stack list
        val drawerItemSubList = drawerExpandableList.get(groupPosition).drawerItemList
        // on below line e are getting item from our programming language list which we are taking from tech stack list
        return drawerItemSubList.get(childPosition)
    }

    // below method is use to get group position
    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    // below method is use to get child position.
    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    // below method is use to return true for stable ids.
    override fun hasStableIds(): Boolean {
        return true
    }

    // below method is use to inflate layout file for our group items.
    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        // on below line we are getting our group from tech stack item
        val drawerItem: DrawerItem = getGroup(groupPosition) as DrawerItem
        // on below line we are creating a layout inflater variable to inflate our layout file.
        val inflater =
            parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // on below line we are inflating our layout file for our tech stack item.
        val view = inflater.inflate(R.layout.drawer_item, null) as View
        // on below line we are creating and initializing variable for our tech stack tv.
        val itemName: TextView = view.findViewById(R.id.drawerItem)
        // on below line we are setting text for our tech stack text view.
        itemName.text = drawerItem.drawerItem
        // on below line returning the view.
        return view
    }

    // below method is use to inflate layout file for our child view.
    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        // on below line we are getting language from our group
        val itemDrawer: String = getChild(groupPosition, childPosition) as String
        // on below line we are creating a variable for our inflater.
        val inflater =
            parent?.context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // on below line we are inflating a layout file for programming language list item.
        val view = inflater.inflate(R.layout.drawer_expandable_item, null) as View
        // on below line we are creating and initializing our text view for programming language.
        val expandableItem: TextView = view.findViewById(R.id.drawer_expandable_item)
        // on below line setting data for our text view.
        expandableItem.text = itemDrawer
        // on below line returning the view.
        return view
    }

    // below method is use to specify weather the child item will be selectable or not
    // in our case we are specifying it as selectable.
    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}