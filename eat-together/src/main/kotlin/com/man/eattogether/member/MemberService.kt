package com.man.eattogether.member

import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service

@Service
class MemberService(private val repo: MemberRepository) {
    suspend fun findAll() = repo.findAll().asFlow();
    suspend fun addOne(member: Member) = repo.save(member).awaitFirstOrNull()
}