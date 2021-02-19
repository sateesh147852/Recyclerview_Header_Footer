package com.recyclerviewheaderandfooter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recyclerviewheaderandfooter.databinding.FooterItemBinding
import com.recyclerviewheaderandfooter.databinding.HeaderItemBinding
import com.recyclerviewheaderandfooter.databinding.ItemBinding

private val header = 1
private val footer = 2
private val normal = 3

class HeaderFooterAdapter(private var names: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == header) {
            val binding =
                HeaderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return HeaderViewHolder(binding)
        } else if (viewType == footer) {
            val binding =
                FooterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return FooterViewHolder(binding)
        } else {
            val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return HeaderFooterViewHolder(binding)
        }

    }

    override fun getItemCount(): Int {
        return names.size + 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> header
            names.size + 1 -> footer
            else -> normal
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is  HeaderViewHolder) {
            val headerViewHolder: HeaderViewHolder = holder as HeaderViewHolder
            headerViewHolder.binding.tvHeader.text = "Header"
        }

        else if (holder is  FooterViewHolder) {
            val footerViewHolder: FooterViewHolder = holder as FooterViewHolder
            footerViewHolder.binding.tvFooter.text = "Footer"
        }
        else{
            val headerFooterViewHolder: HeaderFooterViewHolder = holder as HeaderFooterViewHolder
            headerFooterViewHolder.binding.tvName.text = names[position-1]
        }
    }

    class HeaderFooterViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

    class HeaderViewHolder(val binding: HeaderItemBinding) : RecyclerView.ViewHolder(binding.root)

    class FooterViewHolder(val binding: FooterItemBinding) : RecyclerView.ViewHolder(binding.root)
}