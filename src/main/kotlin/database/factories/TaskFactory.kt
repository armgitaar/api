package __PACKAGE__.database.factories

import dev.alpas.ozone.EntityFactory
import dev.alpas.ozone.faker
import __PACKAGE__.entities.Task
import __PACKAGE__.entities.Tasks
import dev.alpas.hashing.Hasher

import java.time.Instant
import java.util.concurrent.TimeUnit

internal class TaskFactory(private val hasher: Hasher) : EntityFactory<Task, Tasks>() {
    override val table = Tasks
    
    override fun entity(): Task {
        // https://alpas.dev/docs/ozone

        return Task {
            name = faker.chuckNorris().fact()
            completed = listOf<Boolean>(true, false).random()
            updatedAt = Instant.now()
            createdAt = faker.date().past(1, TimeUnit.HOURS).toInstant()
        }
    }
}