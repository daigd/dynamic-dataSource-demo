package com.warm.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author DGD
 * @date 2018/2/7.
 */

@Component
@Aspect
@Order(-100)
@Slf4j
public class DataSourceSwitchAspect {

    @Pointcut("execution(* com.warm.system.service.db1..*.*(..))")
    private void db1Aspect() {
    }

    @Pointcut("execution(* com.warm.system.service.db2..*.*(..))")
    private void db2Aspect() {
    }

    @Before( "db1Aspect()" )
    public void db1() {
        log.info("切换到db1 数据源...");
        DbContextHolder.setDbType(DBTypeEnum.db1);
    }

    @Before("db2Aspect()" )
    public void db2 () {
        log.info("切换到db2 数据源...");
        DbContextHolder.setDbType(DBTypeEnum.db2);
    }
}
