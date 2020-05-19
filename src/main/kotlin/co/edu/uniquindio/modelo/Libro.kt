package co.edu.uniquindio.modelo

import java.util.*
import kotlin.collections.ArrayList

class Libro (
    val id: Int,
    val precio: Double,
    val titulo: String,
    val fechaPublicacion: Date,
    val autor: Autor,
    val editorial: Editorial,
    val categorias: ArrayList<Categoria> = ArrayList(),
    val proveedores: ArrayList<Proveedor> = ArrayList(),
    val ventas: ArrayList<Venta> = ArrayList(),
    val pedidos: ArrayList<Pedido> = ArrayList()
)