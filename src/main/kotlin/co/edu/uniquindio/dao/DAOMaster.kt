package co.edu.uniquindio.dao

import co.edu.uniquindio.sql.SQLConnector

object DAOMaster {
    val sqlConnector = SQLConnector

    fun generarTablas(): Boolean {
        val flag1 = LibroPedidoDAO.generarTabla()
        val flag2 = LibroProveedorDAO.generarTabla()
        val flag3 = LibroCategoriaDAO.generarTabla()
        val flag4 = LibroVentaDAO.generarTabla()
        val flag5 = ClienteDAO.generarTabla()
        return flag1 && flag2 && flag3 && flag4 && flag5
    }
}