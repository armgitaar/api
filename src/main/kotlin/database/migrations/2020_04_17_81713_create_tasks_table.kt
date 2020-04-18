package __PACKAGE__.database.migrations

import __PACKAGE__.entities.Tasks
import dev.alpas.ozone.migration.Migration

class CreateTasksTable : Migration() {
    override var name = "2020_04_17_81713_create_tasks_table"
    
    override fun up() {
        createTable(Tasks)
    }
    
    override fun down() {
        dropTable(Tasks)
    }
}