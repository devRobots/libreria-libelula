package co.edu.uniquindio.dao

import co.edu.uniquindio.sql.SQLConnector

abstract class IDao<T> {
    protected var nombre: String? = null
    protected var propiedades: List<String>? = null
    protected val sqlConnector: SQLConnector = SQLConnector()

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
    abstract fun buscar(id: String): T?

    /**
     * Metodo para listar todos los objetos T de un a tabla
     *
     * @return List<T> Una lista con todos los objetos T de la tabla
    </T> */
    abstract fun listar(): List<T>?

    /**
     * Metodo para eliminar un objeto T de la tabla
     *
     * @param id El id del objeto que se desea eliminar
     * @return Boolean true si se elimino, false en caso contrario
     */
    abstract fun eliminar(id: String): Boolean

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
     * Metodo que construye la sentencia SQL de la insercion y la procesa
     *
     * @param parametros Los parametros que va a tener la tabla a generar
     * @return Boolean true si se creo la tabla exitosamente, false en caso contrario
     */
    protected fun generarTabla(parametros: List<String>): Boolean {
        var sentencia = "CREATE TABLE $nombre ("
        for (i in parametros.indices) {
            sentencia += propiedades!![i] + " " + parametros[i]
            sentencia += if (i < parametros.size - 1) "," else " )"
        }
        return try {
            sqlConnector.generarTabla(sentencia)
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Metodo que busca un objeto determinado
     *
     * @param tabla La tabla en la que se quiere buscar
     * @param parametros Los parametros que se quieren usar en la busqueda
     * @return Map<String></String>, Object> una representacion del objeto en formato Map
     */
    protected fun buscar(
        tabla: String,
        parametros: List<String?>
    ): Map<String, Any?>? {
        return try {
            val sentencia = "SELECT * FROM $tabla WHERE "
            sqlConnector.consultarFila(sentencia, parametros, propiedades!!)
        } catch (ex: Exception) {
            null
        }
    }

    /**
     * Metodo que construye la sentencia SQL de la insercion y la procesa
     *
     * @param tabla La tabla en la que se quiere insertar
     * @param parametros Los parametros que va a tener la fila a insertar
     * @return Boolean true si se inserto exitosamente, false en caso contrario
     */
    protected fun insertar(tabla: String, parametros: List<String?>): Boolean {
        var sentencia = "INSERT INTO $tabla"
        sentencia += "VALUES ( "
        for (i in parametros.indices) {
            sentencia += if (i < parametros.size - 2) "?, " else ')'
        }
        return try {
            sqlConnector.insertar(sentencia, parametros)
        } catch (ex: Exception) {
            false
        }
    }
}