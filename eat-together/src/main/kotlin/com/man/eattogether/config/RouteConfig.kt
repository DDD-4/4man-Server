package com.man.eattogether.config

import com.man.eattogether.member.MemberHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouteConfig {

    @Bean
    fun memberRoute(memberHandler: MemberHandler) = coRouter {
        GET("/members", memberHandler::findAll)
        POST("/members", memberHandler::addMember)
    }

}