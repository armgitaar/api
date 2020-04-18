package __PACKAGE__.database.seeds

import __PACKAGE__.database.factories.TaskFactory
import dev.alpas.Application
import dev.alpas.make
import dev.alpas.ozone.Seeder
import dev.alpas.ozone.from

// https://alpas.dev/docs/seeding
internal class DatabaseSeeder : Seeder() {
    override fun run(app: Application) {
        val task = from(TaskFactory(app.make()), 15){
        }
    }
}
