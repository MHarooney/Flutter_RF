package com.live.flutter_plugin_rf_rn.net_monster

import java.io.Serializable

// signal stringth
class CDMAStation : Serializable {
    private var sid = ""
    private var nid = ""
    private var bid = ""
    private var lat = ""
    private var lon = ""

    // signal strength
    private var cdmaEcio = ""
    private var cdmaRssi = ""
    private var evdoEcio = ""
    private var evdoRssi = ""
    private var evdoSnr = ""
}