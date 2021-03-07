package com.example.mvc.controller.put

import com.example.mvc.model.Result
import com.example.mvc.model.UserReponse
import com.example.mvc.model.UserRequest
import org.apache.catalina.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun PutMapping(): String{
        println("Put-mapping")
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/put-request-mapping"])
    fun PutRequestMapping() : String {
        println("put-request-mpping")
        return "put-request-mapping"
    }
    // put은 없으면 생성, 있으면 수정
    @PutMapping("/put-object-mapping")
    fun PutObjectMapping(@RequestBody userRequest: UserRequest) : UserRequest{
        return userRequest
    }


    @PutMapping("/put-object-response")
    fun postMappingObjectResponse(@RequestBody userRequest: UserRequest) : UserReponse {

        return UserReponse().apply {
            this.result = Result().apply {
                this.resultCode ="OK"
                this.resultMessage="정상"
            }

            this.description = "PUT-API-TEST"

            var userList = mutableListOf<UserRequest>()
            userList.add(userRequest)

            userList.add(UserRequest().apply {
                this.name="김홍철"
                this.age=37
                this.email="kim@gmail.com"
                this.adress="구리시"
                this.phoneNumber="0107683"
            })

            this.userRequest = userList
        }
    }
}