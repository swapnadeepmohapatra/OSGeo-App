package com.example.osgeo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.osgeo.Actvities.HomeActivity
import com.example.osgeo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.project_item.view.*

class ProjectsAdapter(private val items: ArrayList<HomeActivity.Project>, private val context: Context) :

    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.project_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val picasso = Picasso.get()

        holder.projectName.text = items[position].name
        holder.projectTagLine.text = items[position].tagLine

        picasso.load(items[position].imageUrl).into(holder.projectImage)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val projectName: TextView = view.projectName
    val projectTagLine: TextView = view.projectTagLine
    val projectImage: ImageView = view.projectImage
}