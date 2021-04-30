package org.pyro.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.pyro.gateway.constant.FilterType;
import org.pyro.gateway.constant.HeaderConstant;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/5/1 0:29
 */
@Slf4j
@Component
public class ResponseFilter extends ZuulFilter {
    
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;
    
    @Override
    public String filterType() {
        return FilterType.POST.value();
    }
    
    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }
    
    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }
    
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.addZuulResponseHeader(HeaderConstant.ACCESS, getAccessHeader());
        
        String uri = requestContext.getRequest().getRequestURI();
        log.info("Process incoming request for {} complete.", uri);
        
        return null;
    }
    
    private String getAccessHeader() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String valueInOriginalHeader = requestContext.getRequest().getHeader(HeaderConstant.ACCESS);
        if (Objects.nonNull(valueInOriginalHeader)) {
            return valueInOriginalHeader;
        }
        return requestContext.getZuulRequestHeaders().get(HeaderConstant.ACCESS);
    }
    
}
