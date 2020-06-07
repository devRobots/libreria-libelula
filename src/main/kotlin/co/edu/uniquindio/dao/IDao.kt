package co.edu.uniquindio.dao

import co.edu.uniquindio.sql.SQLConnector
import kotlin.reflect.*
import kotlin.reflect.full.memberProperties

abstract class IDao<T : Any>(protected val nombre: String) {
    protected val sqlConnector = SQLConnector

    /**
     * Metodo para generar la tabla de los objetos T
     */
    abstract fun generarTabla(): Boolean

    /**
     * Metodo para buscar un objeto T a partir de su id
     *
     * @param id El id del ojeto T
     * @return T el objeto hallado, null en caso contrario
     */
    abstract fun buscar(id: Int): T?

    /**
     * Metodo para listar todos los objetos T de un a tabla
     *
     * @return List<T> Una lista con todos los objetos T de la tabla
    </T> */
    abstract fun listar(): List<T>

    /**
     * Metodo para eliminar un objeto T de la tabla
     *
     * @param id El id del objeto que se desea eliminar
     * @return Boolean true si se elimino, false en caso contrario
     */
    abstract fun eliminar(id: Int): Boolean

    /**
     * Metodo para modificar un objeto T de la tabla
     *
     * @param nuevaEntidad La entidad con la nueva informacion
     * @return Boolean true si se modifico, false en caso contrario
     */
    abstract fun actualizar(nuevaEntidad: T): Boolean

    /**
     * Metodo para insertar un objeto T en la tabla
     *
     * @param entidad La entidad que se desea agregar a la tabla
     * @return Boolean true si se inserto, false en caso contrario
     */
    abstract fun insertar(entidad: T): Boolean

    /**
     * Metodo que construye la sentencia SQL de la eliminacion y la procesa
     *
     * @param columna El nombre de la columna por la que se quiere eliminar
     * @param valor El valor de la columna por el que se quiere eliminar
     * @return Boolean true si se elimino exitosamente, false en caso contrario
     */
    protected fun eliminar(columna: String, valor: Int): Boolean {
        val sentencia = "DELETE FROM $nombre WHERE $columna = ?"
        val valores = arrayListOf(valor)
        return try {
            sqlConnector.eliminar(sentencia, valores)
        } catch (ex: Exception) {
            false
        }
    }

    /**
     * Metodo que construye la sentencia SQL de la insercion y la procesa
     *
     * @param parametros Los parametros que va a tener la fila a insertar
     * @return Boolean true si se inserto exitosamente, false en caso contrario
     */
    protected fun insertar(propiedades: List<String>, parametros: List<String>): Boolean {
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

        return atributos
    }
}
