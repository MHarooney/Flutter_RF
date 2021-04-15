package com.live.flutter_plugin_rf_rn.model.stations

import java.io.Serializable

class NRStation : Serializable {
    private var nci: String = ""
    private var tac: String = ""
    private var pci: String = ""

    //signal
    private var csiRsrp: String = ""
    private var csiRsrq: String = ""
    private var csiSinr: String = ""
    private var ssRsrp: String = ""
    private var ssRsrq: String = ""
    private var ssSinr: String = ""
}