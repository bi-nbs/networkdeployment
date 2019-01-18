import Model.Backend.DistributionDeviceDAO
import Model.Backend.MySQL.MySQLHandler

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

    println(MySQLHandler.url);

}