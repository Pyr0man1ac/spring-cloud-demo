package org.pyro.gateway.util;

import com.netflix.zuul.context.RequestContext;

import java.util.Objects;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/5/1 0:49
 */
public class RequestHeaderUtil {
    
    private RequestHeaderUtil() {}
    
    public static String getRequestHeader(String key) {
        Objects.requireNonNull(key, () -> "请求头部KEY值不能为NULL");
        RequestContext requestContext = RequestContext.getCurrentContext();
        String valueInOriginalHeader = requestContext.getRequest().getHeader(key);
        if (Objects.nonNull(valueInOriginalHeader)) {
            return valueInOriginalHeader;
        }
        return requestContext.getZuulRequestHeaders().get(key);
    }
    
    public static void setRequestHeader(String key, String value) {
        Objects.requireNonNull(key, () -> "请求头部KEY值不能为NULL");
        Objects.requireNonNull(value, () -> "请求头部VALUE值不能为NULL");
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.addZuulRequestHeader(key, value);
    }
    
}
