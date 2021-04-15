package com.live.flutter_plugin_rf_rn.model.stations

import java.io.Serializable

class WCDMAStation : Serializable {
    private var ci: String = ""
    private var rnc: String = ""
    private var cid: String = ""
    private var lac: String = ""
    private var psc: String = ""

    //signal
    private var rssi: String = ""
    private var bitErrorRate: String = ""
    private var rscp: String = ""
    private var ecio: String = ""
    private var ecno: String = ""
}