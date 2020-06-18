<template>
    <el-container>
        <el-main>
            <el-row class="title">
                我的公开课
            </el-row>
            <el-row v-for="item in courseShowed" :key="item.cosId">
                <CourseItem :course="item"/>
            </el-row>
            <el-row style="text-align: right">
                <el-pagination background layout="prev, pager, next"
                               :total="course.length"
                               :page-size="5"
                               @current-change="pageChange"/>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import CourseItem from "../personal/CourseItem";

    export default {
        name: "Course",
        components: {
            CourseItem
        },
        data() {
            return {
                course: [],
                currentPage: 1
            }
        },
        computed: {
            courseShowed() {
                let index = this.currentPage - 1;
                return this.course.slice(index * 4, index * 4 + 4);
            }
        },
        methods: {
            getJoinedCourse() {
                if (sessionStorage.getItem("identity") !== 'user') return;

                let config = {
                    method: 'get',
                    url: '/course/userJoinCourse/getJoinedCourse?ujcUsrUsername=' + sessionStorage.getItem("username"),
                };

                this.$axios(config).then(res => {
                    this.course = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            pageChange(currentPage) {
                this.currentPage = currentPage;
            }
        },
        mounted() {
            this.getJoinedCourse();
        }
    }
</script>

<style scoped>
    .title {
        font-size: 1.4rem;
    }
</style>