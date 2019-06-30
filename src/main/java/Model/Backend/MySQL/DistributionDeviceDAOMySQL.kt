package Model.Backend.MySQL

import Model.Backend.DistributionDeviceDAO
import Model.Backend.MySQL.Generated.networkdeployment.Tables.*
import Model.DistributionDevice
import Model.IPv4
import org.jooq.Record
import org.jooq.Result
import org.jooq.types.UByte


internal class DistributionDeviceDAOMySQL : DistributionDeviceDAO() {

    override fun getByIP(ip: IPv4): DistributionDevice {
        val results : Result<Record> = DSLHandler.getContext()
            .select()
            .from(DISTRIBUTIONDEVICE)
            .where(DISTRIBUTIONDEVICE.IPV4OCT1.eq(UByte.valueOf(ip.IPV4OCT1)))
            .and(DISTRIBUTIONDEVICE.IPV4OCT2.eq(UByte.valueOf(ip.IPV4OCT2)))
            .and(DISTRIBUTIONDEVICE.IPV4OCT3.eq(UByte.valueOf(ip.IPV4OCT3)))
            .and(DISTRIBUTIONDEVICE.IPV4OCT4.eq(UByte.valueOf(ip.IPV4OCT4)))
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
        val results = DSLHandler.getContext()
            .insertInto(DISTRIBUTIONDEVICE, DISTRIBUTIONDEVICE.IPV4OCT1, DISTRIBUTIONDEVICE.IPV4OCT2, DISTRIBUTIONDEVICE.IPV4OCT3, DISTRIBUTIONDEVICE.IPV4OCT4)
            .values(
                    UByte.valueOf(t.iPv4.IPV4OCT1),
                    UByte.valueOf(t.iPv4.IPV4OCT2),
                    UByte.valueOf(t.iPv4.IPV4OCT3),
                    UByte.valueOf(t.iPv4.IPV4OCT4))
            .returning(DISTRIBUTIONDEVICE.ID)
            .fetch()

        return this.get(results.getValue(0, DISTRIBUTIONDEVICE.ID))
    }

    override fun getAll(): List<DistributionDevice> {
        val results : Result<Record> = DSLHandler.getContext().select().from(DISTRIBUTIONDEVICE).limit(1000).fetch()

        return this.buildAllObjectsFromList(results)
    }

    override fun update(t: DistributionDevice) {
        DSLHandler.getContext()
            .update(DISTRIBUTIONDEVICE)
            .set(DISTRIBUTIONDEVICE.IPV4OCT1, UByte.valueOf(t.iPv4.IPV4OCT1))
            .set(DISTRIBUTIONDEVICE.IPV4OCT2, UByte.valueOf(t.iPv4.IPV4OCT2))
            .set(DISTRIBUTIONDEVICE.IPV4OCT3, UByte.valueOf(t.iPv4.IPV4OCT3))
            .set(DISTRIBUTIONDEVICE.IPV4OCT4, UByte.valueOf(t.iPv4.IPV4OCT4))
            .where(DISTRIBUTIONDEVICE.ID.eq(t.id))
            .execute();
    }

    override fun delete(id: Int) {
        DSLHandler.getContext()
            .deleteFrom(DISTRIBUTIONDEVICE)
            .where(DISTRIBUTIONDEVICE.ID.eq(id))
            .execute()
    }
    //CRUDS END




    //INTERNAL UTILITY
    fun buildAllObjectsFromList(results: Result<Record>) : List<DistributionDevice>{
        val returnList : MutableList<DistributionDevice> = ArrayList();

        for (result in results){

            val device = DistributionDevice(result.getValue(DISTRIBUTIONDEVICE.ID),
                    IPv4(
                    result.getValue(DISTRIBUTIONDEVICE.IPV4OCT1).toInt(),
                    result.getValue(DISTRIBUTIONDEVICE.IPV4OCT2).toInt(),
                    result.getValue(DISTRIBUTIONDEVICE.IPV4OCT3).toInt(),
                    result.getValue(DISTRIBUTIONDEVICE.IPV4OCT4).toInt()))

            returnList.add(device)
        }

        return returnList
    }

    fun buildSingleObjectFromList(results: Result<Record>) : DistributionDevice{

        val record: Record = results.get(0)


        return  DistributionDevice(record.getValue(DISTRIBUTIONDEVICE.ID),
                    IPv4(
                    record.getValue(DISTRIBUTIONDEVICE.IPV4OCT1).toInt(),
                    record.getValue(DISTRIBUTIONDEVICE.IPV4OCT2).toInt(),
                    record.getValue(DISTRIBUTIONDEVICE.IPV4OCT3).toInt(),
                    record.getValue(DISTRIBUTIONDEVICE.IPV4OCT4).toInt()))


    }
}