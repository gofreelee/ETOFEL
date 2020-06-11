# 数据库配置：

IP：cdb-b6fcgmw2.cd.tencentcdb.com 

端口：10053

数据库名：TOFEL

用户名：groupsix 
密码：chinasoft6

# 数据库设计

## 群聊功能

### AllGroups

群ID (主键)  建群时间  群介绍   群规则  群类型  群头像  群名称
(群成员)

user 表和 AllGroups需要进行关联， 新加一个表

### UserWithGroups

userId   groupId

### GroupManager
  
groupId  管理员ID

### GroupMessages

id(主键自增)  userId  groupId  content  date

## 登陆/注册功能

### User

userId(主键自增) username password email tab(用户等级，分普通用户和管理员)
其他属性根据其他功能模块添加

## 公开课

## OpenCourse

id(主键自增)  ocName(公开课名称) ocSyllabus(课程大纲) ocTeacher(授课教师) studentNum(报名的学生数量) ocDate(课程日期) suitStudent(适合的学生) ocArragement(课程安排) ocPlace(课程地点) ocGuide(公开课听课指导)

### Teacher

id(主键自增) teacherName(教师的姓名) motto(座右铭) gender(教师的性别) education(教师的学历) recentCourse(教师的最新课程) articleNum(发布文章数量) openCourseNum(公开课数量) welCCNum(福利城堡课程数量) likeNum(教师收到的赞) comment(收到的评价)

### FamousTeacher

id(主键自增) teacherId(老师的id) briefIntro(老师的推荐语) likeNum(被喜欢的人数)

# 前端接口需求

## 主页托福人推荐

一次推荐5篇文章，可按时间排序

需要内容：配图、标题、简介、分类、发布时间

<img src="https://i.loli.net/2020/06/11/3moY4phGCIs6WKb.jpg" width="400"/>

## 主页热门群聊组推荐

一次推荐4个热门群聊组，可按加入人数排序

需要内容：小组头像、群聊名、群聊简介、加入人数

<img src="https://i.loli.net/2020/06/11/UcLlTMKrviGJogI.jpg" width="300"/>

## 主页公开课推荐

一次推荐4个公开课，可按时间或报名人数排序

需要内容：配图、标题、老师、开课时间

<img src="https://i.loli.net/2020/06/11/mM4hc8Lo7AI6R3G.jpg" width="300"/>