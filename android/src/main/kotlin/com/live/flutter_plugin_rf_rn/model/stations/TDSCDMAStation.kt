package com.live.flutter_plugin_rf_rn.model.stations

import java.io.Serializable

class TDSCDMAStation : Serializable {
    private var ci: String = ""
    private var rnc: String = ""
    private var cid: String = ""
    private var lac: String = ""
    private var cpid: String = ""

    //signal
    private var rssi: String = ""
    private var bitErrorRate: String = ""
    private var rscp: String = ""
}