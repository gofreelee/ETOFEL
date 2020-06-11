<template>
    <el-container>
        <el-aside style="width: 100px; height: 100px; overflow: hidden">
            <div class="date">
                十二月<br>
                28
            </div>
        </el-aside>
        <el-main style="padding: 10px">
            <el-row style="font-size: 1.2rem">
                标题
            </el-row>
            <el-row style="margin-top: 10px">
                老师：地方是的
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "HomeCourse"
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