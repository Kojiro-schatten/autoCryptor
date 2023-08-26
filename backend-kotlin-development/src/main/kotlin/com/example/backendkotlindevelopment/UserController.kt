package com.example.backendkotlindevelopment

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
/**
 * User テーブルの CRUD をおこなう Web API のエンドポイントを定義するクラス
 * User: Class that defines web api end point to execute CRUD.
 *
 * @property userService User service
 */

@RestController // アノテーションされたクラスのメソッドの戻り値が HTTP リクエストの戻り値になります
class UserController(val userService: UserService) {
    /**
     * User add
     *
     * @param request
     * @return
     */
    @CrossOrigin(origins = arrayOf("*"))
    @PostMapping("users") // アノテーションされたメソッドに対して、指定された URL パスの POST メソッドを対応付けします
    // @RequestBody: リクエストボディを指定します
    fun insert(@RequestBody request: UserRequest): String {
        userService.insertUser(request.name)
        return """
            {
                "message": "success"
            }
        """.trimIndent()
    }
    // TODO: update, delete, ...
}

/**
 * User end point for add, update
 *
 * @property name
 */
data class UserRequest(
    @JsonProperty("name") val name: String
)