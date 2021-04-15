package com.live.flutter_plugin_rf_rn.model.stations

import java.io.Serializable

// signal stringth
class CDMAStation : Serializable {
    private var sid: String = ""
    private var nid: String = ""
    private var bid: String = ""
    private var lat: String = ""
    private var lon: String = ""

    // signal strength
    var cdmaEcio: String = ""
    var cdmaRssi: String = ""
    var evdoEcio: String = ""
    var evdoRssi: String = ""
    var evdoSnr: String = ""
}