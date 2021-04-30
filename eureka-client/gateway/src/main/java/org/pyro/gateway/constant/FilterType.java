package org.pyro.gateway.constant;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/30 23:45
 */
public enum FilterType {
    
    /**
     *  前置过滤器
     */
    PRE("pre"),
    
    /**
     *  路由过滤器
     */
    ROUTE("route"),
    
    /**
     *  后置过滤器
     */
    POST("post");

    private String value;
    
    FilterType(String value) {
        this.value = value;
    }
    
    public String value() {
        return this.value;
    }

}
