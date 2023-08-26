package com.example.backendkotlindevelopment

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

/**
 * Customer: Interface that consolidates methods to operate on a table.
 *
 */

interface UserRepository {
    /**
     * Method: add data into Customer Table
     *
     * @param name
     */
    fun add(name: String)

    /**
     * Method: get all data from Customer Table
     *
     * @return
     */
//    fun find(): List<User>

    /**
     * Method: to update Customer Table Column
     *
     * @param id
     * @param name
     */
//    fun update(id: Int, name: String)
}

/**
 * A class that implements UserRepository
 *
 * @property namedParameterJdbcTemplate
 */
@Repository
class UserRepositoryImpl(val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) : UserRepository {
    override fun add(name: String) {
        val sql = """
            INSERT INTO
                user (
                    name
                )
            VALUES (
                :name
            )
            ;
        """.trimIndent()
        val sqlParams = MapSqlParameterSource()
            .addValue("name", name)
        namedParameterJdbcTemplate.update(sql, sqlParams)
        return
    }
}
