package com.alikhalil.demo1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        Toast.makeText(context, "Broadcast received", Toast.LENGTH_SHORT).show()
    }
}