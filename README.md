# Student-Paper-Management-Web
A Web Project for Administering Papers of Students
* * *
## 实验室研究生论文管理网站
* * *
* 实现学生用户登录/注册/管理功能
* 实现学生个人论文管理功能
* 拥有超级管理员登录/操作功能
## 实施细节
* * *
* 使用Tomcat作为服务器
* 使用MySQL作为数据库，保存学生用户信息/论文信息/管理员用户信息
* 采用悲观锁策略以应对并发情况
* Html+JSP+Servlet实现基本功能
## 文件
* * *
* WebApps为网站应用主文件
* src为java源码
  * com/dao/文件夹：是用户数据库访问接口
  * com/entity/文件夹：是用户/管理员实例类
  * com/filter/文件夹：是过滤器实例类，完成字符编码转换、网站权限验证功能
  * com/servlers/文件夹：是Servlet实例类，完成服务端功能
  * com/util/文件夹：完成对数据库访问接口的封装
  
