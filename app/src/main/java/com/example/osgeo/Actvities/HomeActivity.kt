package com.example.osgeo.Actvities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.osgeo.Adapter.ProjectsAdapter
import com.example.osgeo.Model.Project
import com.example.osgeo.R
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_home.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException


class HomeActivity : AppCompatActivity() {

    private val projectList: ArrayList<Project> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        addProjects()

        fetchJson()
    }

    private fun putData(): Runnable? {
        rcylProjects.layoutManager = LinearLayoutManager(this)
        rcylProjects.adapter = ProjectsAdapter(projectList, this)
        println(projectList)
        return null
    }

    data class Project(
        val name: String,
        val tagLine: String,
        val url: String,
        val type: String,
        val imageUrl: String
    )

    private fun fetchJson() {
        val url = "https://enigmatic-brushlands-44077.herokuapp.com/projects"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(response.body().toString())
                println(body)

                val jsonArray = JSONArray(body)
                for (i in 0 until jsonArray.length()) {
                    val student: Project =
                        Gson().fromJson<Project>(jsonArray.get(i).toString(), Project::class.java)
                    projectList.add(student)
                }
                println(projectList[1].name)

                runOnUiThread { putData() }

            }

            override fun onFailure(call: Call, e: IOException) {
                println("not executed properly")
            }

        })
    }

    private fun addProjects() {
        projectList.add(
            Project(
                "GEOS",
                "GEOS (Geometry Engine – Open Source) is a C++ port of the ?Java Topology S…",
                "https://www.osgeo.org/projects/geos/",
                "Trac",
                "https://www.osgeo.org/wp-content/uploads/geos.png"
            )
        )
        projectList.add(
            Project(
                "PostGIS",
                "PostGIS adds GIS spatial types and support to PostgreSQL. It is used by Database…",
                "https://www.osgeo.org/projects/postgis/",
                "Trac",
                "https://www.osgeo.org/wp-content/uploads/postgis-logo-1.png"
            )
        )
        projectList.add(
            Project(
                "OSGeoLive",
                "OSGeoLive is a self-contained bootable DVD, USB thumb drive or Virtual Machine b…",
                "https://www.osgeo.org/projects/osgeolive/",
                "GitHub",
                "https://www.osgeo.org/wp-content/uploads/osgeolive-1.png"
            )
        )
        projectList.add(
            Project(
                "GDAL-OGR",
                "GDAL is a C++ translator library for more than 200 raster and vector geospatial …",
                "https://www.osgeo.org/projects/gdal/",
                "GitHub",
                "https://www.osgeo.org/wp-content/uploads/GDAL-1_740x412_acf_cropped.png"
            )
        )
        projectList.add(
            Project(
                "GRASS GIS",
                "GRASS GIS, commonly referred to as GRASS (Geographic Resources Analysis Support …",
                "https://www.osgeo.org/wp-content/uploads/grassgis_logo_colorlogo_text_whitebg_square.png",
                "Trac",
                "https://www.osgeo.org/wp-content/uploads/grassgis_logo_colorlogo_text_whitebg_square.png"
            )
        )
//        projectList.add(
//            Project(
//                "OSGeo4W",
//                "OSGeo4W is a binary distribution of a broad set of open source geospatial softwa…",
//                "https://www.osgeo.org/projects/osgeo4w/",
//                "",
//                "https://www.osgeo.org/wp-content/uploads/osgeo4w-logo.png"
//            )
//        )
    }
}
