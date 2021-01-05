package com.paddy.bets

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Bet(
    var odds: Double,
    var custombet: String,
    var fighter: Fighter,
    var fight: Fight,
    var betType: BetType,
    var betRound: Rounds,
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
    var rounds: Rounds,
    var method: Method,
    var cancelled: Boolean,
    @Id @GeneratedValue var id: Long? = null

)

enum class Method(method: String) { KO("KO"), SUB("SUB"), DEC("DEC"), DQ("DQ"), NC("NC")}

enum class BetType(type: String) { WIN("WIN"), DRAW("DRAW"), KO("KO"), KOTKO("KO/TKO"), SUB("SUB"), DEC("DEC"), ITD("ITD"), KOSUB("KO/SUB"), KODEC("KO/DEC"), SUBDEC("SUB/DEC"), OVER("OVER"), UNDER("UNDER"), FGTD("GOES TO DEC"), FDGTD("DOES NOT GO TO DEC")}

enum class Rounds(rounds: Double) { ONE(1.0), ONEHALF(1.5), TWO(2.0), TWOHALF(2.5), THREE(3.0), THREEHALF(3.5), FOUR(4.0), FOURHALF(4.5), FIVE(5.0)}