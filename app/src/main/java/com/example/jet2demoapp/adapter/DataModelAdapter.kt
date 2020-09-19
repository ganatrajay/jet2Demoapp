package com.example.jet2demoapp.adapter

import android.text.Html
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import com.bumptech.glide.request.RequestOptions
import com.example.jet2demoapp.R
import com.example.jet2demoapp.model.DataModel
import com.example.jet2demoapp.util.DigitFormatter
import kotlinx.android.synthetic.main.data_item.view.*

class DataModelAdapter(private val dataList:List<DataModel>): RecyclerView.Adapter<DataModelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataModelAdapter.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.data_item,parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name?.text = dataList[position].user?.get(0)?.name
        holder.designation.text = dataList[position].user?.get(0)?.designation
        holder.articletitle.text = dataList[position].media?.get(0)?.title
        holder.articleurl.text = Html.fromHtml(dataList[position].media?.get(0)?.url)
        holder.articleurl.linksClickable = true
        holder.articleurl.autoLinkMask = Linkify.ALL
        holder.content.text = dataList[position].content


        holder.articlecomments.text = dataList[position].comments?.let {
            DigitFormatter.digiCount(
                it
            )
        } + " Comments"
        holder.articlelikes.text = dataList[position].likes?.let { DigitFormatter.digiCount(it) } + " Likes"

        val proImgUrl = dataList[position].user?.get(0)?.avatar
        val artiImgUrl = dataList[position].media?.get(0)?.image


        Glide.with(holder.articaleImg.context).load(artiImgUrl).into(holder.articaleImg)
        Glide.with(holder.profileView.context).load(proImgUrl).apply(RequestOptions().circleCrop().placeholder(R.drawable.ic_user)).into(holder.profileView)
    }

    class ViewHolder(itemsView: View): RecyclerView.ViewHolder(itemsView) {
        val name = itemsView.findViewById<AppCompatTextView>(R.id.name)
        val designation = itemsView.findViewById<AppCompatTextView>(R.id.designation)
        val profileView = itemsView.findViewById<AppCompatImageView>(R.id.profileImg)
        val articaleImg = itemsView.findViewById<AppCompatImageView>(R.id.articaleImg)

        val content = itemsView.findViewById<AppCompatTextView>(R.id.content)
        val articletitle = itemsView.findViewById<AppCompatTextView>(R.id.articletitle)
        val articleurl = itemsView.findViewById<AppCompatTextView>(R.id.articleurl)
        val articlelikes = itemsView.findViewById<AppCompatTextView>(R.id.articlelikes)
        val articlecomments = itemsView.findViewById<AppCompatTextView>(R.id.articlecomments)

    }
}