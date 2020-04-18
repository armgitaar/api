package __PACKAGE__

import __PACKAGE__.controllers.ApiController
import dev.alpas.routing.Router

// https://alpas.dev/docs/routing
fun Router.addRoutes() = apply {
    apiRoutes()
}

private fun Router.apiRoutes() {
    // register API routes here
   /* group("tasks") {
        get(ApiController::show)
        post(ApiController::add)
        delete(ApiController::remove)
        patch(ApiController::update)
    }*/

    resources<ApiController>("tasks")
}
