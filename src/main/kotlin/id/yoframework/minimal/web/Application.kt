package id.yoframework.minimal.web

import id.yoframework.core.extension.config.jsonConfig
import id.yoframework.core.extension.config.retrieveConfig
import id.yoframework.core.extension.logger.logger
import id.yoframework.core.extension.logger.useLogback
import id.yoframework.core.extension.vertx.buildVertx
import id.yoframework.core.extension.vertx.deployVerticle
import id.yoframework.core.module.CoreModule
import id.yoframework.minimal.web.module.DaggerAppComponent
import id.yoframework.web.module.WebModule
import kotlinx.coroutines.experimental.runBlocking

/**
 * [Documentation Here]
 *
 * @author Deny Prasetyo.
 */

object Application {
    @JvmStatic
    fun main(args: Array<String>) = runBlocking<Unit> {
        useLogback()

        val log = logger<Application>()
        try {
            log.info("Start build Vertx")
            val vertx = buildVertx()
            val config = vertx.retrieveConfig(jsonConfig("application-config.json"))
            log.info("Start initialize components")
            val app = DaggerAppComponent.builder()
                .coreModule(CoreModule(config, vertx))
                .webModule(WebModule())
                .build()

            log.info("Start deploy Verticle")
            val mainVerticle = app.mainVerticle()
            vertx.deployVerticle(mainVerticle, config)

            log.info("Verticle Deployed")
        } catch (e: Exception) {
            log.error("Failed to Start Application", e)
            System.exit(1)
        }

    }

}