package com.live.flutter_plugin_rf_rn.net_monster

import com.live.flutter_plugin_rf_rn.model.SIMInfo
import com.live.flutter_plugin_rf_rn.net_monster.BaseStation
import java.io.Serializable
import java.util.ArrayList

class CellsResponse : Serializable {
    private var simInfoList: List<SIMInfo> = ArrayList<SIMInfo>()
    private var baseStationList: List<BaseStation> = ArrayList<BaseStation>()
}