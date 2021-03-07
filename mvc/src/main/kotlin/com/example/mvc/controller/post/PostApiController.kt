package com.example.mvc.controller.post

import com.example.mvc.model.Result
import com.example.mvc.model.UserReponse
import com.example.mvc.model.UserRequest
import org.springframework.web.bind.annotation.*
import java.lang.reflect.Method

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post-mapping")
    fun PostApiTest(): String {
        println("post-mapping")
        return "post-mapping"
    }

    @RequestMapping(method = [RequestMethod.POST], path = ["/post-request-mapping"])
    fun RequestPostAoiTest() : String {
        return "reqeust-mapping"
    }

    @PostMapping("/post-mapping-object")
    fun postMappingObject(@RequestBody userRequest: UserRequest) : UserRequest {
        //json -> object
        println(userRequest)
        return userRequest // object -> json
    }

    @PostMapping("/post-maaping-response")
    fun postMappingObjectResponse(@RequestBody userRequest: UserRequest) : UserReponse {

        return UserReponse().apply {
            this.result = Result().apply {
                this.resultCode ="OK"
                this.resultMessage="정상"
            }

            this.description = "PUT-API-TEST"

            var userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
        }
    }
}
