package com.example.hiimsugar.demoorm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.hiimsugar.demoorm.demodbflow.DemoDBFlow
import com.example.hiimsugar.demoorm.demorealm.RealmActivity
import com.example.hiimsugar.demoorm.demoroom.roomdb.RoomActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        tvRoom.setOnClickListener {
            startActivity(Intent(this,RoomActivity::class.java))
        }
        tvDBFlow.setOnClickListener {
            startActivity(Intent(this,DemoDBFlow::class.java))
        }
        tvRealm.setOnClickListener {
            startActivity(Intent(this,RealmActivity::class.java))
        }
    }
}
