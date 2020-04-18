package __PACKAGE__.entities

import dev.alpas.ozone.*
import me.liuwj.ktorm.schema.boolean
import java.time.Instant

interface Task : OzoneEntity<Task> {
    var id: Long
    var name: String
    var completed: Boolean
    var createdAt: Instant?
    var updatedAt: Instant?

    companion object : OzoneEntity.Of<Task>()
}

object Tasks : OzoneTable<Task>("tasks") {
    val id by bigIncrements()
    val name by mediumText("name").bindTo { it.name }
    val completed by boolean("completed").default(false).bindTo { it.completed }
    val createdAt by createdAt()
    val updatedAt by updatedAt()
}