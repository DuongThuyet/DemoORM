package com.example.hiimsugar.demoorm.demorealm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.hiimsugar.demoorm.R
import com.example.hiimsugar.demoorm.demorealm.entity.User
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_realm.*




class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)
        // Get a Realm instance for this thread
        val realm = Realm.getDefaultInstance()
        tvInserts.setOnClickListener {
            realm.beginTransaction()
            val user = realm.createObject(User::class.java, 1)
            user.name = "Abc"
            val user2 = realm.createObject(User::class.java, 2)
            user2.name = "Xyz"
            val user3 = realm.createObject(User::class.java, 3)
            user3.name = "Mmo"
            realm.commitTransaction()
            tvInserts.isClickable = false
            val persons = realm.where(User::class.java).findAll()
            persons[0]?.name?.let { it1 -> upDateUI(it1) }
        }

        tvDelete.setOnClickListener {
            val results = realm.where(User::class.java).findAll()
            realm.beginTransaction()
            results.deleteFromRealm(0)
            realm.commitTransaction()
            val persons = realm.where(User::class.java).findAll()
            persons[0]?.name?.let { it1 -> upDateUI(it1) }
        }

        tvUpdate.setOnClickListener {
            realm.executeTransaction {
                val s = realm.where(User::class.java)
                        .equalTo("name","Abc")
                        .findFirst()
                s?.let { s.name = "Abcd"
                upDateUI(s.name)}
            }
        }
    }

    private fun upDateUI(s: String) {
        tvData.text = s
    }
}


