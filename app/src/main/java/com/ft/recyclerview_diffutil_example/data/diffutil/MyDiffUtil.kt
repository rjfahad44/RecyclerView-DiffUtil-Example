package com.ft.recyclerview_diffutil_example.data.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.ft.recyclerview_diffutil_example.data.model.Person

class MyDiffUtil(
    private var oldList: List<Person>,
    private var newList: List<Person>
    ): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].id != newList[newItemPosition].id -> false
            oldList[oldItemPosition].name != newList[newItemPosition].name -> false
            oldList[oldItemPosition].age != newList[newItemPosition].age -> false
            else -> true
        }
    }
}