package com.eddievim.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {

    public static <T> T copyParamToBean(Map map, T bean) {
        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }
}
