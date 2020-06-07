package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Entidad
import co.edu.uniquindio.sql.SQLConnector
import com.google.gson.Gson
import kotlin.reflect.*
import kotlin.reflect.full.memberProperties

open class IDao<T : Entidad>(protected val nombre: String) {
    protected val sqlConnector = SQLConnector

    /**
     * Metodo para generar la tabla de los objetos T
     */
    open fun generarTabla(): Boolean {
        return false
    }

    /**
     * Metodo para buscar un objeto T a partir de su id
     *
     * @param id El id del ojeto T
     * @return T el objeto hallado, null en caso contrario
     */
    open fun buscar(id: Int, clase: KClass<T>, omitir: List<String> = emptyList()): T? {
        val sentencia = "SELECT * FROM $nombre WHERE id = ?"
        val propiedades = obtenerAtributosClase(clase) as ArrayList
        for (omision in omitir) {
            propiedades.remove(omision)
        }
        val atributos = arrayListOf(id)

        return try {
            val map = sqlConnector.consultarFila(sentencia, propiedades, atributos)
            val gson = Gson()
            val json = gson.toJson(map).toString()
            gson.fromJson(json, clase.java)
        } catch (ex: Exception) {
            null
        }
    }

    /**
     * Metodo para listar todos los objetos T de un a tabla
     *
     * @return List<T> Una lista con todos los objetos T de la tabla
     */
    open fun listar(clase: KClass<T>, omitir: List<String> = emptyList()): List<T> {
        val sentencia = "SELECT * FROM $nombre"
        val propiedades = obtenerAtributosClase(clase) as ArrayList
        for (omision in omitir) {
            propiedades.remove(omision)
        }

        val todos = ArrayList<T>()
        try {
            val lista = sqlConnector.consultarFilas(sentencia, propiedades, emptyList())

            for (map in lista) {
                val gson = Gson()
                val json = gson.toJson(map).toString()
                val objeto: T = gson.fromJson(json, clase.java)
                todos.add(objeto)
            }

        } catch (ex: Exception) {
        }
        return todos
    }

    /**
     * Metodo para eliminar un objeto T de la tabla
     *
     * @param id El id del objeto que se desea eliminar
     * @return Boolean true si se elimino, false en caso contrario
     */
    open fun eliminar(id: Int): Boolean {
        val sentencia = "DELETE FROM $nombre WHERE id = ?"
        val valores = arrayListOf(id)
        return try {
            sqlConnector.eliminar(sentencia, valores)
        } catch (ex: Exception) {
            false
        }
    }

    /**
     * Metodo para modificar un objeto T de la tabla
     *
     * @param nuevaEntidad La entidad con la nueva informacion
     * @return Boolean true si se modifico, false en caso contrario
     */
    open fun actualizar(nuevaEntidad: T): Boolean {
        val eliminado = eliminar(nuevaEntidad.id)
        return if (eliminado) insertar(nuevaEntidad) else false
    }

    /**
     * Metodo para insertar un objeto T en la tabla
     *
     * @param entidad La entidad que se desea agregar a la tabla
     * @return Boolean true si se inserto, false en caso contrario
     */
    open fun insertar(entidad: T): Boolean {
        val gson = Gson()
        val json = gson.toJson(entidad)
        var map = emptyMap<String, Any>().toMutableMap()
        map = gson.fromJson(json, map.javaClass)

        val propiedades = ArrayList<String>()
        val parametros = ArrayList<Any>()

        for (item in map) {
            propiedades.add(item.key)
            parametros.add(item.value)
        }

        return insertar(propiedades, parametros)
    }

    /**
     * Metodo que construye la sentencia SQL de la insercion y la procesa
     *
     * @param parametros Los parametros que va a tener la fila a insertar
     * @return Boolean true si se inserto exitosamente, false en caso contrario
     */
    protected fun insertar(propiedades: List<String>, parametros: List<Any>): Boolean {
        var sentencia = "INSERT INTO $nombre ("
        for (i in propiedades.indices) {
            sentencia += propiedades[i] + if (i < parametros.size - 1) ", " else ")"
        }
        sentencia += "VALUES ("
        for (i in parametros.indices) {
            sentencia += "?" + if (i < parametros.size - 1) ", " else ")"
        }
        return try {
            sqlConnector.insertar(sentencia, parametros)
        } catch (ex: Exception) {
            false
        }
    }

    /**
     * Metodo que obtiene todos los atributos de una clase
     *
     * @param clase La clase de la que se quieren extraer los atributos
     * @return List<String> Lista con los nombres de los atributos que contiene la clase
     */
    protected fun obtenerAtributosClase(clase: KClass<T>): List<String> {
        val atributos = ArrayList<String>()

        val atributosTmp = clase.memberProperties
        for (atributo in atributosTmp) {
            atributos.add(atributo.name)
        }

        atributos.sort()
        return atributos
    }
}
