package id.yoframework.minimal.web.module

import id.yoframework.minimal.web.verticle.MainVerticle
import dagger.Component
import id.yoframework.core.module.CoreModule
import id.yoframework.web.module.WebModule
import javax.inject.Singleton

/**
 * [Documentation Here]
 *
 * @author Deny Prasetyo.
 */

@Singleton
@Component(modules = [CoreModule::class, WebModule::class])
interface AppComponent {
    fun mainVerticle(): MainVerticle
}