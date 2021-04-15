package com.live.flutter_plugin_rf_rn.model.stations

import java.io.Serializable

class GSMStation : Serializable {
    private var cid = ""
    private var lac = ""
    private var bsic = ""

    // signal
    private var rssi = ""
    private var bitErrorRate = ""
    private var timingAdvance = ""
}