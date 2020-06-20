<template>
    <el-container>
        <el-aside style="padding: 20px 20px 20px 0">
            <img :src="courseDetail.cdtPortrait"
                 style="width: 100%; height: 150px; object-fit: fill" alt="图片"/>
        </el-aside>
        <el-main>
            <el-row style="font-size: 1.4rem">
                {{course.cosTitle}}
            </el-row>
            <el-row style="padding: 10px 0 10px 0">
                上课日期: {{course.cosStartDate}} - {{course.cosEndDate}}
            </el-row>
            <el-row style="padding: 0 0 10px 0">
                上课时间: {{course.cosStartTime}} - {{course.cosEndTime}}
            </el-row>
            <el-row style="padding: 0 0 10px 0">
                主讲老师: {{courseDetail.cdtTchUsername}}
            </el-row>
        </el-main>
        <el-aside style="padding: 20px 0 20px 20px; text-align: center;">
            <el-row style="margin-bottom: 10px">
                <el-button type="primary" plain @click="toCourseDetail">课程明细</el-button>
            </el-row>
            <el-row>
                <el-button type="primary" plain v-if="status.ujcStatus === '已支付'">我要退课</el-button>
                <el-button type="primary" plain v-if="status.ujcStatus === '未支付'">付款</el-button>
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
                'img': 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=11232128,2567744034&fm=26&gp=0.jpg',
                status: '',
                courseDetail: ''
            }
        },
        methods: {
            toCourseDetail() {
                router.push({path: '/course/course-detail', query: {course_id: this.course.cosId}});
            },
            getJoinedStatus() {
                if (sessionStorage.getItem("identity") !== 'user') return;

                let config = {
                    method: 'get',
                    url: '/course/userJoinCourse/getJoinedStatus?ujcUsrUsername=' + sessionStorage.getItem("username") + '&ujcCosId=' + this.course.cosId,
                    headers: {}
                };

                this.$axios(config).then(res => {
                    this.status = res.data;
                    console.log(this.status);
                }).catch(function (error) {
                    console.log(error);
                });
            },
            getCourseDetail() {
                let url = "/course/courseDetail/getCourseDetail?cdtCosId=" + this.course.cosId;
                this.$axios.get(url).then(res => {
                    this.courseDetail = res.data;
                });
            }
        },
        mounted() {
            this.getJoinedStatus();
            this.getCourseDetail();
        }
    }
</script>

<style scoped>

</style>