package com.paddy.bets

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Bet(
    var odds: Double,
    var content: String,
    var fighter: Fighter,
    var fight: Fight,
    var won: Boolean,
    var cancelled: Boolean,
    var author: User,
    var date: Date,
    var image: String,
    @Id @GeneratedValue var id: Long? = null
)

@Entity
class User(
    var login: String,
    var firstname: String,
    var lastname: String,
    val bets: List<Bet>,
    @Id @GeneratedValue var id: Long? = null
)

@Entity
class Fighter(
    var firstname: String,
    var lastname: String,
    var wins: Int,
    var losses: Int,
    var lastopp: Fighter,
    var nextopp: Fighter,
    var fights: List<Fight>,
    @Id @GeneratedValue var id: Long? = null
)

@Entity
class Fight(
    var fighter1: Fighter,
    var fighter2: Fighter,
    var date: Date,
    var winner : Fighter,
    var loser : Fighter,
    var rounds: Int,
    var method: Method,
    var cancelled: Boolean,
    @Id @GeneratedValue var id: Long? = null

)

enum class Method {KO, SUB, DEC, DQ, NC}

