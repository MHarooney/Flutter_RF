package com.live.flutter_plugin_rf_rn.net_monster

import java.io.Serializable

class LTEStation : Serializable {
    private var freq = ""
    private var eci = ""
    private var eNb = ""
    private var cid = ""
    private var tac = ""
    private var pci = ""
    private var bw = ""

    // signal stringth
    private var rssi = ""
    private var rsrp = ""
    private var rsrq = ""
    private var cqi = ""
    private var ta = ""
    private var snr = ""
    fun geteNb(): String {
        return eNb
    }

    fun seteNb(eNb: String) {
        this.eNb = eNb
    }
}