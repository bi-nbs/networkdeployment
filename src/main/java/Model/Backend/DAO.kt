package Model.Backend

interface DAO <T>{

    fun create(t : T) : T

    fun get(id : Int) : T

    fun getAll() : List<T>

    fun update(t : T)

    fun delete(id : Int)

}