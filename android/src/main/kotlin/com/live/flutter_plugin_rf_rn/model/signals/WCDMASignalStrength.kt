package com.live.flutter_plugin_rf_rn.model.signals

import java.io.Serializable

class WCDMASignalStrength : Serializable {
    private var signalLevel: Int = 0
    private var dbm: Int = 0
    private var asuLevel: Int = 0
    private var ecNo: Int = 0
    public override fun toString(): String {
        return ("WCDMASignalStrength{" +
                "signalLevel=" + signalLevel +
                ", dbm=" + dbm +
                ", asuLevel=" + asuLevel +
                ", ecNo=" + ecNo +
                '}'.toString())
    }
}