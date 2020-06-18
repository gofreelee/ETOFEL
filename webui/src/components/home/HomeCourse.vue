<template>
    <el-container>
        <el-aside style="width: 100px; height: 100px; overflow: hidden">
            <div class="date">
                {{course.cosStartDate}}
            </div>
        </el-aside>
        <el-main style="padding: 10px">
            <el-row style="font-size: 1.2rem; cursor: pointer" @click.native="toCourseDetail">
                {{course.cosTitle}}
            </el-row>
            <el-row style="margin-top: 10px">
                老师：{{course.cdtTchUsername}}
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import router from "../../router";

    export default {
        name: "HomeCourse",
        props: {
            course: Object
        },
        methods: {
            toCourseDetail() {
                router.push({path: '/course/course-detail', query: {course_id: this.course.cosId}});
            }
        }
    }
</script>

<style scoped>
    .date {
        margin: 10px;
        background-color: #f0f0f0;
        width: 80px;
        height: 80px;
        display: flex;
        flex-direction: column;
        text-align: center;
        justify-content: center;
        font-size: 1.1rem;
    }
</style>