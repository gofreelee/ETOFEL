<template>
    <el-container direction="vertical">
        <el-container>
            <el-aside>
                <img :src="teacher.tch_portrait" style="width: 100%"/>
            </el-aside>
            <el-main style="margin-left: 20px">
                <el-row style="font-size: 1.4rem">
                    讲师姓名: {{teacher.tch_name}}
                </el-row>
                <el-row style="margin-top: 15px; margin-bottom: 15px;">
                    邮箱: {{teacher.tch_email}}
                </el-row>
                <el-row style="margin-top: 15px; margin-bottom: 15px;">
                    性别: {{teacher.tch_gender}}
                    <el-divider direction="vertical"></el-divider>
                    学历: {{teacher.tch_education}}
                </el-row>
                <el-row>
                    {{teacher.tch_description}}
                </el-row>
            </el-main>
        </el-container>
        <!--        <el-main>-->
        <!--            <el-tabs type="card" v-model="activeTabName">-->
        <!--                <el-tab-pane label="发表文章" name="articles">-->
        <!--                    <el-row type="flex" align="middle" class="article" v-for="item in 10" :key="item">-->
        <!--                        <el-col :span="8" style="font-size: 1.2rem; font-weight: bold">-->
        <!--                            每天一点托福单词-->
        <!--                        </el-col>-->
        <!--                        <el-col :span="8" style="text-align: center">-->
        <!--                            文章类型：托福口语-->
        <!--                        </el-col>-->
        <!--                        <el-col :span="8" style="text-align: right">-->
        <!--                            发表时间：托福口语-->
        <!--                        </el-col>-->
        <!--                    </el-row>-->
        <!--                </el-tab-pane>-->
        <!--                <el-tab-pane label="学生评价" name="comment">-->
        <!--                    <GroupChatBox/>-->
        <!--                    <el-row style="text-align: right">-->
        <!--                        <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>-->
        <!--                    </el-row>-->
        <!--                    <el-row>-->
        <!--                        文章评论 200-->
        <!--                    </el-row>-->
        <!--                    <el-row style="margin-top: 20px; margin-bottom: 20px">-->
        <!--                        <el-input type="textarea" :rows="6" placeholder="请输入您的评论" v-model="comment"></el-input>-->
        <!--                    </el-row>-->
        <!--                    <el-row>-->
        <!--                        <el-col :span="8" :push="16" style="text-align: right">-->
        <!--                            <el-button type="success">提交评论</el-button>-->
        <!--                        </el-col>-->
        <!--                    </el-row>-->
        <!--                </el-tab-pane>-->
        <!--            </el-tabs>-->
        <!--        </el-main>-->
    </el-container>
</template>

<script>
    export default {
        name: "TeacherDescription",
        props: {
            teacher: Object
        },
        data() {
            return {
                activeTabName: 'articles',
                comment: ''
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