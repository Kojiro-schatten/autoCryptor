package com.example.backendkotlindevelopment

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.Timestamp
import java.time.LocalDateTime
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
    fun find(): List<User>

    /**
     * Method: to update Customer Table Column
     *
     * @param id
     * @param name
     */
    fun update(id: Int, name: String)
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
                users (
                    name,
                    created_at,
                    updated_at
                )
            VALUES (
                :name,
                :created_at,
                :updated_at
            )
            ;
        """.trimIndent()
        val sqlParams = MapSqlParameterSource()
            .addValue("name", name)
            .addValue("created_at", LocalDateTime.now())
            .addValue("updated_at", LocalDateTime.now())
        namedParameterJdbcTemplate.update(sql, sqlParams)
        return
    }

    override fun find(): List<User> {
        val sql = """
            SELECT
                id,
                name,
                created_at,
                updated_at
            FROM
                users
            ;
        """.trimIndent()
        val sqlParams = MapSqlParameterSource()
        val userMap = namedParameterJdbcTemplate.queryForList(sql, sqlParams)
        return userMap.map {
            User(
                it["id"].toString().toInt().toLong(),
                it["name"].toString(),
                (it["created_at"] as Timestamp).toLocalDateTime(),
                (it["updated_at"] as Timestamp).toLocalDateTime(),
            )
        }
    }

    override fun update(id: Int, name: String) {
        val sql = """
            UPDATE
                users
            SET
                name = :name
            WHERE
                id = :id
            ;
        """.trimIndent()
        val sqlParams = MapSqlParameterSource()
            .addValue("name", name)
            .addValue("id", id)
            .addValue("updated_at", LocalDateTime.now())
        namedParameterJdbcTemplate.update(sql, sqlParams)
        return
    }
}
