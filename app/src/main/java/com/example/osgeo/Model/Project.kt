package com.example.osgeo.Model


public class Project{
    private var name: String? = null
    private var age = 0

    fun User(name: String?, age: Int) {
        this.name = name
        this.age = age
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getAge(): Int {
        return age
    }

    fun setAge(age: Int) {
        this.age = age
    }
}