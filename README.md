## 西电优帮_v2.0 后端代码


>目前已完成工作：
>
>全局异常处理、统一结果集和返回码、集成swagger、默认线程池、jwt工具类。




## 技术栈

- `Spring Boot`框架
- 数据库 `mysql`，连接数据库 `mybatis`，集成了druid数据库连接池做sql拦截和优化，插件[`MyBatisCodeHelper-Pro`](https://gejun123456.github.io/MyBatisCodeHelper-Pro/#/) 一键生成写`sql`（[破解版连接](https://blog.csdn.net/weixin_49395637/article/details/115646785)）
- [`Swagger`](https://www.kuangstudy.com/bbs/1417409054413701122)路径：http://localhost:9688/swagger-ui/index.html



### 目录架构

```
├─log
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─qinghuo
│  │  │          └─xduHelp
│  │  │              ├─config					#配置类
│  │  │              │  ├─interceptor				#拦截器配置类
│  │  │              │  ├─swagger					#swagger配置类
│  │  │              │  └─thread					#默认线程池配置类
│  │  │              ├─constants				#常量
│  │  │              ├─controller				#控制类
│  │  │              ├─exception				#异常及返回值处理
│  │  │              │  ├─handler					#全局拦截异常
│  │  │              │  ├─result					#封装返回值
│  │  │              │  └─statusCode				#状态码
│  │  │              ├─interceptor				#拦截器
│  │  │              ├─mapper					#mapper接口
│  │  │              ├─model					#model实体类
│  │  │              │  ├─config					#配置类所用到的属性封装类
│  │  │              │  └─domain					#实体类
│  │  │              ├─service					#业务类
│  │  │              └─util						#工具类
│  │  │                  └─file
│  │  └─resources
│  │      └─mapperXML
```

