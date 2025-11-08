package com.canil.gestorcanil.model

data class Agendamento(
    val id: Int,
    val cliente: String,
    val email: String,
    val telefone: String,
    val dataHora: String
)
