package org.pyro.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.pyro.gateway.constant.FilterType;
import org.pyro.gateway.constant.HeaderConstant;
import org.pyro.gateway.util.RequestHeaderUtil;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/30 23:25
 */
@Slf4j
@Component
public class AccessFilter extends ZuulFilter {
    
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;
    
    @Override
    public String filterType() {
        return FilterType.PRE.value();
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
        log.info("Current request context is {}", requestContext);
        String uri = requestContext.getRequest().getRequestURI();
        log.info("Processing incoming request for {} ...", uri);
    
        if (Objects.isNull(getAccessHeader())) {
            setAccessHeader(genAccessHeader());
        }
        
        return null;
    }
    
    private String getAccessHeader() {
        return RequestHeaderUtil.getRequestHeader(HeaderConstant.ACCESS);
    }
    
    private void setAccessHeader(String accessHeaderValue) {
        RequestHeaderUtil.setRequestHeader(HeaderConstant.ACCESS, accessHeaderValue);
    }
    
    private String genAccessHeader() {
        return UUID.randomUUID().toString();
    }
    
}
