### 阿风图书管理（JAVA版）

本项目结合流行框架，以学习技术为目的倾心编写，无任何商用用途

首次编写于 2019-12-23，目前只有登陆注册、用户列表和图书列表，参数提交全为ajax请求，用到了权限、上传(FastDFS)、模糊-分页(pagehelper)-联表查询、字典表、上传文件表、手机短信验证、邮箱验证

演示地址：[http://139.9.42.232:8080/bookcms/](帐号：admin   密码：123 权限：开发者模式)

如果有什么好的建议、想法、bug 欢迎咨询下面的QQ或者邮箱联系作者

问题反馈QQ:206323705

问题反馈邮箱:206323705@qq.com



阿风图书CRM采用Maven+Springboot+Mybatis+Mysql+Easyui+Layui的架构

Maven           管理jar和项目

Springboot      整合ssm

Mysql           存储数据用的数据库

Easyui          用来展示树状列表(有权限)

Layui+bootstrap 用组件来展示列表、按钮、弹出层等


## 主要技术栈

核心框架：Springboot2.0.1

工具类：com.book.common 整个包

项目构建工具：maven

Web容器：tomcat

数据交互：Ajax

UI框架：Easyui、Layui



## 安装说明

1、配置java运行环境，mysql环境，FastDFS虚拟机环境，FastDFS配置在src/main/resources/application.properties中

2、将目录doc下的bookcms.sql导入到数据库(库)，doc/table目录下放的表

3、主要配置文件 src/main/resources/application.properties、pom.xml

4、 我的项目名gelai-bookcms

数据库默认账号 root 默认密码 123456  

注: 不用FastDFS不影响运行，把对应的配置注释掉就行了，否则可能会报错

工具类：src/main/java/com/book/common/FastDFSClientWrapper.java 和 src/main/java/com/book/common/AppConfig.java

控制器类：src/main/java/com/book/controller/FastDFSController.java

配置：
``` 
------------ application.properties
# ===================================
# 分布式文件系统FastDFS配置
# ===================================
# 连接超时时间
fdfs.connect-timeout=600
# 读取超时时间
fdfs.so-timeout=1500
# 缩略图的宽高
fdfs.thumb-image.height=150
fdfs.thumb-image.width=150
# tracker服务配置地址列表，替换成自己服务的IP地址，支持多个
fdfs.tracker-list=192.168.25.133:22122
#fdfs.pool.jmx-enabled=false
fdfs.web-server-url=http://192.168.25.133/
#获取静态资源的id 端口号
fdfs.resHost=192.168.25.133
fdfs.storagePort=22122
```
```
------------ pom.xml
<!--  FastDFS的第三方客户端包引入的时候要去除logback的包，不然与log4j2冲突,启动会报错 -->
<dependency>
      <groupId>com.github.tobato</groupId>
      <artifactId>fastdfs-client</artifactId>
      <version>1.26.1-RELEASE</version>
      <exclusions>
        <exclusion>
          <groupId>ch.qos.logback</groupId>
          <artifactId>logback-classic</artifactId>
        </exclusion>
      </exclusions>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <!--<version>3.4</version> -->
</dependency>
```


## 部署说明

本项目JDK要求JDK8及以上

数据库 mysql-connector-java-5.1.7-bin

## 数据库用户名和密码一定要改成自己的  特此提醒

### 一、运行
在主入口函数，右键java运行即可  入口函数:src/main/java/com/book/ApplicationMain

tomcat、web 都已经配置完毕

### 二、短信验证
短信验证采用 榛子云 
开发时 验证已屏蔽
免费条数1条 
可以作为参考调用短信接口来使用

### 三、邮箱验证
开发时 验证已屏蔽为空验证，所以为空时有可能会报错
参考工具类 com.book.common.VerificationCode  com.book.common.EmailCode
稍微的封装了下
QQ邮箱SMTP服务器的我已写好
需要开启自己邮箱的授权码 这个是随机生成的
通过多线程来实现秒数的倒计时

### 四、改进
1 有邮箱验证码的必须邮箱验证；没有的可以忽略,以游客身份登录

2 使用redis数据库增加部分数据访问速度

3 注册卡号,来进行消费

4 判断同一张图片不用上传直接从数据库查询调用(我只判断了文件名)

5 微信小程序操作

## 系统介绍

以下为阿风图书CRM JAVA版部分功能系统截图

![image](https://github.com/fangyawei-next/AFengBookCMS/blob/master/images/g1.PNG)
![image](https://github.com/fangyawei-next/AFengBookCMS/blob/master/images/g2.PNG)
![image](https://github.com/fangyawei-next/AFengBookCMS/blob/master/images/g3.PNG)
![image](https://github.com/fangyawei-next/AFengBookCMS/blob/master/images/g4.PNG)
![image](https://github.com/fangyawei-next/AFengBookCMS/blob/master/images/g5.PNG)
![image](https://github.com/fangyawei-next/AFengBookCMS/blob/master/images/g6.PNG)
![image](https://github.com/fangyawei-next/AFengBookCMS/blob/master/images/g7.PNG)
![image](https://github.com/fangyawei-next/AFengBookCMS/blob/master/images/g8.PNG)
![image](https://github.com/fangyawei-next/AFengBookCMS/blob/master/images/g9.PNG)

