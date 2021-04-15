package com.live.flutter_plugin_rf_rn.model.signals

import java.io.Serializable

class NRSignalStrength : Serializable {
    private var signalLevel: Int = 0
    private var dbm: Int = 0
    private var asuLevel: Int = 0
    public override fun toString(): String {
        return ("NRSignalStrength{" +
                "signalLevel=" + signalLevel +
                ", dbm=" + dbm +
                ", asuLevel=" + asuLevel +
                '}'.toString())
    }
}