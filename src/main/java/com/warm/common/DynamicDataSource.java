package com.warm.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author DGD
 * @date 2018/2/7.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * 取得当前使用哪个数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }
}
