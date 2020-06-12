<template>
    <el-container>
        <el-main>
            <el-row style="padding-top: 100px" class="group-info-title">
                <el-col :span="4">
                    <el-image :src="groupPortrait" style="width: 200px; height: 200px"/>
                </el-col>
                <el-col :span="14">
                    <el-row style="font-weight: bold; font-size: 2.8rem">
                        哈哈哈哈哈哈哈哈哈
                    </el-row>
                    <el-row style="margin-top: 10px; margin-bottom: 20px">
                        建群时间2020-9-10 | 1479人已加入
                    </el-row>
                    <el-row>
                        dfjslkdfjlkdhgdjfdlkjslk
                    </el-row>
                </el-col>
                <el-col :span="4">
                    <el-row type="flex" justify="center" style="margin-top: 20px">
                        <el-button type="primary" icon="el-icon-chat-dot-round">进群聊天</el-button>
                    </el-row>
                    <el-row type="flex" justify="center" style="text-align: center; margin-top: 10px">
                        <el-col :span="8">
                            已加入
                        </el-col>
                        <el-col :span="8">
                            退出该群
                        </el-col>
                    </el-row>
                </el-col>
            </el-row>
            <el-row type="flex" align="middle" style="margin-top: 50px">
                <el-col :span="4" style="font-size: 3rem">
                    群介绍
                </el-col>
                <el-col :span="1">
                    <img src="../assets/qzl_CyInfoDl.png" style="object-fit: fill"/>
                </el-col>
                <el-col :span="18">
                    dfskdfjsldkfjsdlkfjlk
                    <br/>
                    dfskdfjsldkfjsdlkfjlk
                    <br/>
                    dfskdfjsldkfjsdlkfjlk
                    <br/>
                    dfskdfjsldkfjsdlkfjlk
                    <br/>dfskdfjsldkfjsdlkfjlk
                    <br/>
                </el-col>
            </el-row>
            <el-row type="flex" align="middle" style="margin-top: 30px">
                <el-col :span="4" style="font-size: 3rem">
                    群规则
                </el-col>
                <el-col :span="1">
                    <img src="../assets/qzl_CyInfoDl.png" style="object-fit: fill"/>
                </el-col>
                <el-col :span="18">
                    dfskdfjsldkfjsdlkfjlk
                    <br/>
                    dfskdfjsldkfjsdlkfjlk
                    <br/>
                    dfskdfjsldkfjsdlkfjlk
                    <br/>
                    dfskdfjsldkfjsdlkfjlk
                    <br/>dfskdfjsldkfjsdlkfjlk
                    <br/>
                </el-col>
            </el-row>
            <el-row class="admin-title">
                管理员
            </el-row>
            <el-row :gutter="20">
                <el-col :span="2" v-for="item in 10" :key="item" style="margin-top: 20px">
                    <el-row>
                        <el-image :src="groupPortrait"></el-image>
                    </el-row>
                    <el-row style="text-align: center">
                        陈熳熳
                    </el-row>
                </el-col>
            </el-row>
            <el-row class="admin-title">
                群成员
            </el-row>
            <el-row :gutter="20">
                <el-col :span="2" v-for="item in 10" :key="item" style="margin-top: 20px">
                    <el-row>
                        <el-image :src="groupPortrait"></el-image>
                    </el-row>
                    <el-row style="text-align: center">
                        陈熳熳
                    </el-row>
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "GroupInformation",
        data() {
            return {
                groupPortrait: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"
            }
        }
    }
</script>

<style scoped>
    .el-main {
        margin-left: 15%;
        margin-right: 15%;
        margin-top: 20px;
    }

    .group-info-title {
        background-image: url('https://cn.vuejs.org/images/components.png');
        background-size: 100% 100%;
    }

    .admin-title {
        margin-top: 60px;
        border-top: solid 1px #ededed;
        line-height: 60px;
        font-size: 2rem;
        background: url("../assets/classInfo_Button.png") 0 -195px no-repeat;
        padding-left: 10px;
    }
</style>