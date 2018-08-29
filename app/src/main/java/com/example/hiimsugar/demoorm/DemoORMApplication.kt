package com.example.hiimsugar.demoorm

import android.app.Application
import io.realm.Realm

class DemoORMApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this);
    }
}