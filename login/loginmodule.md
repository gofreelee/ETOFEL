# 登陆部分及系统管理-用户列表接口需求部分的接口需求
##注：登陆部分涉及验证码，如果验证码部分有问题，及时联系我进行修改
## 1. 用户登陆

### url: http://localhost:8089/loginmodule/user/ulogin (localhost根据部署再确定)

### 参数:   username:" " password:" "

### 返回值

登陆用户的json字符串

## 2. 用户注册
### url: http://localhost:8089/loginmodule/user/register (localhost根据部署再确定)

### 参数： username:" " password:" " email:" "

### 返回值

注册用户的json字符串


## 3. 老师登陆
### url: http://localhost:8089/loginmodule/teacher/tlogin (localhost根据部署再确定)

### 参数： username:" " password:" "

### 返回值

登陆老师的json字符串

## 4. 管理员登录
### url: http://localhost:8089/loginmodule/administer/alogin (localhost根据部署再确定)

### 参数： username:" " password:" "

### 返回值

登陆管理员的json字符串

## 5. 系统管理—用户列表 显示用户列表
### url: http://localhost:8089/loginmodule/userlist/userlist (localhost根据部署再确定)

### 参数： username:" " state:"normal/frozen"

### 返回值

符合条件的用户列表json字符串

## 6. 系统管理—用户列表 冻结用户
### url: http://localhost:8089/loginmodule/userlist/updateUserToFrozen (localhost根据部署再确定)

### 参数： username:" " （选中用户的username）

### 返回值

被冻结用户的json字符串

## 7. 系统管理-用户列表 解冻用户
### url: http://localhost:8089/loginmodule/userlist/updateUserToNormal (localhost根据部署再确定)

### 参数： username:" " （选中用户的username）

### 返回值

被解冻用户的json字符串

## 8. 系统管理-用户列表 删除用户
### url: http://localhost:8089/loginmodule/userlist/deleteUser (localhost根据部署再确定)

### 参数： username:" " （选中用户的username）

### 返回值

被删除用户的json字符串


