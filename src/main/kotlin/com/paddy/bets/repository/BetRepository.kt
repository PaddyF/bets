package com.paddy.bets.repository

import com.paddy.bets.Bet
import org.springframework.context.annotation.Bean
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BetRepository : CrudRepository<Bet, Long>