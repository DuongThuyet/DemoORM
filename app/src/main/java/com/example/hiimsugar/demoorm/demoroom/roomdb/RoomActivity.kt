package com.example.hiimsugar.demoorm.demoroom.roomdb

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.migration.Migration
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.hiimsugar.demoorm.R
import com.example.hiimsugar.demoorm.demoroom.enitity.Product
import kotlinx.android.synthetic.main.activity_main.*


class RoomActivity : AppCompatActivity() {
    private val ROOM_SUGAR_DB: String = "ROOM_SUGAR_DB"
    /*val database = Room.databaseBuilder(applicationContext, RoomDB::class.java, ROOM_SUGAR_DB)
            .addMigrations(object : Migration(1, 2) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("ALTER TABLE product " + " ADD COLUMN price INTEGER")
                }
            })
            .build()*/
    lateinit var database: RoomDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(applicationContext, RoomDB::class.java, ROOM_SUGAR_DB)
                .addMigrations(object : Migration(1,2) {
                    override fun migrate(database: SupportSQLiteDatabase) {

                    }

                })
                .build()

        val product1 = Product()
        product1.name = "product1"
        product1.imageUrl = ""
        val product2 = Product()
        product2.name = "product2"
        product2.imageUrl = ""
        val product3 = Product()
        product3.name = "product3"
        product3.imageUrl = ""
        val product4 = Product()
        product4.name = "product4"
        product4.imageUrl = ""


        val list = listOf(product1, product2, product3, product4)

        tvQuery.setOnClickListener {
            object : AsyncTask<String, String, Product>() {
                override fun doInBackground(vararg params: String?): Product {
                    val s = database.productDao().all
                    return s[1]
                }

                override fun onPostExecute(result: Product?) {
                    result?.let {
                        UpdateUI(result)
                    }
                }
            }.execute("")
            Log.d("clickQuery", "Queried")
        }
        tvInsert.setOnClickListener {
            Thread(Runnable {
                database.productDao().insertAll(list)
                Log.d("clickToInsert", "Inserted")
                UpdateUI(list[0])
            }).start()

        }
        tvUpdate.setOnClickListener {
            Log.d("clickToUpdate", "Updated")
        }
        tvSearch.setOnClickListener {
            Log.d("clickToSearch", "Searched")
        }

        tvDellAll.setOnClickListener {
            object : AsyncTask<Void, Void, Void>() {
                override fun doInBackground(vararg params: Void?): Void? {
                    val xItem = database.productDao().all
                    database.productDao().delete(xItem[0])
                    return null
                }
            }.execute()
        }

        tvMigtation.setOnClickListener {
            database = Room.databaseBuilder(applicationContext, RoomDB::class.java, ROOM_SUGAR_DB)
                    .addMigrations(object : Migration(2, 3) {
                        override fun migrate(database: SupportSQLiteDatabase) {
                            database.execSQL("ALTER TABLE product1 " + " ADD COLUMN price INTEGER")
                        }
                    })
                    .build()
            Log.d("Migtation", "Migtationed")
        }
    }

    private fun UpdateUI(product: Product) {
        runOnUiThread {
            data.text = product.name.toString()
        }
    }
}
