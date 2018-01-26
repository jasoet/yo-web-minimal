package id.yoframework.minimal.web.verticle

import id.yoframework.minimal.web.controller.MainController
import id.yoframework.web.verticle.WebVerticle
import javax.inject.Inject
import javax.inject.Singleton

/**
 * [Documentation Here]
 *
 * @author Deny Prasetyo.
 */

@Singleton
class MainVerticle @Inject constructor(mainController: MainController) :
    WebVerticle(mainController)
