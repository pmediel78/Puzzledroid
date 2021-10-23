package com.example.puzzledroid

import java.util.*

class Puzzle( var columnas: Int, var filas: Int) {

    val piezas = mutableListOf<Pieza>()

    fun inicializar() {
        var idPieza = 1
        var columna = 1
        var fila = 0

        while (columna <= columnas) {
            fila = 1
            while (fila <= filas) {
                var pieza = Pieza(columna, fila, idPieza, 1)
                piezas.add(pieza)
                fila++
                idPieza++
            }
            columna++
        }

        for(pieza in piezas){
            println("id:" + pieza.id)
            println("columna:" + pieza.columna)
            println("fila:" + pieza.fila)
            println("estado:" + pieza.estado)
        }
    }
}