package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Ciudad
import com.google.gson.Gson

object CiudadDAO : IDao<Ciudad>("Ciudad") {
    override fun generarTabla(): Boolean {
        PaisDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "pais INTEGER NOT NULL," +
                        "Constraint pk_$nombre Primary Key (id)," +
                        "Constraint fk_${nombre}_nacionalidad Foreign Key (pais) references Pais (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun insertar(entidad: Ciudad): Boolean {
        val gson = Gson()
        val json = gson.toJson(entidad)
        var map = emptyMap<String, Any>().toMutableMap()
        map = gson.fromJson(json, map.javaClass)

        val propiedades = ArrayList<String>()
        val parametros = ArrayList<Any>()

        for (item in map) {
            propiedades.add(item.key)
            if (item.key != "pais") {
                parametros.add(item.value)
            } else {
                parametros.add(entidad.pais.id)
            }
        }

        return insertar(propiedades, parametros)
    }
}