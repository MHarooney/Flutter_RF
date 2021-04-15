package com.live.flutter_plugin_rf_rn.model

import com.live.flutter_plugin_rf_rn.net_monster.BaseStation

class NRStation : BaseStation() {
    private val arfcn: Int = 0 // Absolute RF Channel Number (or UMTS Absolute RF Channel Number for WCDMA)
    private val bsic_psc_pci: Int = 0 /* bsic for GSM, psc for WCDMA, pci for LTE,
 GSM has #getPsc() but always get Integer.MAX_VALUE,
 psc is undefined for GSM */
}