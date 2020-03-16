package com.eddievim.filter;

import com.eddievim.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            //方法放行
            filterChain.doFilter(servletRequest, servletResponse);
            JDBCUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            JDBCUtils.rollbackAndClose();
        }
    }

    @Override
    public void destroy() {

    }
}
