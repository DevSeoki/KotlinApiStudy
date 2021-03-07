package com.example.mvc.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest (
        var name:String?=null,
        var age:Int?=null,
        var email:String?=null,
        var adress:String?=null,
        //@JsonProperty("phone_number")
        var phoneNumber:String?=null // phone_number

        //      @JsonProperty("phone_number") // json에서 넘겨주는 key값 사용
)



