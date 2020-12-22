package com.amhs.pojo;

import java.util.List;

/**
 * @author Sun.chuanwang
 * @version 1.0.0
 * @date 2020/12/19 10:35
 */
public class PageResult<T> {

    private Long count;
    private List<T> items;

    public PageResult(Long count, List<T> items) {
        this.count = count;
        this.items = items;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
