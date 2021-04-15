package com.live.flutter_plugin_rf_rn.model.stations

import java.io.Serializable

open class BaseStation : Serializable {
    private var type: String = "" // Signal type, GSM or WCDMA or LTE or CDMA or NR
    private var mcc: String = ""
    private var dbm: Int = 0
    private var mnc: String = ""
    private var iso: String = ""
    private var freq: String = ""
    private var isConnected: Boolean = false
    private var gsmStation = GSMStation()
    private var wcdmaStation = WCDMAStation()
    private var lteStation = LTEStation()
    private var nrStation = NRStation()
    private var tdscdmaStation = TDSCDMAStation()
    private var cdmaStation = CDMAStation()
}