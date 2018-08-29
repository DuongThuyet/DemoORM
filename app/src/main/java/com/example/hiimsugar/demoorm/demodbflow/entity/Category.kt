package com.example.hiimsugar.demoorm.demodbflow.entity

import com.example.hiimsugar.demoorm.demodbflow.dbflowdb.DBFlowDB
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel

@Table(database = DBFlowDB::class)
class Category : BaseModel() {

    @Column
    @PrimaryKey(autoincrement = true)
    var id: Long = 0

    @Column
    var name: String = ""

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    var product = Product()

}