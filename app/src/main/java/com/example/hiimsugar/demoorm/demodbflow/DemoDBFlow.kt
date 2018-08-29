package com.example.hiimsugar.demoorm.demodbflow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.hiimsugar.demoorm.R
import com.example.hiimsugar.demoorm.demodbflow.entity.Category
import com.example.hiimsugar.demoorm.demodbflow.entity.Product
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.sql.language.SQLite
import kotlinx.android.synthetic.main.activity_demo_dbflow.*


class DemoDBFlow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_dbflow)
        FlowManager.init(FlowConfig.Builder(this).build())

        var product1 = Product()
        product1.name = "product1"
        product1.save()

        var product2 = Product()
        product2.name = "product2"
        product2.save()

        var product3 = Product()
        product3.name = "product3"
        product3.save()

        var itemCategory = Category()
        itemCategory.name = "cateDemo"
        itemCategory.product = product1

        var itemCategory1 = Category()
        itemCategory1.name = "cateDemo1"
        itemCategory1.product = product2

//        var itemCategory2 = Category()
//        itemCategory.name = "cateDemo2"
//        itemCategory.product = product2
//
//        var itemCategory3 = Category()
//        itemCategory.name = "cateDemo3"
//        itemCategory.product = product3


        itemCategory.save()
        itemCategory1.save()
        itemCategory.delete()
        tvInsert.setOnClickListener {
            var item = SQLite.select()
                    .from(Category::class.java)
                    .queryList()
            updateUI(item[0].name)
        }
        tvDel.setOnClickListener {
            itemCategory.delete()
            var item = SQLite.select()
                    .from(Category::class.java)
                    .queryList()
            updateUI(item[0].name)
        }
    }

    private fun updateUI(text: String) {
        DataTrans.text = text
    }
}
