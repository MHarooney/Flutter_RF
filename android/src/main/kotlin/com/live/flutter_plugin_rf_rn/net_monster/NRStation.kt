package com.live.flutter_plugin_rf_rn.net_monster

import java.io.Serializable

class NRStation : Serializable {
    private var nci = ""
    private var tac = ""
    private var pci = ""

    //signal
    private var csiRsrp = ""
    private var csiRsrq = ""
    private var csiSinr = ""
    private var ssRsrp = ""
    private var ssRsrq = ""
    private var ssSinr = ""
}