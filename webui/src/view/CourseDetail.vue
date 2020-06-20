<template>
    <el-container style="margin: 30px 10% 0 20%" direction="vertical">
        <el-container>
            <el-aside style="width: 45%">
                <img :src="courseDetail.cdtPortrait" style="width: 100%"/>
            </el-aside>
            <el-main>
                <el-row class="course-title">
                    {{course.cosTitle}}
                </el-row>
                <el-row class="course-info">
                    {{course.cosStartDate}}-{{course.cosEndDate}}
                </el-row>
                <el-row style="padding-bottom: 20px">
                    {{course.cosStartTime}}-{{course.cosEndTime}}
                </el-row>
                <el-row type="flex" align="middle">
                    <el-col :span="6">
                        主讲人: {{courseDetail.cdtTchUsername}}
                    </el-col>
                </el-row>
                <el-col style="padding-top: 15px; padding-bottom: 20px;">
                    <el-col :span="6">
                        上课周期: {{course.cosStage}}
                    </el-col>
                </el-col>
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
                    <el-col :span="12">
                        已报名人数：{{joinNumber}}
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="6">
                        <el-button type="danger" style="width: 100%" @click="joinCourse">立刻报名</el-button>
                    </el-col>
                    <el-col :span="6">
                        <el-button type="primary" plain style="width: 100%" @click="toGroupInformation">查看课程群</el-button>
                    </el-col>
                </el-row>
            </el-main>
        </el-container>

        <el-main style="margin-right: 20%">
            <el-tabs type="card" v-model="activeTabName">
                <el-tab-pane label="课程介绍" name="courseDescription">
                    <CourseDescription :course-detail="courseDetail" v-if="courseDetail != null"/>
                </el-tab-pane>
                <el-tab-pane label="教师介绍" name="teacherDescription">
                    <TeacherDescription :teacher="teacher" v-if="courseDetail != null"/>
                </el-tab-pane>
            </el-tabs>
        </el-main>

    </el-container>
</template>

<script>
    import CourseDescription from "../components/course/CourseDescription";
    import TeacherDescription from "../components/course/TeacherDescription";
    import router from "../router";

    export default {
        name: "CourseDetail",
        components: {
            CourseDescription,
            TeacherDescription
        },
        data() {
            return {
                activeTabName: 'courseDescription',
                courseDetail: '',
                course: null,
                joinNumber: 0,
                teacher: null
            }
        },
        methods: {
            toGroupInformation() {
                router.push({path: '/group/group-information', query: {group_id: this.courseDetail.cdtGrpId}})
            },
            getCourse() {
                let url = "/course/course/getCourseByCosId?cosId=" + this.$route.query.course_id;
                this.$axios.get(url).then(res => {
                    this.course = res.data;
                })
            },
            getCourseDetail() {
                let url = "/course/courseDetail/getCourseDetail?cdtCosId=" + this.$route.query.course_id;
                this.$axios.get(url).then(res => {
                    this.courseDetail = res.data;
                    this.getTeacher();
                });
            },
            getTeacher() {
                let url = "/user/teacher/info?tch_username=" + this.courseDetail.cdtTchUsername;
                this.$axios.get(url).then(res => {
                    this.teacher = res.data;
                })
            },
            getJoinNumber() {
                let url = "/course/userJoinCourse/countCourseJoin?ujcCosId=" + this.$route.query.course_id;
                this.$axios.get(url).then(res => {
                    this.joinNumber = res.data;
                });
            },
            joinCourse() {
                let data = new FormData();
                data.append('ujcCosId', this.$route.query.course_id);
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
            this.getCourse();
            this.getCourseDetail();
            this.getJoinNumber();
        }
    }
</script>

<style scoped>
    .course-title {
        font-size: 2rem;
    }

    .course-info {
        line-height: 3;
    }

    .share-icon {
        font-size: 1.6rem;
        border: solid 1px;
        padding-top: 5px;
        padding-bottom: 5px;
    }
</style>