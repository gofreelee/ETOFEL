<template>
    <el-container>
        <el-aside style="padding: 20px 20px 20px 0">
            <el-image :src="img" fit="fill" style="width: 100%"></el-image>
        </el-aside>
        <el-main>
            <el-row style="font-size: 1.4rem">
                课程标题
            </el-row>
            <el-row style="padding: 10px 0 10px 0">
                上课时间：
            </el-row>
            <el-row style="padding: 0 0 10px 0">
                主讲老师：
            </el-row>
        </el-main>
        <el-aside style="padding: 20px 0 20px 20px; text-align: center;">
            <el-row style="margin-bottom: 10px">
                <el-button type="primary" plain>课程明细</el-button>
            </el-row>
            <el-row>
                <el-button type="primary" plain>退课</el-button>
            </el-row>
        </el-aside>
    </el-container>
</template>

<script>
    export default {
        name: "CourseItem",
        data() {
            return {
                'img': 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=11232128,2567744034&fm=26&gp=0.jpg'
            }
        }
    }
</script>

<style scoped>

</style>