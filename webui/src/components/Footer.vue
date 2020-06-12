<template>
    <div>
        <el-row>
            <div style="height: 5px; background-color: #68BF4A"></div>
        </el-row>
        <el-row class="links" type="flex" justify="center">
            <el-col :span="3">百度学术</el-col>
            <el-col :span="1">|</el-col>
            <el-col :span="3">百度学术</el-col>
            <el-col :span="1">|</el-col>
            <el-col :span="3">百度学术</el-col>
            <el-col :span="1">|</el-col>
            <el-col :span="3">百度学术</el-col>
            <el-col :span="1">|</el-col>
            <el-col :span="3">百度学术</el-col>
        </el-row>
        <el-row type="flex" justify="center" class="second">
            <el-col :span="2">人人托福</el-col>
            <el-col :span="1">|</el-col>
            <el-col :span="2">联系我们</el-col>
            <el-col :span="1">|</el-col>
            <el-col :span="2">招聘信息</el-col>
            <el-col :span="1">|</el-col>
            <el-col :span="2">合作媒体</el-col>
            <el-col :span="1">|</el-col>
            <el-col :span="2">意见反馈</el-col>
            <el-col :span="1">|</el-col>
            <el-col :span="2">版权说明</el-col>
        </el-row>
        <el-row type="flex" justify="center" class="copyright">
            ©2014 – xuanke.com All rights reserved. 京ICP备14022672号-1
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "Footer"
    }
</script>

<style scoped>
    .links {
        text-align: center;
        font-size: 1.4rem;
        background-color: #f0f0f0;
        padding-top: 2rem;
        padding-bottom: 2rem;
    }

    .second {
        padding-top: 30px;
        padding-bottom: 30px;
        background-color: black;
        color: white;
    }

    .second .el-col {
        text-align: center;
    }

    .copyright {
        background-color: black;
        color: white;
        padding-bottom: 20px;
    }
</style>