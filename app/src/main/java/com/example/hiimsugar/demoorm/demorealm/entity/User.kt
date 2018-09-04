package com.example.hiimsugar.demoorm.demorealm.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField

var names: String = ""
open class User : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    @RealmField(name = "wdaw")
    var name: String = ""
}