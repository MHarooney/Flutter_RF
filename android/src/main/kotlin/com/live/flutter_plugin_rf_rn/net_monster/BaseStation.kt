package com.live.flutter_plugin_rf_rn.net_monster

import com.live.flutter_plugin_rf_rn.model.NRStation
import java.io.Serializable

class BaseStation : Serializable {
    private var type = "" // Signal type, GSM or WCDMA or LTE or CDMA or NR
    private var mcc = ""
    private var dbm = 0
    private var mnc = ""
    private var iso = ""
    private var freq = ""
    private var isConnected: Boolean = false
    private var gsmStation = GSMStation()
    private var wcdmaStation = WCDMAStation()
    private var lteStation = LTEStation()
    private var nrStation = NRStation()
    private var tdscdmaStation = TDSCDMAStation()
    private var cdmaStation = CDMAStation()
    public override fun toString(): String {
        return ("BaseStation{" +
                "type='" + type + '\''.toString() +
                ", mcc='" + mcc + '\''.toString() +
                ", dbm=" + dbm +
                ", mnc='" + mnc + '\''.toString() +
                ", iso='" + iso + '\''.toString() +
                ", freq='" + freq + '\''.toString() +
                ", connected=" + isConnected +
                ", gsmStation=" + gsmStation +
                ", wcdmaStation=" + wcdmaStation +
                ", lteStation=" + lteStation +
                ", nrStation=" + nrStation +
                ", tdscdmaStation=" + tdscdmaStation +
                ", cdmaStation=" + cdmaStation +
                '}'.toString())
    }
}