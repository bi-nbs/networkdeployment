import Model.Backend.DistributionDeviceDAO
import Model.Backend.MySQL.MySQLHandler
import Model.DistributionDevice
import Model.IPv4

class MetaFunClass {



}

fun main(args : Array<String>){

    val DAO : DistributionDeviceDAO = DistributionDeviceDAO.getInstance()

    println("GET BEGINS")
    println(DAO.get(4).toString())
    println("GET ENDS")

    println("GETALL BEGINS")
    DAO.getAll().forEach { println(it.toString()) }
    println("GETALL ENDS")

    println("GETBYIP BEGIN: 10.0.42.1")
    DAO.getByIP(IPv4(10, 0, 42, 1))
    println("GETBYIP ENDS")

    println(MySQLHandler.url);

    val newDevice = DAO.create(DistributionDevice(iPv4 = IPv4(192, 168, 32, 11)))
    val updateDevice = DistributionDevice(newDevice.id, IPv4(10, 0, 0, 0))

    DAO.update(updateDevice)



}