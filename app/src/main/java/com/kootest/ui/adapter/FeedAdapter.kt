package com.kootest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kootest.data.response.Feed
import com.kootest.databinding.FeedItemViewBinding


class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    private var items: ArrayList<Feed> = arrayListOf()

    init {
        setHasStableIds(true)
    }

    fun addItems(newList: List<Feed>) {
        try {
            val l = items.size
            items.addAll(newList)
            notifyItemRangeInserted(l, newList.size)
        } catch (ex: Throwable) {
            ex.printStackTrace()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FeedViewHolder {

        val binding =
            FeedItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemId(position: Int): Long {
        return items[position].id.toLong()
    }

    inner class FeedViewHolder(private val binding: FeedItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(feed: Feed) {
            with(binding) {
                try {
                    title.text = feed.title
                    body.text = feed.body
                } catch (ex: java.lang.Exception) {
                    ex.printStackTrace()
                }
            }
        }
    }
}