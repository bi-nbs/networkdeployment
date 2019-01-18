package Model.Backend.MySQL

import java.sql.Connection
import java.sql.DriverManager

object MySQLHandler {

    val userName : String = "networkdeployment";
    val password : String = "84DkH#J9Bb4X";
    val database : String = "networkdeployment";
    val ip : String = "192.168.223.21";
    val port : Int = 3306;
    val url = "jdbc:mysql://" + this.ip + ":" + this.port + "/" + this.database + "?serverTimezone=Europe/Copenhagen&useUnicode=yes&characterEncoding=UTF-8";


    fun getConnection(): Connection {

        return DriverManager.getConnection(this.url, userName, password)

    }
}