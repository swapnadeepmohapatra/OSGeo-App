package com.example.osgeo.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.osgeo.Actvities.GitHubLoginActivity
import com.example.osgeo.Actvities.HomeActivity
import com.example.osgeo.Actvities.TracLoginActivity
import com.example.osgeo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.project_item.view.*


class ProjectsAdapter(
    private val items: ArrayList<HomeActivity.Project>,
    private val context: Context
) :

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

        holder.infoBtn.setOnClickListener {
            if (items[position].type == "GitHub") {
                context.startActivity(Intent(context, GitHubLoginActivity::class.java))
            } else {
                context.startActivity(Intent(context, TracLoginActivity::class.java))
            }
        }

        if (items[position].type == "GitHub") {
            picasso.load(R.drawable.github_logo).into(holder.companyLogo)
        } else {
            picasso.load(R.drawable.trac_logo).into(holder.companyLogo)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val projectName: TextView = view.projectName
    val projectTagLine: TextView = view.projectTagLine
    val projectImage: ImageView = view.projectImage
    val infoBtn: Button = view.infoBtn
    val companyLogo: ImageView = view.companyLogo
}