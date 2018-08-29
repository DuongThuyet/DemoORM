package com.example.hiimsugar.demoorm.demorealm.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var name: String = ""
}