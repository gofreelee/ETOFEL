<template>
    <el-container>
        <el-main style="padding-top: 0">
            <el-row class="title">
                课程安排
            </el-row>
            <el-row class="context">
                {{courseDetail.cdtPlan}}
            </el-row>
            <el-row class="title">
                上课方式
            </el-row>
            <el-row class="context">
                {{courseDetail.cdtPattern}}
            </el-row>
            <el-row class="title">
                听课指南
            </el-row>
            <el-row class="context">
                {{courseDetail.cdtGuide}}
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "CourseDescription",
        props: {
            courseDetail: Object
        }
    }
</script>

<style scoped>
    .title {
        font-size: 1.4rem;
        margin-top: 30px;
    }

    .context {
        margin-top: 10px;
    }
</style>