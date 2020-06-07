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
                        "Constraint pk_pais Primary Key (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: Int): Pais? {
        return null
    }

    override fun listar(): List<Pais> {
        return try {
            val propiedades = arrayListOf(
                "id", "nombre"
            )
            val listado = sqlConnector.consultarFilas(
                "SELECT * FROM Pais;",
                propiedades,
                emptyList<Any?>()
            )

            val salida = ArrayList<Pais>()
            for (pais in listado) {
                val id = pais.value[0] as Int
                val nombre = pais.value[1] as String

                salida.add(Pais(id, nombre))
            }

            salida
        } catch (ex: Exception) {
            emptyList()
        }
    }

    override fun eliminar(id: Int): Boolean {
        return eliminar("id", id)
    }

    override fun actualizar(nuevaEntidad: Pais): Boolean {
        return false
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