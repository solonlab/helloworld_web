package com.example.demo.config

import org.noear.solon.annotation.Component
import org.noear.solon.core.exception.StatusException
import org.noear.solon.core.handle.Context
import org.noear.solon.core.handle.Filter
import org.noear.solon.core.handle.FilterChain
import org.noear.solon.core.handle.Result
import org.noear.solon.validation.ValidatorException
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Component
class AppFilter : Filter {
    val log: Logger = LoggerFactory.getLogger(AppFilter::class.java)

    override fun doFilter(ctx: Context?, chain: FilterChain?) {
        try {
            chain!!.doFilter(ctx)
        } catch (e: ValidatorException) {
            if (ctx!!.path().contains("/ajax/")) {
                ctx!!.render(Result.failure<Any>(e.message))
            } else {
                //302 跳转到 /error
                ctx!!.redirect("/error")
            }
        } catch (e: StatusException) {
            if (e.code == 404) {
                ctx!!.redirect("/404.htm")
            } else {
                ctx!!.status(e.code)
            }
        } catch (e: Throwable) {
            ctx!!.status(500)
            log.error("500 ERROR: ", e)
        }
    }
}