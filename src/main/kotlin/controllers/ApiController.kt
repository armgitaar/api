package __PACKAGE__.controllers

import __PACKAGE__.entities.Tasks
import dev.alpas.http.HttpCall
import dev.alpas.orAbort
import dev.alpas.ozone.latest
import dev.alpas.ozone.create
import me.liuwj.ktorm.dsl.update
import dev.alpas.routing.Controller
import dev.alpas.toJson
import dev.alpas.validation.min
import dev.alpas.validation.required
import me.liuwj.ktorm.dsl.delete
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.filter
import me.liuwj.ktorm.entity.toList
import java.time.Instant

// https://alpas.dev/docs/controllers
class ApiController : Controller() {
    fun index(call: HttpCall) {

        val tasks = Tasks
            .latest()
            .toList()

        call.reply(tasks.toJson()).asJson()
    }

    fun show(call: HttpCall) {

        val id = call.longParam("id").orAbort()

        val tasks = Tasks
            .latest()
            .filter { it.id eq id }
            .toList()

        call.reply(tasks.toJson()).asJson()
    }

    fun store(call: HttpCall) {

        call.applyRules("name") {
           required()
           min(2)
       }.validate()

        val name = call.stringParam("name").orAbort()

        Tasks.create() {
            it.name to name
            it.createdAt to Instant.now()
            it.updatedAt to Instant.now()
        }
        call.acknowledge(201)
    }

    fun delete(call: HttpCall) {

        call.applyRules("id") {
            required()
        }.validate()

        val id = call.longParam("id").orAbort()

        Tasks.delete { it.id eq id }
        call.acknowledge(202)
    }

    fun update(call: HttpCall) {

        val id = call.longParam("id").orAbort()

        Tasks.update {
            if (call.stringParam("name") != null) { it.name to call.stringParam("name") }
            if (call.param("completed") != null) { it.completed to call.param("completed").toString().toBoolean() }
            it.updatedAt to Instant.now()
            where {
                it.id eq id
            }
            call.acknowledge(202)
        }
    }
}