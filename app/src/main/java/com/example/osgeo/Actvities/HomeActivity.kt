package com.example.osgeo.Actvities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.osgeo.Adapter.ProjectsAdapter
import com.example.osgeo.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val projectList: ArrayList<Project> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        addProjects()

        rcylProjects.layoutManager = LinearLayoutManager(this)

        rcylProjects.adapter = ProjectsAdapter(projectList, this)

    }

    data class Project(
        val name: String,
        val tagLine: String,
        val url: String,
        val type: String,
        val imageUrl: String
    )

    // Adds animals to the empty animals ArrayList
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