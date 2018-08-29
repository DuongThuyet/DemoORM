package com.example.hiimsugar.demoorm.demodbflow.dbflowdb

import com.raizlabs.android.dbflow.annotation.Database

@Database(name = DBFlowDB.NAME, version = DBFlowDB.VERSION)
object DBFlowDB {
    const val NAME = "MyDataBase"

    // only increment
    const val VERSION = 1
}