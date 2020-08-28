package app.web.pavelk.microservices2.client4;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class MyFilter extends ZuulFilter {

    @Override//до запроса или после
    public String filterType() {
        return "pre";
    }

    @Override//приоритет
    public int filterOrder() {
        return 0;
    }

    @Override//включение выключиние фильтра
    public boolean shouldFilter() {
        return false;
    }

    @Override//добавить хедар убрать хедар итд
    public Object run() throws ZuulException {
        System.out.println(RequestContext.getCurrentContext().getRequest());
        RequestContext.getCurrentContext().addZuulResponseHeader("hi", "hi");
        return RequestContext.getCurrentContext();
    }
}
