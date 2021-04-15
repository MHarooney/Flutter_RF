package com.live.flutter_plugin_rf_rn.model.stations

import java.io.Serializable

class LTEStation : Serializable {
    private var freq: String = ""
    private var eci: String = ""
    private var eNb: String = ""
    private var cid: String = ""
    private var tac: String = ""
    private var pci: String = ""
    private var bw: String = ""

    // signal stringth
    private var rssi: String = ""
    private var rsrp: String = ""
    private var rsrq: String = ""
    private var cqi: String = ""
    private var ta: String = ""
    private var snr: String = ""
    fun geteNb(): String {
        return eNb
    }

    fun seteNb(eNb: String) {
        this.eNb = eNb
    }
}