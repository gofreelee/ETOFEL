# 管理员部分的接口需求

##系统管理-用户列表接口
###显示用户列表
url:/loginmodule/userlist/userlist
需要用户名、用户状态，数据库表中未设置用户等级这一属性

![](C:\Users\dell\Desktop\1.PNG)
###冻结用户
url:/loginmodule/userlist/updateUserToFrozen
需要选中用户的用户名

![](C:\Users\dell\Desktop\2.PNG)
###解冻用户
url:/loginmodule/userlist/updateUserToNormal
需要选中用户的用户名

![](C:\Users\dell\Desktop\3.PNG)
###删除用户
url:/loginmodule/userlist/deleteUser
需要选中用户的用户名

![](C:\Users\dell\Desktop\4.PNG)


## 2. 管理员查询课程接口

### url:http://localhost:8088/course/course/selectCourseDynamic

### 参数:   cosTitle:" ", cosCategory:" ", cdtTchUsername : " "

### 返回值

[
    {
        "cosId":1,
        "cosTitle":"托福口语",
        "cosStartDate":"六月 10, 2020",
        "cosEndDate":"六月 30, 2020",
        "cosStartTime":"09:00:00 上午",
        "cosEndTime":"12:00:00 下午",
        "cosFee":1830,
        "cosCategory":"口语",
        "cosStage":"周二",
        "cosStatus":"开课"
    },
    {
        "cosId":2,
        "cosTitle":"大胆开口读",
        "cosStartDate":"六月 24, 2020",
        "cosEndDate":"九月 15, 2020",
        "cosStartTime":"02:30:00 下午",
        "cosEndTime":"03:45:00 下午",
        "cosFee":1000,
        "cosCategory":"口语",
        "cosStage":"周一",
        "cosStatus":"报名中"
    },
    {
        "cosId":3,
        "cosTitle":"托福写作",
        "cosStartDate":"六月 23, 2020",
        "cosEndDate":"六月 15, 2021",
        "cosStartTime":"06:45:00 上午",
        "cosEndTime":"09:30:00 上午",
        "cosFee":0,
        "cosCategory":"写作",
        "cosStage":"周六",
        "cosStatus":"进行中"
    },
    {
        "cosId":4,
        "cosTitle":"托福阅读",
        "cosStartDate":"六月 9, 2020",
        "cosEndDate":"九月 1, 2020",
        "cosStartTime":"08:00:00 下午",
        "cosEndTime":"10:30:00 下午",
        "cosFee":1830,
        "cosCategory":"阅读",
        "cosStage":"周二",
        "cosStatus":"报名中"
    },
    {
        "cosId":5,
        "cosTitle":"听力如何拿高分",
        "cosStartDate":"六月 9, 2020",
        "cosEndDate":"九月 1, 2020",
        "cosStartTime":"08:00:00 下午",
        "cosEndTime":"10:30:00 下午",
        "cosFee":220,
        "cosCategory":"听力",
        "cosStage":"周二",
        "cosStatus":"报名中"
    },
    {
        "cosId":6,
        "cosTitle":"听力秘籍",
        "cosStartDate":"六月 9, 2020",
        "cosEndDate":"九月 1, 2020",
        "cosStartTime":"08:00:00 下午",
        "cosEndTime":"10:30:00 下午",
        "cosFee":3330,
        "cosCategory":"听力",
        "cosStage":"周日",
        "cosStatus":"报名中"
    },
    {
        "cosId":7,
        "cosTitle":"教你高效背单词",
        "cosStartDate":"六月 9, 2020",
        "cosEndDate":"九月 1, 2020",
        "cosStartTime":"08:00:00 下午",
        "cosEndTime":"10:30:00 下午",
        "cosFee":0,
        "cosCategory":"词汇",
        "cosStage":"周二",
        "cosStatus":"报名中"
    }
]    
## 管理员课程管理接口
### 功能：关闭课程
####url：http://localhost:8088/course/closeCourse
#### 参数： cosId（int）关闭课程的id
#### 返回值：void
### 功能：恢复课程
####url：http://localhost:8088/course/recoverCourse
#### 参数： cosId（int）恢复课程的id
#### 返回值：提示字符串。提示更改的状态（报名或停课）




