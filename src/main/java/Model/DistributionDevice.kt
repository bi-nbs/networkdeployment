package Model

data class DistributionDevice constructor(val id : Int = 0, val iPv4: IPv4){


    override fun toString(): String {
        return "DistributionDevice(id=$id, iPv4=$iPv4)"
    }
}