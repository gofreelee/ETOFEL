<template>
    <el-row type="flex" align="middle">
        <el-col :span="8" :offset="4">
            <img src="../assets/logo.png" alt="logo">
        </el-col>
        <el-col :span="2">
            请登录
        </el-col>
        <el-col :span="2">
            <i class="el-icon-bell">消息</i>
        </el-col>
        <el-col :span="4">
            <el-button type="success">登录</el-button>
            <el-button type="success">注册</el-button>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>

</style>