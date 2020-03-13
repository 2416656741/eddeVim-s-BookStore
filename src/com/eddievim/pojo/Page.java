package com.eddievim.pojo;

import java.util.List;

public class Page<T> {

    public static final Integer PAGE_SIZE = 5;
    //当前页码
    private Integer pageNO;
    //总页码
    private Integer pageTotal;
    //但前页显示数
    private Integer pageSize = PAGE_SIZE;
    //总记录数
    private Integer pageTotalCount;

    private List<T> items;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNO=" + pageNO +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getPageNO() {
        return pageNO;
    }

    public void setPageNO(Integer pageNO) {
        if(pageNO < 1) this.pageNO = 1;
        else if(pageNO > pageTotal) this.pageNO = pageTotal;
        else this.pageNO = pageNO;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
