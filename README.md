# SpringBootTransDemo
SpringBoot Transaction Demo

# See
https://www.jianshu.com/p/380a9d980ca5 SpringBoot 快速开启事务（附常见坑点）
https://www.jianshu.com/p/8cffcc105b3a MyBatis 注解方式的基本用法


# Spring数据库事务使用总结
1. 事务控制要放在Service层，不要捕获需要触发回滚的异常；
2. Controller层不要做事务控制；
3. 事务默认传播方式是Propagation.REQUIRED，触发回滚的是RuntimeException异常；
4. 调用多个涉及事务的Service，如果需要在同一个事务里面，不要在Controller层调用这些服务，还是要包装或者放到一个Service中去调用这些Service；
5. 涉及多个事务，也可以在一个Service中调用不同的Mapper去操作数据库（可能会导致服务耦合，不建议）；
6. 只涉及SELECT查询的Service不必开启事务；
