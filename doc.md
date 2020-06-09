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

id(主键自增) username password email tab(用户等级，分普通用户和管理员)
其他属性根据其他功能模块添加

# 公开课

## OpenCourse

id(主键自增)  ocName(公开课名称) ocSyllabus(课程大纲) ocTeacher(授课教师) studentNum(报名的学生数量) ocDate(课程日期) suitStudent(适合的学生) ocArragement(课程安排) ocPlace(课程地点) ocGuide(公开课听课指导)

## Teacher

id(主键自增) teacherName(教师的姓名) motto(座右铭) gender(教师的性别) education(教师的学历) recentCourse(教师的最新课程) articleNum(发布文章数量) openCourseNum(公开课数量) welCCNum(福利城堡课程数量) likeNum(教师收到的赞) comment(收到的评价)

## FamousTeacher

id(主键自增) teacherId(老师的id) briefIntro(老师的推荐语) likeNum(被喜欢的人数)