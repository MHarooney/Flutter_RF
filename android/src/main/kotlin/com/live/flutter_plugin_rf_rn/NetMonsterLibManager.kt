package com.live.flutter_plugin_rf_rn

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.telephony.TelephonyManager
import android.util.Log
import androidx.core.app.ActivityCompat
import com.live.flutter_telephony_rf_example.net_monster.BaseStation
import com.live.flutter_telephony_rf_example.net_monster.LTEStation
import com.live.flutter_telephony_rf_example.net_monster.StationType
import cz.mroczis.netmonster.core.factory.NetMonsterFactory
import cz.mroczis.netmonster.core.model.cell.*
import cz.mroczis.netmonster.core.model.connection.PrimaryConnection
import java.util.*
import kotlin.collections.ArrayList

data class NetMonsterLibManager(private val activity: Context) {
    private val TAG = "NetMonsterLibManager"

    val cells: List<BaseStation>
        get() {
            if ((ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) || (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) || (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE)
                        != PackageManager.PERMISSION_GRANTED)) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return ArrayList()
            }

            val iCells = NetMonsterFactory.get(activity).getCells()

            Log.d(TAG, "NetMonsterFactoryCells: size " + iCells.size)

            val cellList: MutableList<BaseStation> = ArrayList()

            iCells.forEach { cell ->
                val station = BaseStation()
//                station.countryISO = getUserCountry(activity)
                cell.signal?.let { it ->
                    it.dbm?.let { dbm ->
                        station.dbm = dbm
                    }
                }

                cell.network?.let { it ->
                    it.iso?.let {
                        station.iso = it.toLowerCase()
                    }?: run{
                        station.iso
                    }
                    station.mnc = it.mnc
                    station.mcc = it.mcc
                }
                station.isConnected = cell.connectionStatus.javaClass.simpleName == PrimaryConnection::class.java.simpleName

                cell.band?.let { band ->
                    band.channelNumber.let { station.freq = ("$it (#${band.number}, ${band.name})") }
                }

                cell.let(object : ICellProcessor<Unit> {

                    override fun processLte(cell: CellLte) {

                        station.type = StationType.LTE.name

                        val lteStation = LTEStation()
                        station.lteStation = lteStation

                        cell.eci?.let { station.lteStation.eci = it.toString() }
                        cell.enb?.let { station.lteStation.seteNb(it.toString()) }
                        cell.cid?.let { station.lteStation.cid = it.toString() }
                        cell.tac?.let { station.lteStation.tac = it.toString() }
                        cell.pci?.let { station.lteStation.pci = it.toString() }
                        cell.bandwidth?.let { station.lteStation.bw = it.toString() }

                        cell.signal.let { signal ->
                            signal.rssi?.let { station.lteStation.rssi = it.toString() }
                            signal.rsrp?.let { station.lteStation.rsrp = it.toString() }
                            signal.rsrq?.let { station.lteStation.rsrq = it.toString() }
                            signal.cqi?.let { station.lteStation.cqi = it.toString() }
                            signal.timingAdvance?.let { station.lteStation.ta = it.toString() }
                            signal.snr?.let { station.lteStation.snr = it.toString() }
                        }

                        cell.band?.let { band ->
                            band.channelNumber.let { station.lteStation.freq = ("$it (#${band.number}, ${band.name})") }
                        }

                        cellList.add(station)


                    }

                    override fun processCdma(cell: CellCdma) {

                        station.type = StationType.CDMA.name

                        station.cdmaStation.sid = cell.sid.toString()

                        cell.nid?.let { station.cdmaStation.nid = it.toString() }
                        cell.bid?.let { station.cdmaStation.bid = it.toString() }
                        cell.lat?.let { station.cdmaStation.lat = it.toString() }
                        cell.lon?.let { station.cdmaStation.lon = it.toString() }

                        cell.signal.let { signal ->
                            signal.cdmaEcio?.let { station.cdmaStation.cdmaEcio = it.toString() }
                            signal.cdmaRssi?.let { station.cdmaStation.cdmaRssi = it.toString() }
                            signal.evdoEcio?.let { station.cdmaStation.evdoEcio = it.toString() }
                            signal.evdoRssi?.let { station.cdmaStation.evdoRssi = it.toString() }
                            signal.evdoSnr?.let { station.cdmaStation.evdoSnr = it.toString() }
                        }

                        cellList.add(station)

                    }

                    override fun processGsm(cell: CellGsm) {
                        station.type = StationType.GSM.name

                        cell.cid?.let { station.gsmStation.cid = it.toString() }
                        cell.lac?.let { station.gsmStation.lac = it.toString() }
                        cell.bsic?.let { station.gsmStation.bsic = it.toString() }

                        cell.signal.let { signal ->
                            signal.rssi?.let { station.gsmStation.rssi = it.toString() }
                            signal.bitErrorRate?.let { station.gsmStation.bitErrorRate = it.toString() }
                            signal.timingAdvance?.let { station.gsmStation.timingAdvance = it.toString() }
                        }

                        cellList.add(station)

                    }

                    override fun processNr(cell: CellNr) {
                        station.type = StationType.NR.name

                        cell.nci?.let { station.nrStation.nci = it.toString() }
                        cell.tac?.let { station.nrStation.tac = it.toString() }
                        cell.pci?.let { station.nrStation.pci = it.toString() }

                        cell.signal.let { signal ->
                            signal.csiRsrp?.let { station.nrStation.csiRsrp = it.toString() }
                            signal.csiRsrq?.let { station.nrStation.csiRsrq = it.toString() }
                            signal.csiSinr?.let { station.nrStation.csiSinr = it.toString() }
                            signal.ssRsrp?.let { station.nrStation.ssRsrp = it.toString() }
                            signal.ssRsrq?.let { station.nrStation.ssRsrq = it.toString() }
                            signal.ssSinr?.let { station.nrStation.ssSinr = it.toString() }
                        }

                        cellList.add(station)

                    }

                    override fun processTdscdma(cell: CellTdscdma) {
                        station.type = StationType.TDS_CDMA.name


                        cell.ci?.let { station.tdscdmaStation.ci = it.toString() }
                        cell.rnc?.let { station.tdscdmaStation.rnc = it.toString() }
                        cell.cid?.let { station.tdscdmaStation.cid = it.toString() }
                        cell.lac?.let { station.tdscdmaStation.lac = it.toString() }
                        cell.cpid?.let { station.tdscdmaStation.cpid = it.toString() }

                        cell.signal.let { signal ->
                            signal.rssi?.let { station.tdscdmaStation.rssi = it.toString() }
                            signal.bitErrorRate?.let { station.tdscdmaStation.bitErrorRate = it.toString() }
                            signal.rscp?.let { station.tdscdmaStation.rscp = it.toString() }
                        }

                        cellList.add(station)
                    }

                    override fun processWcdma(cell: CellWcdma) {
                        station.type = StationType.WCDMA.name

                        cell.ci?.let { station.wcdmaStation.ci = it.toString() }
                        cell.rnc?.let { station.wcdmaStation.rnc = it.toString() }
                        cell.cid?.let { station.wcdmaStation.cid = it.toString() }
                        cell.lac?.let { station.wcdmaStation.lac = it.toString() }
                        cell.psc?.let { station.wcdmaStation.psc = it.toString() }

                        cell.signal.let { signal ->
                            signal.rssi?.let { station.wcdmaStation.rssi = it.toString() }
                            signal.bitErrorRate?.let { station.wcdmaStation.bitErrorRate = it.toString() }
                            signal.rscp?.let { station.wcdmaStation.rscp = it.toString() }
                            signal.ecio?.let { station.wcdmaStation.ecio = it.toString() }
                            signal.ecno?.let { station.wcdmaStation.ecno = it.toString() }
                        }

                        cellList.add(station)
                    }

                })
            }
            return cellList
        }

    /**
     * Get ISO 3166-1 alpha-2 country code for this device (or null if not available)
     * @param context Context reference to get the TelephonyManager instance from
     * @return country code or null
     */
    fun getUserCountry(context: Context): String? {
        try {
            val tm = context.getSystemService(Application.TELEPHONY_SERVICE) as TelephonyManager
            val simCountry = tm.simCountryIso
            if (simCountry != null && simCountry.length == 2) { // SIM country code is available
                return simCountry.toLowerCase(Locale.US)
            } else if (tm.phoneType != TelephonyManager.PHONE_TYPE_CDMA) { // device is not 3G (would be unreliable)
                val networkCountry = tm.networkCountryIso
                if (networkCountry != null && networkCountry.length == 2) { // network country code is available
                    return networkCountry.toLowerCase(Locale.US)
                }
            }
        } catch (e: Exception) {
        }
        return null
    }

}