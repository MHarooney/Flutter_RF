package com.live.flutter_plugin_rf_rn.model

import java.io.Serializable

class SIMInfo : Serializable {
    private var iccid: String = ""
    private var imei: String = ""
    private var imsi: String = ""
    private var operator: String = ""
    private var mnc: String = ""
    private var mcc: String = ""
    private var activeSIMSiz: Int = 0
}