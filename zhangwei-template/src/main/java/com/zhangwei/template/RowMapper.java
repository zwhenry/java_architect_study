package com.zhangwei.template;

import java.sql.ResultSet;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 7:51 PM
 * @since 1.0.0
 **/
public interface RowMapper<T> {
    public T mapRow(ResultSet rs, int rowNum) throws Exception;
}
