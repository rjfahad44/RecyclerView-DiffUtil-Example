package com.ft.recyclerview_diffutil_example.data.adapder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ft.recyclerview_diffutil_example.data.diffutil.MyDiffUtil
import com.ft.recyclerview_diffutil_example.data.model.Person
import com.ft.recyclerview_diffutil_example.databinding.RvItemBinding

class RvAdapter: RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    private var oldList = emptyList<Person>()

    inner class ViewHolder(val binding: RvItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(oldList[position]){
                binding.tvName.text = "Name : ${this.name}"
                binding.tvAge.text = "Age : ${this.age}"
            }
        }
    }

    override fun getItemCount(): Int = oldList.size

    fun setData(newList: List<Person>){
        val diffUtil = MyDiffUtil(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldList = newList
        diffResult.dispatchUpdatesTo(this)
    }
}