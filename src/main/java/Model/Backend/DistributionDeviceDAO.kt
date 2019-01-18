package Model.Backend

import Model.Backend.MySQL.DistributionDeviceDAOMySQL
import Model.DistributionDevice
import Model.IPv4

abstract class DistributionDeviceDAO : DAO<DistributionDevice>{

    abstract fun getByIP(ip: IPv4) : DistributionDevice


    companion object {

        private val singletonDao : DistributionDeviceDAO = DistributionDeviceDAOMySQL()

        fun getInstance() : DistributionDeviceDAO {return this.singletonDao}
    }
}