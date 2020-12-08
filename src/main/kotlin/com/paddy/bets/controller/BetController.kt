package com.paddy.bets.controller

import com.paddy.bets.Bet
import com.paddy.bets.repository.BetRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
class BetController(private val repo: BetRepository) {

    @GetMapping("/bets")
    fun getAllBets(): List<Bet> = repo.findAll()

    @PostMapping("/bets")
    fun addBet(@Validated @RequestBody bet: Bet): Bet = repo.save(bet)

    @DeleteMapping("/bets/{id}")
    fun deleteBetById(@PathVariable(value = "id") betId: Long): ResponseEntity<Void> {
        return repo.findById(betId).map { bet ->
            repo.delete(bet)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}