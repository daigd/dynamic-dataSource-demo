package com.warm.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

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
    public void db1(JoinPoint joinPoint) {
        log.info("切换到db1 数据源...");
        setDataSource(joinPoint,DBTypeEnum.db1);
    }

    @Before("db2Aspect()" )
    public void db2 (JoinPoint joinPoint) {
        log.info("切换到db2 数据源...");
        setDataSource(joinPoint,DBTypeEnum.db2);
    }

    /**
     * 添加注解方式,如果有注解优先注解,没有则按传过来的数据源配置
     * @param joinPoint
     * @param dbTypeEnum
     */
    private void setDataSource(JoinPoint joinPoint, DBTypeEnum dbTypeEnum) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        DataSourceSwitch dataSourceSwitch = methodSignature.getMethod().getAnnotation(DataSourceSwitch.class);
        if (Objects.isNull(dataSourceSwitch) || Objects.isNull(dataSourceSwitch.value())) {
            DbContextHolder.setDbType(dbTypeEnum);
        }else{
            log.info("根据注解来切换数据源,注解值为:"+dataSourceSwitch.value());
            switch (dataSourceSwitch.value().getValue()) {
                case "db1":
                    DbContextHolder.setDbType(DBTypeEnum.db1);
                    break;
                case "db2":
                    DbContextHolder.setDbType(DBTypeEnum.db2);
                    break;
                default:
                    DbContextHolder.setDbType(dbTypeEnum);
            }
        }
    }
}
