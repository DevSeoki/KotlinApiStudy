package com.example.mvc.controller.get

import com.example.mvc.model.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping("/hello")
    fun hello() : String {
        return "hello kotlin seo"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping() : String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable(value = "name") _name : String ,@PathVariable(name = "age") age:Int): String {

        var name = "seokiwon2"

        println("${_name},${age}")
        return _name+" "+age+" "+name
    }

    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam name: String,
        @RequestParam(value = "age") age: Int
    ): String{
        println("${name}, ${age}")
        return name+" "+age
    }

    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest):  UserRequest{
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String,Any>): Map<String,Any> {
        println(map)
        return map
    }

    @GetMapping("/lottery/")
    fun LotterySerch(): String {

        return "lottery"
    }
}