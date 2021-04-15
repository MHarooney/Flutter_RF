package com.live.flutter_plugin_rf_rn.net_monster

import java.io.Serializable

class TDSCDMAStation : Serializable {
    private var ci = ""
    private var rnc = ""
    private var cid = ""
    private var lac = ""
    private var cpid = ""

    //signal
    private var rssi = ""
    private var bitErrorRate = ""
    private var rscp = ""
}