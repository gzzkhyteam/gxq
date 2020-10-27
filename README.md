基于SpringCloud+SpringBoot进行改造的版本
缺点：学习成本高

gxqpt项目基于Spring Cloud微服务化开发平台，具有统一授权、认证后台管理系统、openAPI，其中包含具备帐号管理、资源权限管理、网关API管理、OpenAPI等多个模块，支持多业务系统并行开发，代码简洁，架构清晰。核心技术采用Eureka、Fegin、Ribbon、Zuul、Hystrix、JWT Token、Mybatis、SpringBoot、Redis等主要框架和中间件。

架构详解:
服务鉴权

通过JWT的方式来加强服务之间调度的权限验证，保证内部服务的安全性。

OpenAPI鉴权 

通过JWT的方式来加强对外暴露接口调度的权限验证，保证api接口的安全性。

监控

利用Spring Boot Admin 来监控各个独立Service的运行状态；利用Hystrix Dashboard来实时查看接口的运行状态和调用频率等。

负载均衡

将服务保留的rest进行代理和网关控制，除了平常经常使用的node.js、nginx外，Spring Cloud系列的zuul和rebbion，可以帮我们进行正常的网关管控和负载均衡。其中扩展和借鉴国外项目的扩展基于JWT的Zuul限流插件，方面进行限流。

服务注册与调用

基于Eureka来实现的服务注册与调用，在Spring Cloud中使用Feign, 我们可以做到使用HTTP请求远程服务时能与调用本地方法一样的编码体验，开发者完全感知不到这是远程方法，更感知不到这是个HTTP请求。

熔断机制

因为采取了服务的分布，为了避免服务之间的调用“雪崩”，采用了Hystrix的作为熔断器，避免了服务之间的“雪崩”。

# 启动指南

### 环境须知：

- 为了更加方便的开发SpringBoot项目，开发工具推荐使用 `IntelliJ IDEA`。（Eclipse重度用户可以考虑SpringToolSuite或安装SpringBoot插件）
- mysql一个，redis一个，rabbitmq一个
- jdk1.8
- IDE插件一个(Eclipse, IDEA都需要安装插件)，`lombok插件`，具体百度即可

### 本项目中一些对象的概念
```
    VO（View Object）：视图对象，用于展示层，它的作用是把某个指定页面（或组件）的所有数据封装起来。
    （本项目中,可能暂时不用）

　　DTO（Data Transfer Object）：数据传输对象，这个概念来源于J2EE的设计模式，原来的目的是为了EJB的分布式应用提供粗粒度的数据实体，
    以减少分布式调用的次数，从而提高分布式调用的性能和降低网络负载，但在这里，我泛指用于展示层与服务层之间的数据传输对象。
    （本项目中，rest层传输和返回的对象，就用DTO，大写DTO结尾）

　　DO（Domain Object）：领域对象，就是从现实世界中抽象出来的有形或无形的业务实体。
    （本项目中，自定义sql查询返回对象，就用DO, 大写DO结尾）

　　PO（Persistent Object）：持久化对象，它跟持久层（通常是关系型数据库）的数据结构形成一一对应的映射关系，如果持久层是关系型数据库，
    那么，数据表中的每个字段（或若干个）就对应PO的一个（或若干个）属性。 
    （本项目中，跟表一一对应，无结尾）
```

### 项目结构:

```
├─codeBySC2
│  │  
│  ├─backend---------------------------------后端服务
│  |  |─gxqpt-admin--------------------------权限服务
│  |  |  |─gxqpt-admin-api-------------------权限服务api接口
│  |  |  |─gxqpt-admin-api-impl--------------权限服务api实现
│  |  |  |─gxqpt-admin-repository------------权限具体实现/持久层/po
│  |  |  |─gxqpt-admin-server[9790]----------权限服务容器/配置
│  |  ├─gxqpt-auth---------------------------鉴权中心
│  |  |  |─gxqpt-auth-client-----------------鉴权中心客户端
│  |  |  |─gxqpt-auth-common-----------------鉴权中心公共包
│  |  |  |─gxqpt-auth-server[9775]-----------鉴权中心服务
│  |  ├─gxqpt-gate---------------------------统一网关负载中心
│  |  |  |─gxqpt-gate-ratelimit--------------gxqpt项目网关限流jar
│  |  |  |─gxqpt-gate-server[9770]-----------gxqpt项目网关服务
│  |  ├─gxqpt-file---------------------------文件服务
│  |  |  |─gxqpt-file-api--------------------文件服务api
│  |  |  |─gxqpt-file-api-impl---------------文件服务具体实现/持久层/po
│  |  |  |─gxqpt-file-server[9785]-----------文件服务容器/配置
│  |  ├─gxqpt-logs---------------------------日志服务
│  |  |  |─gxqpt-logs-api--------------------日志服务api
│  |  |  |─gxqpt-logs-api-impl---------------日志服务具体实现/持久层/po
│  |  |  |─gxqpt-logs-server[9805]-----------日志服务容器/配置
│  |  ├─gxqpt-msgs---------------------------消息服务
│  |  |  |─gxqpt-msgs-api--------------------消息服务api
│  |  |  |─gxqpt-msgs-api-impl---------------消息服务具体实现/持久层/po
│  |  |  |─gxqpt-msgs-server[9820]-----------消息服务容器/配置
│  |  ├─gxqpt-standard[9815]-----------------标准服务
│  |  ├─gxqpt-piping[9810]--------------------管道服务
│  │ 
│  ├─commons---------------------------------公共jar
│  |  |─gxqpt-commons------------------------gxqpt项目公共包
│  |  |─hengyun-boot-dependencies------------恒运boot项目父pom
│  |  |─hengyun-gxqpt-core-------------------恒运项目核心包
│  |  |─hengyun-gxqpt-util-------------------恒运项目工具包
│  │ 
│  ├─frontend--------------------------------gxqpt项目前端(controller/jsp)
│  |  |─gxqpt-sso-webapp[10000]---------------gxqpt单点登录服务端
│  |  |─gxqpt-center-webapp[9780]------------gxqpt统一认证系统
│  |  |─gxqpt-authority-webapp[9830]--------------gxqpt权限系统
│  |  |─gxqpt-standard-webapp[9825]----------gxqpt标准系统
│  │
│  ├─services--------------------------------服务/监控
│  |  |─gxqpt-eureka[8500]-------------------gxqpt项目 Eureka 服务
│  |  |─gxqpt-monitor[9795,9796]-------------spring-boot-admin监控中心
│  |  |─gxqpt-zipkin[9800]-------------------zipkin分布式链路跟踪
│  │
│  ├─以下为非业务代码，后期普通开发人员无需导入项目，由管理人员来维护
│  │
├─hengyun-boot-dependencies------------------项目父bom(管理jar版本)
│  │
├─hengyun-commons----------------------------公共jar， 这里的包需要调整一下，目前实现方式很不友好
│  ├─henyun-gxqpt-core-----------------------核心包
│  ├─henyun-gxqpt-util-----------------------工具类
│  │
│  │-...
```

### 运行步骤:
- Hosts文件配置（ip根据自己的情况合理修改）：
```
    127.0.0.1 eureka.gxqpt.com      # eureka服务发现注册ip
    127.0.0.1 admin.gxqpt.com       # 后台管理服务ip
    127.0.0.1 open.gxqpt.com        # 基础服务ip
    127.0.0.1 gateway.gxqpt.com     # 网关服务ip
    127.0.0.1 auth.gxqpt.com        # 授权服务ip
    127.0.0.1 monitor.gxqpt.com     # 监控服务ip
    127.0.0.1 zipkin.gxqpt.com      # 链路监控服务ip
    127.0.0.1 gxqpt.rabbitmq        # rabbitmq地址
    127.0.0.1 gxqpt.mysql           # mysql 地址
    127.0.0.1 gxqpt.redis           # redis 地址
```
- 运行数据库脚本：依次运行数据库：
    - `backend/gxqpt-open/gxqpt-base-server/doc/init.sql`、
    - `backend/gxqpt-admin/gxqpt-admin-server/doc/init.sql`

- 通过一下方法，进行密码加密：
```
    public static void main(String[] args) throws Exception {
        System.out.println(ConfigTools.encrypt("your mysql password"));
    }
```    
- 修改配置数据库/缓存/rabbitMq配置(ip/帐号/密码)：
    - gxqpt-admin-server/src/main/resources/${profiles}/application.yml
    - gxqpt-base-server/src/main/resources/${profiles}/application.yml
- 通过maven依次编译(mvn clean install -DskipTests)：
    - hengyun-boot-dependencies
    - hengyun-commons   (hengyun-gxqpt-build.pom) 
    - gxqpt-commons     
    - backend           (hengyun-backend.pom) 
    - services          (hengyun-services.pom) 
    - frontend          (hengyun-frontend.pom) 
- 按`顺序`运行main类：
    - GxqptEurekaApplication（gxqpt-eureka）
    - GxqptAdminServerApplication（gxqpt-admin-server）
    - GxqptFileApplication（gxqpt-file-server）
    - GxqptAuthApplication（gxqpt-auth-server)
    - GxqptGateServerApplication（gxqpt-gate-server）
    - GxqptZipkinApplication（gxqpt-zipkin）
    - GxqptMonitorApplication（gxqpt-monitor）

​	
df -h
查看当前目录的磁盘占用
du -ah --max-depth=1


192.168.1.204 服务器启动命令：
cd /home/gxqpt/gxqpt/projects

nohup java -jar ./gxqpt-eureka/gxqpt-eureka.jar --spring.profiles.active=test > ./logs/gxqpt-eureka-server/console.log 2>&1 &
nohup java -jar ./gxqpt-monitor/gxqpt-monitor.jar --spring.profiles.active=test > ./logs/gxqpt-monitor-server/console.log 2>&1 &
nohup java -jar ./gxqpt-zipkin/gxqpt-zipkin.jar --spring.profiles.active=test  > ./logs/gxqpt-zipkin-server/console.log 2>&1 &
nohup java -jar ./gxqpt-gate-server/gxqpt-gate-server.jar --spring.profiles.active=test > ./logs/gxqpt-gate-server/console.log 2>&1 &
nohup java -jar ./gxqpt-auth-server/gxqpt-auth-server.jar --spring.profiles.active=test  > ./logs/gxqpt-gate-server/console.log 2>&1 &
nohup java -jar ./gxqpt-file-server/gxqpt-file-server.jar --spring.profiles.active=test  > ./logs/gxqpt-file-server/console.log 2>&1 &
nohup java -jar ./gxqpt-admin-server/gxqpt-admin-server.jar --spring.profiles.active=test  > ./logs/gxqpt-admin-server/console.log 2>&1 &
nohup java -jar ./gxqpt-center-webapp/gxqpt-center-webapp.jar --spring.profiles.active=test  > ./logs/gxqpt-center-webapp/console.log 2>&1 &



/home/gxqpt/shells/project_start.sh restart gxqpt-eureka-server
/home/gxqpt/shells/project_start.sh restart gxqpt-monitor-server
/home/gxqpt/shells/project_start.sh restart gxqpt-zipkin-server
/home/gxqpt/shells/project_start.sh restart gxqpt-gate-server
/home/gxqpt/shells/project_start.sh restart gxqpt-auth-server
/home/gxqpt/shells/project_start.sh restart gxqpt-file-server
/home/gxqpt/shells/project_start.sh restart gxqpt-admin-server
/home/gxqpt/shells/project_start.sh restart gxqpt-center-webapp


/home/gxqpt/shells/project_start.sh start gxqpt-eureka-server
/home/gxqpt/shells/project_start.sh start gxqpt-monitor-server
/home/gxqpt/shells/project_start.sh start gxqpt-zipkin-server
/home/gxqpt/shells/project_start.sh start gxqpt-gate-server
/home/gxqpt/shells/project_start.sh start gxqpt-auth-server
/home/gxqpt/shells/project_start.sh start gxqpt-file-server
/home/gxqpt/shells/project_start.sh start gxqpt-admin-server
/home/gxqpt/shells/project_start.sh start gxqpt-center-webapp




192.168.1.204:

nohup java -Xms256M -Xmx256M -Xss512k -XX:MetaspaceSize=64M -XX:MaxMetaspaceSize=128M -XX:+UseG1GC  -jar ./gxqpt-eureka/gxqpt-eureka.jar --spring.profiles.active=test > /dev/null 2>&1 &

nohup java -Xms256M -Xmx256M -Xss512k -XX:MetaspaceSize=64M -XX:MaxMetaspaceSize=128M -XX:+UseG1GC -jar ./gxqpt-center-webapp/gxqpt-center-webapp.jar --spring.profiles.active=test  > /dev/null 2>&1 &

nohup java -Xms256M -Xmx256M -Xss512k -XX:MetaspaceSize=64M -XX:MaxMetaspaceSize=128M -XX:+UseG1GC -jar ./gxqpt-auth-server/gxqpt-auth-server.jar --spring.profiles.active=test  > /dev/null 2>&1 &
nohup java -Xms256M -Xmx256M -Xss512k -XX:MetaspaceSize=64M -XX:MaxMetaspaceSize=128M -XX:+UseG1GC -jar ./gxqpt-gate-server/gxqpt-gate-server.jar --spring.profiles.active=test  > /dev/null 2>&1 &
nohup java -Xms256M -Xmx256M -Xss512k -XX:MetaspaceSize=64M -XX:MaxMetaspaceSize=128M -XX:+UseG1GC -jar ./gxqpt-admin-server/gxqpt-admin-server.jar --spring.profiles.active=test  > /dev/null 2>&1 &

192.168.0.211:
nohup java -Xms256M -Xmx256M -Xss512k -XX:MetaspaceSize=64M -XX:MaxMetaspaceSize=128M -XX:+UseG1GC -jar ./gxqpt-msgs-server/gxqpt-msgs-server.jar --spring.profiles.active=test2  > /dev/null 2>&1 &

nohup java -Xms256M -Xmx256M -Xss512k -XX:MetaspaceSize=64M -XX:MaxMetaspaceSize=128M -XX:+UseG1GC -jar ./gxqpt-pt-server/gxqpt-pt-server.jar --spring.profiles.active=test2  > /dev/null 2>&1 &
nohup java -Xms256M -Xmx256M -Xss512k -XX:MetaspaceSize=64M -XX:MaxMetaspaceSize=128M -XX:+UseG1GC -jar ./gxqpt-standard-server/gxqpt-standard-server.jar --spring.profiles.active=test2  > /dev/null 2>&1 &



nohup java -Xms256M -Xmx256M -Xss256k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-piping-server/gxqpt-piping-server.jar --spring.profiles.active=test2  > /dev/null 2>&1 &


测试环境：
/home/gxqpt/projects


192.168.30.151
nohup java -Xms1024M -Xmx1024M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-eureka/gxqpt-eureka.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms512M -Xmx512M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-zipkin/gxqpt-zipkin.jar --spring.profiles.active=prod  > /dev/null 2>&1 &



192.168.30.81
nohup java -Xms4G -Xmx6G -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-gate-server/gxqpt-gate-server.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms4G -Xmx6G -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-auth-server/gxqpt-auth-server.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms4G -Xmx6G -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-admin-server/gxqpt-admin-server.jar --spring.profiles.active=prod  > /dev/null 2>&1 &


nohup java -Xms4G -Xmx6G -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-gate-server/gxqpt-gate-server.jar --spring.profiles.active=prod --gxqpt.hostname.gate=192.168.30.90 > /dev/null 2>&1 &
nohup java -Xms4G -Xmx6G -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-auth-server/gxqpt-auth-server.jar --spring.profiles.active=prod --gxqpt.hostname.auth=192.168.30.90 > /dev/null 2>&1 &
nohup java -Xms4G -Xmx6G -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-admin-server/gxqpt-admin-server.jar --spring.profiles.active=prod --gxqpt.hostname.admin=192.168.30.90 > /dev/null 2>&1 &

nohup java -Xms2048M -Xmx2048M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-gate-server/gxqpt-gate-server.jar --spring.profiles.active=prod > /dev/null 2>&1 &
nohup java -Xms2048M -Xmx2048M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-auth-server/gxqpt-auth-server.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms2048M -Xmx2048M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-admin-server/gxqpt-admin-server.jar --spring.profiles.active=prod  > /dev/null 2>&1 &

192.168.30.82
nohup java -Xms1024M -Xmx1024M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-pt-server/gxqpt-pt-server.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms1024M -Xmx1024M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-standard-server/gxqpt-standard-server.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms1024M -Xmx1024M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-piping-server/gxqpt-piping-server.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms1024M -Xmx1024M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-exchange-server/gxqpt-exchange-server.jar --spring.profiles.active=prod  > /dev/null 2>&1 &

192.168.30.83
nohup java -Xms1024M -Xmx1024M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-msgs-server/gxqpt-msgs-server.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms2048M -Xmx2048M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-file-server/gxqpt-file-server.jar --spring.profiles.active=prod  > /dev/null 2>&1 &




nohup java -Xms1G -Xmx1G -Xss512k -XX:MetaspaceSize=256M -XX:MaxMetaspaceSize=512M -XX:+UseG1GC -jar ./gxqpt-center-webapp/gxqpt-center-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms1G -Xmx1G -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-screen-webapp/gxqpt-screen-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms1G -Xmx1G -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-developer-webapp/gxqpt-developer-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms1G -Xmx1G -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-authority-webapp/gxqpt-authority-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &


192.168.30.84
nohup java -Xms1G -Xmx1G -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-exchange-webapp/gxqpt-exchange-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms512M -Xmx512M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-msgs-webapp/gxqpt-msgs-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms512M -Xmx512M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-logs-webapp/gxqpt-logs-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms512M -Xmx512M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-file-webapp/gxqpt-file-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms512M -Xmx512M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-standard-webapp/gxqpt-standard-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms512M -Xmx512M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-warn-webapp/gxqpt-warn-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms512M -Xmx512M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-sms-webapp/gxqpt-sms-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms512M -Xmx512M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-modular-webapp/gxqpt-modular-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms512M -Xmx512M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-fast-webapp/gxqpt-fast-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &
nohup java -Xms512M -Xmx512M -Xss512k -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+UseG1GC -jar ./gxqpt-mt-webapp/gxqpt-mt-webapp.jar --spring.profiles.active=prod  > /dev/null 2>&1 &


| 服务 | 描述 | 端口号 |
|:----:|:----:|:----:|
| gxqpt-eureka | 注册中心 | 10030,10031 |  ​
| gxqpt-zipkin | 链路监控 | 10032 |  ​ 
| gxqpt-monitor | 服务监控 | 10033,10034 |  ​
| - | - |​- | ​
| gxqpt-gate-server | 网关服务 |  10003,10004 |  ​
| gxqpt-auth-server | 认证服务 |  10042 |  ​
| gxqpt-admin-server | 权限、服务监控 服务 |  10043 |  ​
| gxqpt-file-server | 文件、日志 服务 |  10044 |  ​
| gxqpt-msgs-server | 消息、短信、邮件服务 |  10046 |  ​
| gxqpt-standard-server | 标准服务、模块服务 |  10048 |  
| gxqpt-piping-server | 预警/管道/统一监管 | 10049 |  
| gxqpt-search-server | 搜索服务 | 10050 |  
| gxqpt-exchange-server | 共享交换 | 10051 |  
| gxqpt-pt-server | 移动终端/安全保障/软硬件/运维管理 服务 | 10052 |  
| - | - |​- | ​
| gxqpt-sso-webapp | 单点登录Server | 10000 |  ​
| gxqpt-center-webapp | center系统 |  10001 |  ​
| gxqpt-authority-webapp | 权限系统 |  10002 |  ​ ​
| gxqpt-file-webapp | 云盘系统 |  10005 |  ​
| gxqpt-logs-webapp | 日志系统 |  10006 |  
| gxqpt-sms-webapp | 短信系统 |  10007 |  
| gxqpt-modular-webapp | 模块监控系统 |  10009 |  
| gxqpt-warn-webapp | 预警管理系统 |  10010 |  
| gxqpt-msgs-webapp | 消息系统 |  10011 |  ​
| gxqpt-standard-webapp | 标准系统 |  10012 | 
| gxqpt-exchange-webapp | 共享交换系统 |  10013 |  ​
| gxqpt-screen-webapp | 大屏 |  10014 |  ​
| gxqpt-developer-webapp | 服务监控系统 |  10015 |  ​
| gxqpt-search-webapp | 搜索后台 |  10016 |  ​
| gxqpt-fast-webapp | 快速开发平台 |  10017 |  ​
| gxqpt-mt-webapp | 移动终端平台 |  10022 |  ​
| - | - |​- | ​​
| gxqpt-mt-h5 | 移动终端 手机端 |  --- |  ​
| gxqpt-pt-webapp | 4大平台 前端 |  ---- |  ​
| gxqpt-mail-webapp | 邮件前端 |  10024 |  ​
| - | - |​- | ​​
| mysql | - |​3306/3307/3308 | ​​
| redis | - |​ | ​​
| rabbitMQ | - | 5672 | ​​



# 如果对你有帮助,可以打赏请作者喝杯咖啡
<center>
    <img align=center src="http://106.54.254.212:6080/wgj.png" width = "30%" height = "30%"/>
</center>
