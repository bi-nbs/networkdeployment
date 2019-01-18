package Model.Backend.MySQL

import Model.Backend.DistributionDeviceDAO
import Model.Backend.MySQL.Generated.networkdeployment.Tables.*
import Model.DistributionDevice
import Model.IPv4
import org.jooq.Record
import org.jooq.Result


internal class DistributionDeviceDAOMySQL : DistributionDeviceDAO() {

    override fun getByIP(ip: IPv4): DistributionDevice {
        val results : Result<Record> = DSLHandler.getContext()
            .select()
            .from(DISTRIBUTIONDEVICE)
            .where(DISTRIBUTIONDEVICE.IPV4OCT1.eq(ip.IPV4OCT1.toByte()))
            .fetch()

        return this.buildSingleObjectFromList(results)
    }


    //CRUDS BEGIN
    override fun get(id: Int): DistributionDevice {
        val results : Result<Record> = DSLHandler.getContext()
            .select()
            .from(DISTRIBUTIONDEVICE)
            .where(DISTRIBUTIONDEVICE.ID.eq(id))
            .fetch()

        return this.buildSingleObjectFromList(results)
    }

    override fun create(t: DistributionDevice): DistributionDevice {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(): List<DistributionDevice> {
        val results : Result<Record> = DSLHandler.getContext().select().from(DISTRIBUTIONDEVICE).limit(1000).fetch()

        return this.buildAllObjectsFromList(results)
    }

    override fun update(t: DistributionDevice) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    //CRUDS END




    //INTERNAL UTILITY
    fun buildAllObjectsFromList(results: Result<Record>) : List<DistributionDevice>{
        val returnList : MutableList<DistributionDevice> = ArrayList();

        for (result in results){

            val device : DistributionDevice = DistributionDevice(result.getValue(DISTRIBUTIONDEVICE.ID),
                                                                    IPv4(
                                                                    result.getValue(DISTRIBUTIONDEVICE.IPV4OCT1),
                                                                    result.getValue(DISTRIBUTIONDEVICE.IPV4OCT2),
                                                                    result.getValue(DISTRIBUTIONDEVICE.IPV4OCT3),
                                                                    result.getValue(DISTRIBUTIONDEVICE.IPV4OCT4)))

            returnList.add(device)
        }

        return returnList
    }

    fun buildSingleObjectFromList(results: Result<Record>) : DistributionDevice{

        val record: Record = results.get(0)


        return  DistributionDevice(record.getValue(DISTRIBUTIONDEVICE.ID),
                                        IPv4(
                                        record.getValue(DISTRIBUTIONDEVICE.IPV4OCT1),
                                        record.getValue(DISTRIBUTIONDEVICE.IPV4OCT2),
                                        record.getValue(DISTRIBUTIONDEVICE.IPV4OCT3),
                                        record.getValue(DISTRIBUTIONDEVICE.IPV4OCT4)))


    }
}