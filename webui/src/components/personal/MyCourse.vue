<template>
    <el-container>
        <el-main>
            <el-row class="title">
                我的公开课
            </el-row>
            <CourseItem v-for="item in 4" :key="item"/>
            <el-row style="text-align: right">
                <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
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
            return {}
        }
    }
</script>

<style scoped>
    .title {
        font-size: 1.4rem;
    }
</style>