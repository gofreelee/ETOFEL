<template>
    <el-container style="margin: 30px 10% 0 20%" direction="vertical">
        <el-container>
            <el-aside style="width: 45%">
                <el-image :src="img" :fit="fill" style="width: 100%"></el-image>
            </el-aside>
            <el-main>
                <el-row class="course-title">
                    这门课非常好
                </el-row>
                <el-row class="course-info">
                    课程时间
                </el-row>
                <el-row type="flex" align="middle" style="text-align: center">
                    <el-col :span="2">
                        <el-image :src="img" style="width: 100%" :fit="fill"></el-image>
                    </el-col>
                    <el-col :span="6">
                        主讲人：天天
                    </el-col>
                    <el-divider direction="vertical"></el-divider>
                    <el-col :span="6">
                        上课方式：天天
                    </el-col>
                </el-row>
                <el-row style="margin-top: 25px; margin-bottom: 15px; text-align: center">
                    <el-col :span="2" class="share-icon">
                        <i class="fa fa-weixin"/>
                    </el-col>
                    <el-col :span="2" class="share-icon">
                        <i class="fa fa-qq"/>
                    </el-col>
                    <el-col :span="2" class="share-icon">
                        <i class="fa fa-weibo"/>
                    </el-col>
                    <el-col :span="2" class="share-icon">
                        <i class="fa fa-tencent-weibo"/>
                    </el-col>
                </el-row>
                <el-row class="course-info">
                    <el-col :span="6">
                        倒计时：天天
                    </el-col>
                    <el-col :span="1">
                        <el-divider direction="vertical"></el-divider>
                    </el-col>
                    <el-col :span="6">
                        已报名人数：天天
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="6">
                        <el-button type="danger" style="width: 100%">立刻报名</el-button>
                    </el-col>
                    <el-col :span="6">
                        <el-button type="primary" plain style="width: 100%">查看课程群</el-button>
                    </el-col>
                </el-row>
            </el-main>
        </el-container>
        <el-main style="margin-right: 20%">
            <el-tabs type="card" v-model="activeTabName">
                <el-tab-pane label="课程介绍" name="courseDescription">
                    <CourseDescription/>
                </el-tab-pane>
                <el-tab-pane label="教师介绍" name="teacherDescription">
                    <TeacherDescription/>
                </el-tab-pane>
            </el-tabs>
        </el-main>
    </el-container>
</template>

<script>
    import CourseDescription from "../components/course/CourseDescription";
    import TeacherDescription from "../components/course/TeacherDescription";

    export default {
        name: "CourseDetail",
        components: {
            CourseDescription,
            TeacherDescription
        },
        data() {
            return {
                activeTabName: 'courseDescription',
                img: "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=336492172,12372647&fm=26&gp=0.jpg"
            }
        }
    }
</script>

<style scoped>
    .course-title {
        font-size: 2rem;
    }

    .course-info {
        line-height: 4;
    }

    .share-icon {
        font-size: 1.6rem;
        border: solid 1px;
        padding-top: 5px;
        padding-bottom: 5px;
    }
</style>