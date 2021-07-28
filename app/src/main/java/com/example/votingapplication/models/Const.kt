package com.example.votingapplication.models

import android.app.Application

public class Const {

     var host:String = "http://192.168.8.187:49814"

    fun GetBASEURL(): String {
        return this.host;
    }
}