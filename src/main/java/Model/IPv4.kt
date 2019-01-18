package Model

data class IPv4 constructor(val IPV4OCT1 : Number,
                            val IPV4OCT2 : Number,
                            val IPV4OCT3 : Number,
                            val IPV4OCT4 : Number) {

    override fun toString(): String {
        return "IPv4(IP=$IPV4OCT1.$IPV4OCT2.$IPV4OCT3.$IPV4OCT4)"
    }
}