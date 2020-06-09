# 数据库配置：
IP：cdb-b6fcgmw2.cd.tencentcdb.com 

端口：10053

数据库名：TOFEL

用户名：groupsix 
密码：chinasoft6

# 群聊功能
## AllGroups
群ID (主键)  管理员ID   建群时间  群介绍   群规则  群类型
(群成员)

user 表和 AllGroups需要进行关联， 新加一个表
## UserWithGroups
id(主键自增)  userId   groupId

## GroupMessages
id(主键自增)  userId  groupId  content  date

#登陆/注册功能
##User
id(主键自增) username password email
其他属性根据其他功能模块添加