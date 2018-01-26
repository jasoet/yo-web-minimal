package id.yoframework.minimal.web.controller

import id.yoframework.minimal.web.model.HelloClass
import id.yoframework.web.controller.Controller
import id.yoframework.web.extension.jsonHandler
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler
import javax.inject.Inject
import javax.inject.Singleton

/**
 * [Documentation Here]
 *
 * @author Deny Prasetyo.
 */

@Singleton
class MainController @Inject constructor(
    override val router: Router
) : Controller({
    route().handler(BodyHandler.create())

    get("/").jsonHandler {
        HelloClass(name = "Jasoet", text = "Hello")
    }
})
