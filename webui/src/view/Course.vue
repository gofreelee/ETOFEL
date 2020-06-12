<template>
    <el-container>
        <el-header style="margin-top: 10px;">
            <el-row type="flex" align="middle" class="header-first">
                <el-col :span="2" offset="5">
                    公益商城
                </el-col>
                <el-col :span="2">
                    热门课程
                </el-col>
                <el-col :span="2">
                    名师精品课
                </el-col>
            </el-row>
        </el-header>
        <el-main style="margin-left: 15%; margin-right: 15%">
            <el-row class="header-second">
                <el-col :span="2" :offset="1">
                    全部课程
                </el-col>
                <el-col :span="2">
                    全部课程
                </el-col>
                <el-col :span="2">
                    全部课程
                </el-col>
                <el-col :span="2">
                    全部课程
                </el-col>
                <el-col :span="2">
                    全部课程
                </el-col>
                <el-col :span="3" :offset="8">
                    <i class="el-icon-arrow-down"/> 按开始时间排序
                </el-col>
            </el-row>

            <CourseItem v-for="item in 10" :key="item"/>
        </el-main>
    </el-container>
</template>

<script>
    import CourseItem from "../components/course/CourseItem";

    export default {
        name: "Course",
        components: {
            CourseItem
        }
    }
</script>

<style scoped>
    .header-first {
        background: #f0f0f0;
        padding-top: 15px;
        padding-bottom: 15px;
    }

    .header-second {
        border-style: solid;
        border-width: 1px;
        padding: 10px;
        border-radius: 10px;
        border-color: #ededed;
        background: aliceblue;
    }
</style>