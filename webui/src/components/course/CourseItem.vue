<template>
    <el-container class="container">
        <el-aside style="padding-top: 20px; padding-bottom: 20px;">
            <el-image :src="courseImg" style="width: 300px; height: 200px"></el-image>
            <el-row style="text-align: center">
                RMB : 100
            </el-row>
        </el-aside>

        <el-main>
            <el-row class="course-title">
                托福口语强化班
            </el-row>
            <el-row class="course-info">
                上课时间
            </el-row>
            <el-row class="course-info">
                主讲老师
            </el-row>
            <el-row class="course-info">
                托福考什么，我们就背什么？不是让你去背几万个词汇，也不是让你去背那些高大上的、千奇百怪的词汇，我们就背托福要考的词汇，这里有阅读的夺命词汇、有听力的考点词、有口语的语料库，每天听写三场，每次只要30分钟，就能让你提前准备好托福考试所需要的各种词汇！1月-2月份的考生朋友们，赶紧参与进来吧！
                托福考什么，我们就背什么？不是让你去背几万个词汇，也不是让你去背那些高大上的、千奇百怪的词汇，我们就背托福要考的词汇，这里有阅读的夺命词汇、有听力的考点词、有口语的语料库，每天
            </el-row>
        </el-main>

        <el-aside style="width: 200px; padding-top: 20px; padding-bottom: 20px;text-align: right">
            <el-row class="course-choice">
                1000人参与
            </el-row>
            <el-row class="course-choice">
                <el-button type="primary" plain @click="toCourseDetail(1)">课程详情</el-button>
            </el-row>
            <el-row class="course-choice">
                <el-button type="primary" plain>我要学习</el-button>
            </el-row>
        </el-aside>
    </el-container>
</template>

<script>
    import router from "../../router";

    export default {
        name: "CourseItem",
        data() {
            return {
                courseImg: "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=11232128,2567744034&fm=26&gp=0.jpg"
            }
        },
        methods: {
            toCourseDetail(course_id) {
                console.log(course_id);
                router.push({path: '/course/course-detail'});
            }
        }
    }
</script>

<style scoped>
    .course-title {
        font-size: 1.4rem;
    }

    .course-info {
        margin-top: 10px;
        margin-bottom: 10px;
    }

    .course-choice {
        margin-top: 20px;
        margin-bottom: 20px
    }

    .container {
        border-style: solid;
        border-left-width: 0;
        border-right-width: 0;
        border-top-width: 0;
        border-bottom-width: 1px;
        border-bottom-color: #ededed;
        margin-left: 20px;
        margin-right: 20px;
        margin-top: 20px;
    }
</style>