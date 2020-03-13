package com.eddievim.test;

import com.eddievim.utils.JDBCUtils;
import org.junit.Test;

public class JDBCUtilsTest {

    @Test
    public void testJUBCUtils(){
        System.out.println(JDBCUtils.getConnection());
    }
}
