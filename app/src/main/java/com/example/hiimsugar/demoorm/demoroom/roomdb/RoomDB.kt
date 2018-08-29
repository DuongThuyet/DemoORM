package com.example.hiimsugar.demoorm.demoroom.roomdb

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.hiimsugar.demoorm.demoroom.dao.ProductDao
import com.example.hiimsugar.demoorm.demoroom.enitity.Product


@Database(entities = [(Product::class)], version = 1)
abstract class RoomDB : RoomDatabase() {
    abstract fun productDao(): ProductDao
//    open val MIGRATION_1_2: Migration = object : Migration(1, 2) {
//        override fun migrate(database: SupportSQLiteDatabase) {
//            database.execSQL("ALTER TABLE product " + " ADD COLUMN price INTEGER")
//            // enable flag to force update products
//            //  .get().setForceUpdate(true)
//        }
//    }
}