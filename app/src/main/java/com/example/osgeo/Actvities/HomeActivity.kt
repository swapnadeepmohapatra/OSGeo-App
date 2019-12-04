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
                "deegree",
                "deegree is open source software for spatial data infrastructures and the geospat…",
                "https://www.osgeo.org/projects/deegree/",
                "",
                "https://www.osgeo.org/wp-content/uploads/Deegree_740x412_acf_cropped-1.png"
            )
        )
        projectList.add(
            Project(
                "GeoMoose",
                "GeoMoose is a Web Client JavaScript Framework for displaying distributed cartogr…",
                "https://www.osgeo.org/projects/geomoose/",
                "",
                "https://www.osgeo.org/wp-content/uploads/GeoMoose.png"
            )
        )
        projectList.add(
            Project(
                "GeoServer",
                "Designed for interoperability, GeoServer publishes data from any major spatial d…",
                "https://www.osgeo.org/projects/geoserver/",
                "",
                "https://www.osgeo.org/wp-content/uploads/GeoServer.png"
            )
        )
        projectList.add(
            Project(
                "GeoTools",
                "An open source Java library providing a standards compliant approach for visuali…",
                "https://www.osgeo.org/projects/geotools/",
                "",
                "https://www.osgeo.org/wp-content/uploads/GeoTools_740x412_acf_cropped.png"
            )
        )
        projectList.add(
            Project(
                "PyWPS",
                "PyWPS is an implementation of the Web Processing Service standard from the Open …",
                "https://www.osgeo.org/projects/pywps/",
                "",
                "https://www.osgeo.org/wp-content/uploads/pywps-1_740x412_acf_cropped.png"
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