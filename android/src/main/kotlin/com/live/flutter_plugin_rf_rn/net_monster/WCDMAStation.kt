package com.live.flutter_plugin_rf_rn.net_monster

import java.io.Serializable

class WCDMAStation : Serializable {
    private var ci = ""
    private var rnc = ""
    private var cid = ""
    private var lac = ""
    private var psc = ""

    //signal
    private var rssi = ""
    private var bitErrorRate = ""
    private var rscp = ""
    private var ecio = ""
    private var ecno = ""
}