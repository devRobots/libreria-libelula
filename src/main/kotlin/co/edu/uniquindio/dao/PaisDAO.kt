package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Pais
import kotlin.collections.ArrayList

object PaisDAO : IDao<Pais>("Pais") {
    override fun generarTabla(): Boolean {
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "Constraint pk_$nombre Primary Key (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun insertar(entidad: Pais): Boolean {
        val propiedades = obtenerAtributosClase(Pais::class) as ArrayList<String>
        propiedades.remove("id")
        propiedades.remove("ciudades")

        val parametros = arrayListOf(
            entidad.nombre
        )

        return insertar(propiedades, parametros)
    }
}