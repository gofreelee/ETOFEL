# 聊天部分的接口需求
## 1. 根据群名称模糊查询

### url:http://localhost:8777/Group/searchGroupByName (localhost根据部署再确定)

### 参数:   groupName : " "

### 返回值

[
    {
        "grpId": 3,
        "grpName": "dev群",
        "grpCreateTime": "2020-06-11 10:33:49.587",
        "grpDescription": "dev",
        "grpRule": "dev",
        "grpType": "dev",
        "grpPortrait": "dev",
        "grpCreator": "dev",
        "grpStatus": "dev"
    }
]

## 2. 根据类别查询群组
### url:  http://localhost:8777/group/searchGroupByType

### 参数： groupType : ""

### 返回值

[
    {
        "grpId": 2,
        "grpName": "update",
        "grpCreateTime": "2020-06-11 10:11:33.165",
        "grpDescription": "dev",
        "grpRule": "dev",
        "grpType": "dev",
        "grpPortrait": "dev",
        "grpCreator": "dev",
        "grpStatus": "dev"
    },
    {
        "grpId": 3,
        "grpName": "dev群",
        "grpCreateTime": "2020-06-11 10:33:49.587",
        "grpDescription": "dev",
        "grpRule": "dev",
        "grpType": "dev",
        "grpPortrait": "dev",
        "grpCreator": "dev",
        "grpStatus": "dev"
    }
]


## 3. 根据群Id查询群详细信息
### url:  http://localhost:8777/group/searchGroupInfo

### 参数： grpId : ""

### 返回值
{
    "baseInfo": {
        "grpId": 2,
        "grpName": "update",
        "grpCreateTime": "2020-06-11 10:11:33.165",
        "grpDescription": "dev",
        "grpRule": "dev",
        "grpType": "dev",
        "grpPortrait": "dev",
        "grpCreator": "dev",
        "grpStatus": "dev"
    },
    "groupMembers": 2,
    "managers": [
        {
            "gmbUsername": "苏苏苏",
            "userPortrait": null,
            "userType": "manager"
        }
    ],
    "members": [
        {
            "gmbUsername": "苏锐程",
            "userPortrait": null,
            "userType": "member"
        }
    ]
}

## 4. 根据群Id查询群详细信息
### url:  http://localhost:8777/group/searchMember

### 参数： grpId : ""  gmpType ： "member" / "manager"

### 返回值
[
    {
        "gmbUsername": "苏锐程",
        "userPortrait": null,
        "userType": "member"
    }
]

## 4. 获取群消息
### url:  http://localhost:8777/group/getMessage
### 参数：grpId  : " "    index : " "
### 返回值
[
    {
        "gmsId": 12,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:29.000+00:00"
    },
    {
        "gmsId": 13,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:30.000+00:00"
    },
    {
        "gmsId": 14,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:31.000+00:00"
    },
    {
        "gmsId": 15,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:32.000+00:00"
    },
    {
        "gmsId": 16,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:33.000+00:00"
    },
    {
        "gmsId": 17,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:34.000+00:00"
    },
    {
        "gmsId": 18,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:34.000+00:00"
    },
    {
        "gmsId": 19,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:35.000+00:00"
    },
    {
        "gmsId": 20,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:36.000+00:00"
    },
    {
        "gmsId": 21,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:37.000+00:00"
    },
    {
        "gmsId": 22,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:37.000+00:00"
    },
    {
        "gmsId": 23,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:38.000+00:00"
    },
    {
        "gmsId": 24,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:39.000+00:00"
    },
    {
        "gmsId": 25,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:39.000+00:00"
    },
    {
        "gmsId": 26,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:40.000+00:00"
    },
    {
        "gmsId": 27,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:41.000+00:00"
    },
    {
        "gmsId": 28,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:42.000+00:00"
    },
    {
        "gmsId": 29,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:42.000+00:00"
    },
    {
        "gmsId": 30,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:43.000+00:00"
    },
    {
        "gmsId": 31,
        "gmsGrpId": 2,
        "gmsUsername": "苏锐程",
        "gmsContext": "gmsContext",
        "gmsCreateTime": "2020-06-12T09:30:44.000+00:00"
    }
]

