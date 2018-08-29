package com.example.hiimsugar.demoorm.demodbflow.entity

import com.example.hiimsugar.demoorm.demodbflow.dbflowdb.DBFlowDB
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel

@Table(database = DBFlowDB::class)
class Product : BaseModel() {
    // You must define at least one column to be the primary key
    @Column
    @PrimaryKey(autoincrement = true)
    var uid: Int = 0

    @Column
    var name: String = ""

    @Column
    var imageUrl: String? = ""
}