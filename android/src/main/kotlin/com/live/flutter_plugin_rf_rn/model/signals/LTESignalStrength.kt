package com.live.flutter_plugin_rf_rn.model.signals

import java.io.Serializable

class LTESignalStrength : Serializable {
    private var rsrq: Int = 0
    private var rssi: Int = 0
    private var rssnr: Int = 0
    private var rsrp: Int = 0
    private var cqi: Int = 0
    private var dbm: Int = 0
    private var asuLevel: Int = 0
    private var signalLevel: Int = 0
    private var timingAdvance: Int = 0
    public override fun toString(): String {
        return ("LTESignalStrength{" +
                "signalLevel=" + signalLevel +
                ", rsrq=" + rsrq +
                ", rssi=" + rssi +
                ", rssnr=" + rssnr +
                ", rsrp=" + rsrp +
                ", cqi=" + cqi +
                ", dbm=" + dbm +
                ", asuLevel=" + asuLevel +
                ", timingAdvance=" + timingAdvance +
                '}'.toString())
    }
}