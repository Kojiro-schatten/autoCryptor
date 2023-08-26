package com.example.backendkotlindevelopment

import org.springframework.stereotype.Service

/**
 * Customer: Interface that consilidates methods to operate.
 */

interface UserService {
    /**
     * User add
     *
     * @param name
     */
    fun insertUser(name: String)
    /**
     * User get
     *
     * @return
     */
//    fun selectUser(): List<User>
}

/**
 * User: Class that implements methods to operate.
 *
 * @property userRepository
 */
@Service // annotation for DI
class UserServiceImpl(val userRepository: UserRepository): UserService {
    override fun insertUser(name: String) {
        userRepository.add(name)
        return
    }
}