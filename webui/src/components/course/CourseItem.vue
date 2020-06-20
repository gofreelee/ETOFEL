<template>
    <el-container class="container">
        <el-aside style="padding-top: 20px; padding-bottom: 20px;">
            <img :src="courseDetail.cdtPortrait" style="width: 300px; height: 200px" alt="图片"/>
            <el-row style="text-align: center">
                RMB : {{course.cosFee}}
            </el-row>
        </el-aside>

        <el-main>
            <el-row class="course-title">
                {{course.cosTitle}}
            </el-row>
            <el-row class="course-info">
                上课日期: {{course.cosStartDate}}-{{course.cosEndDate}} 上课时间: {{course.cosStartTime}}-{{course.cosEndTime}}
            </el-row>
            <el-row class="course-info">
                主讲老师 : {{courseDetail.cdtTchUsername}}
            </el-row>
            <el-row class="course-info">
                {{courseDetail.cdtPlan}}
            </el-row>
        </el-main>

        <el-aside style="width: 200px; padding-top: 20px; padding-bottom: 20px;text-align: right">
            <el-row class="course-choice">
                {{joinNumber}}人参与
            </el-row>
            <el-row class="course-choice">
                <el-button type="primary" plain @click="toCourseDetail(course.cosId)">课程详情</el-button>
            </el-row>
            <el-row class="course-choice">
                <el-button type="primary" plain @click="joinCourse">我要学习</el-button>
            </el-row>
        </el-aside>
    </el-container>
</template>

<script>
    import router from "../../router";

    export default {
        name: "CourseItem",
        props: {
            course: Object
        },
        data() {
            return {
                courseDetail: '',
                joinNumber: 0
            }
        },
        methods: {
            toCourseDetail(course_id) {
                router.push({path: '/course/course-detail', query: {course_id: course_id}});
            },
            getCourseDetail() {
                let url = "/course/courseDetail/getCourseDetail?cdtCosId=" + this.course.cosId;
                this.$axios.get(url).then(res => {
                    this.courseDetail = res.data;
                });
            },
            getJoinNumber() {
                let url = "/course/userJoinCourse/countCourseJoin?ujcCosId=" + this.course.cosId;
                this.$axios.get(url).then(res => {
                    this.joinNumber = res.data;
                });
            },
            joinCourse() {
                let data = new FormData();
                data.append('ujcCosId', this.course.cosId);
                data.append('ujcUsrUsername', sessionStorage.getItem("username"));

                let config = {
                    method: 'post',
                    url: '/course/userJoinCourse/joinCourse',
                    data: data
                };

                this.$axios(config).then(res => {
                    console.log(res.data);
                    alert("加入课程成功")
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        mounted() {
            this.getCourseDetail();
            this.getJoinNumber();
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