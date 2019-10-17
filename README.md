#说明
1.配置文件
》spring-cache.xml
redis缓存配置,jsdis可实现pool 和hash的集群redis

2.shiro+redis集成
》在pom.xml中引入shiro相应的jar包
》在pom.xml中引入redis相应的jar包
》在web.xml中于编码过滤器后面添加shiro过滤器
》在spring-cache.xml中配置shiro中的redis
》在spring-shiro中配置进行shiro相关配置