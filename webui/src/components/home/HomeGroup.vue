<template>
    <el-container>
        <el-aside style="width: 100px">
            <img src="../../assets/logo.png" alt="logo"/>
        </el-aside>
        <el-main>
            <el-row type="flex">
                <el-col :span="12" style="color: #68BF4A; font-size: 1.2rem">
                    标题
                </el-col>
                <el-col :span="12" style="text-align: right">
                    <i class="el-icon-connection"/>多少人加入
                </el-col>
            </el-row>
            <el-row style="margin-top: 8px">
                这是一个非常热门的组这是一个非常热门的组这是一个非常热门的组这是一个非常热门的组
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "HomeGroup"
    }
</script>

<style scoped>
    .el-aside {
        overflow: hidden;
    }

    .el-aside img {
        width: 100px;
        height: 100px;
    }
</style>