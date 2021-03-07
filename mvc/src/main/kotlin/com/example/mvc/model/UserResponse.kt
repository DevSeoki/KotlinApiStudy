package com.example.mvc.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserReponse(
        var result:Result?=null,
        var description:String?=null,
        @JsonProperty("user")
        var userRequest: MutableList<UserRequest>?=null
)

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Result(
        var resultCode:String?=null, // result_code
        var resultMessage:String?=null // result_message
)