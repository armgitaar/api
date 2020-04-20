package __PACKAGE__

import __PACKAGE__.controllers.ApiController
import dev.alpas.routing.Router

// https://alpas.dev/docs/routing
fun Router.addRoutes() = apply {
    apiRoutes()
}

private fun Router.apiRoutes() {
    // register API routes here
    resources<ApiController>("tasks")

    // Using resources above means we don't need to add the below
    /*
    group("tasks") {
        get(ApiController::index)
        get(ApiController::show)
        post(ApiController::store)
        delete(ApiController::delete)
        patch(ApiController::update)
    }*/
}





