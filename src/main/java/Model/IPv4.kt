package Model

open class IPv4 constructor(val IPV4OCT1 : Int,
                       val IPV4OCT2 : Int,
                       val IPV4OCT3 : Int,
                       val IPV4OCT4 : Int) {

    override fun toString(): String {
        return "IPv4(IP=$IPV4OCT1.$IPV4OCT2.$IPV4OCT3.$IPV4OCT4)"
    }
}