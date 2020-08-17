package com.man.eattogether.member

import org.springframework.data.annotation.Id

class Member(
        @Id
        val id: String,
        val nickname : String,
        val age: Int,
        val gender: String,
        val selfIntro: String) {
}