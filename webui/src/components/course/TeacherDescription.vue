<template>
    <el-container direction="vertical">
        <el-container>
            <el-aside>
                <el-image :src="teacherPortrait" fit="fill" style="width: 100%"></el-image>
            </el-aside>
            <el-main style="margin-left: 20px">
                <el-row style="font-size: 1.4rem">
                    讲师姓名：余坚
                </el-row>
                <el-row style="margin-top: 15px; margin-bottom: 15px;">
                    邮箱：余坚
                </el-row>
                <el-row style="margin-top: 15px; margin-bottom: 15px;">
                    性别：男
                    <el-divider direction="vertical"></el-divider>
                    学历：博士
                </el-row>
                <el-row style="margin-top: 15px; margin-bottom: 15px;">
                    <el-col :span="4">
                        发表文章：3
                    </el-col>
                    <el-col :span="4">
                        主讲课程：3
                    </el-col>
                    <el-col :span="4">
                        关注人数：3
                    </el-col>
                </el-row>
                <el-row>
                    教师简介
                </el-row>
            </el-main>
        </el-container>
        <el-main>
            <el-tabs type="card" v-model="activeTabName">
                <el-tab-pane label="发表文章" name="articles">
                    <el-row type="flex" align="middle" class="article" v-for="item in 10" :key="item">
                        <el-col :span="8" style="font-size: 1.2rem; font-weight: bold">
                            每天一点托福单词
                        </el-col>
                        <el-col :span="8" style="text-align: center">
                            文章类型：托福口语
                        </el-col>
                        <el-col :span="8" style="text-align: right">
                            发表时间：托福口语
                        </el-col>
                    </el-row>
                </el-tab-pane>
                <el-tab-pane label="学生评价" name="comment">
                    <GroupChatBox/>
                    <el-row style="text-align: right">
                        <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
                    </el-row>
                    <el-row>
                        文章评论 200
                    </el-row>
                    <el-row style="margin-top: 20px; margin-bottom: 20px">
                        <el-input type="textarea" :rows="6" placeholder="请输入您的评论" v-model="comment"></el-input>
                    </el-row>
                    <el-row>
                        <el-col :span="8" :push="16" style="text-align: right">
                            <el-button type="success">提交评论</el-button>
                        </el-col>
                    </el-row>
                </el-tab-pane>
            </el-tabs>
        </el-main>
    </el-container>
</template>

<script>
    import GroupChatBox from "../group/GroupChatBox";

    export default {
        name: "TeacherDescription",
        components: {
            GroupChatBox
        },
        data() {
            return {
                activeTabName: 'articles',
                teacherPortrait: 'http://img0.imgtn.bdimg.com/it/u=1803056350,344909414&fm=11&gp=0.jpg'
            }
        }
    }
</script>

<style scoped>
    .article {
        cursor: pointer;
        border: solid 1px #68BF4A;
        border-radius: 10px;
        padding: 10px 20px 10px 20px;
        margin: 20px 10px 20px 10px;
    }
</style>