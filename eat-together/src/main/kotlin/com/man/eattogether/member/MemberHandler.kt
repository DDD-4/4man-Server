package com.man.eattogether.member

import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class MemberHandler(private val service: MemberService) {
    suspend fun findAll(request: ServerRequest): ServerResponse {
        val users = service.findAll()
        return ServerResponse.ok().json().bodyAndAwait(users)
    }

    suspend fun addMember(request: ServerRequest): ServerResponse {
        val newMember = try {
            request.bodyToMono<Member>().awaitFirstOrNull()
        } catch (e: Exception) {
            println(e)
            null
        }
        return if (newMember == null) {
            ServerResponse.badRequest().json().bodyValueAndAwait("Invalid body")
        } else {
            val member = service.addOne(newMember)
            if (member == null) ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).json().bodyValueAndAwait("Internal error")
            else ServerResponse.status(HttpStatus.CREATED).json().bodyValueAndAwait(member)
        }
    }

    suspend fun register(request: ServerRequest): ServerResponse {
        val newMember = try {
            request.bodyToMono<Member>().awaitFirstOrNull()
        } catch (e: Exception) {
            println(e)
            null
        }
        return if (newMember == null) {
            ServerResponse.badRequest().json().bodyValueAndAwait("Invalid body")
        } else {
            val member = service.addOne(newMember)
            if (member == null) ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).json().bodyValueAndAwait("Internal error")
            else ServerResponse.status(HttpStatus.CREATED).json().bodyValueAndAwait(member)
        }
    }
}