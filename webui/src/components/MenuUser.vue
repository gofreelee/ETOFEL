<template>
    <el-row>
        <el-col :offset="4" :span="2">
            <p>首页</p>
        </el-col>
        <el-col :span="2">
            <p>托福人</p>
        </el-col >
        <el-col :span="2">
            <p>公开课</p>
        </el-col>
        <el-col :span="2">
            <p>群聊组</p>
        </el-col>
        <el-col :span="2">
            <p>福利城堡</p>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        name: "MenuUser"
    }
</script>

<style scoped>
    .el-row {
        background-color: #68BF4A;
    }

    p {
        font-size: 18px;
        color: white;
        margin: 0;
        padding: 1em;
        text-align: center;
    }

    p:hover {
        background-color: #063;
    }
</style>