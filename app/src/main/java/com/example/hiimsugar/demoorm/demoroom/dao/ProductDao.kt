package com.example.hiimsugar.demoorm.demoroom.dao

import android.arch.persistence.room.*
import com.example.hiimsugar.demoorm.demoroom.enitity.Product


@Dao
interface ProductDao {

    @get:Query("SELECT * FROM product")
    val all: List<Product>

    @Query("SELECT * FROM product WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Product

    @Insert
    fun insertAll(products: List<Product>)

    @Update
    fun update(product: Product)

    @Delete
    fun delete(product: Product)
}