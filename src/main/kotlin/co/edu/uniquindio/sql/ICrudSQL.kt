package co.edu.uniquindio.sql

import java.sql.SQLException

interface ICrudSQL {
    /**
     * Metodo que crea una tabla en la base de datos
     *
     * @param sentencia La sentencia de creacion de la tabla
     * @return Boolean true si se creo la tabla, false en caso contrario
     * @throws SQLException Una excepcion de tipo SQL
     */
    @Throws(SQLException::class)
    fun generarTabla(
        sentencia: String
    ): Boolean

    /**
     * Metodo que devuelve una lista de objetos de tipo dominio
     *
     * @param sentencia   Sentencia de sql. Ejemplo: select * from table
     * @param parametros  Parametros que se insertaran en las sentencia
     * @param propiedades Propiedades del objeto dominio que seran mapeadas con las columnas de la sentencia
     * @return Map<String, List<Object>> Listado de los resultados estructurados por columna
     * @throws SQLException Una excepcion de tipo SQL
    </Object> */
    @Throws(SQLException::class)
    fun consultarFilas(
        sentencia: String,
        propiedades: List<String>,
        parametros: List<Any?>
    ): Map<String, List<Any?>>

    /**
     * Metodo que devuelve un objeto de tipo dominio
     *
     * @param sentencia   Sentencia de sql. Ejemplo: select * from table limit 1
     * @param parametros  Parametros que se insertaran en las sentencia
     * @param propiedades Propiedades del objeto dominio que seran mapeadas con las columnas de la sentencia
     * @return Map<String, Object> Objeto resultado estructurado por columna
     * @throws SQLException Una excepcion de tipo SQL
     */
    @Throws(SQLException::class)
    fun consultarFila(
        sentencia: String,
        parametros: List<Any?>,
        propiedades: List<String>
    ): Map<String, Any?>

    /**
     * Metodo que actualiza los registros de la base de datos
     *
     * @param sentencia  Sentencia de sql: update table set columna=123
     * @param parametros Parametros que se insertaran en las setencia
     * @return Boolean      true si se actualizo, false en caso contrario
     * @throws SQLException Una excepcion de tipo SQL
     */
    @Throws(SQLException::class)
    fun actualizar(sentencia: String, parametros: List<Any?>): Boolean

    /**
     * Metodo que inserta nuevos registros en la base de datos
     *
     * @param sentencia  Sentencia de sql: insert into tabla (123)
     * @param parametros Parametros que se insertaran en las sentencia
     * @return Boolean      trus si se inserto, false en caso contrario
     * @throws SQLException Una excepcion de tipo SQL
     */
    @Throws(SQLException::class)
    fun insertar(sentencia: String, parametros: List<Any?>): Boolean

    /**
     * Eliminará registros de la base de datos
     *
     * @param sentencia  Sentencia de sql: delete from tabla
     * @param parametros Parametros que se insertaran en las sentencia
     * @return Boolean      true si se elimino, false en caso contrario
     * @throws SQLException Una excepcion de tipo SQL
     */
    @Throws(SQLException::class)
    fun eliminar(sentencia: String, parametros: List<Any?>): Boolean
}