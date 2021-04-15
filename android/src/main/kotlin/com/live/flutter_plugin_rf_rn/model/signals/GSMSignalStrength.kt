package com.live.flutter_plugin_rf_rn.model.signals

import java.io.Serializable

class GSMSignalStrength : Serializable {
    private var rssi: Int = 0
    private var dbm: Int = 0
    private var signalLevel: Int = 0
    private var asuLevel: Int = 0
    public override fun toString(): String {
        return ("GSMSignalStrength{" +
                "rssi=" + rssi +
                ", dbm=" + dbm +
                ", signalLevel=" + signalLevel +
                ", asuLevel=" + asuLevel +
                '}'.toString())
    }
}