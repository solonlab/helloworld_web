package org.example.demo.config;

import org.noear.solon.annotation.Component;
import org.noear.solon.core.exception.StatusException;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;
import org.noear.solon.core.handle.Result;
import org.noear.solon.validation.ValidatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class AppFilter implements Filter { //如果想排除静态资源，可以换成 RouterInterceptor
    static final Logger log = LoggerFactory.getLogger(AppFilter.class);

    @Override
    public void doFilter(Context ctx, FilterChain chain) throws Throwable {
        try {
            chain.doFilter(ctx);
        } catch (ValidatorException e) {
            if (ctx.path().contains("/ajax/")) {
                ctx.render(Result.failure(e.getMessage()));
            } else {
                //302 跳转到 /error
                ctx.redirect("/error");
            }
        } catch (StatusException e) {
            if (e.getCode() == 404) {
                ctx.redirect("/404.htm");
            } else {
                ctx.status(e.getCode());
            }
        } catch (Throwable e) {
            ctx.status(500);
            log.error("500 ERROR: ", e);
        }
    }
}
