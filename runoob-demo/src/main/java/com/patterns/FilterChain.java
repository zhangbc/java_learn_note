package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截过滤器模式--创建过滤器链(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 01:11
 */
public class FilterChain {

    private List<Filter> filters = new ArrayList<>(16);
    private Target target;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void execute(String request) {
        for (Filter filter: filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}
