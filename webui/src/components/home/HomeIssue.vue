<template>
    <el-container>
        <el-aside style="width: 40%">
            <img src="../../assets/logo.png" alt="logo"/>
        </el-aside>
        <el-main>
            <el-row>
                <el-col :span="16">
                    <p class="title">托福人标题</p>
                </el-col>
                <el-col :span="8">
                    <el-button type="success" round>托福口语</el-button>
                </el-col>
            </el-row>
            <el-row>
                <p class="description">dfjskldjfsldjgfdkhlgkjflkjdklgjfsdncfddsfsdfsdfsfsdflkjfdsajgfdjlsakdjfgklasgjfdlkfgjl</p>
            </el-row>
            <el-row>
                2020-5-23
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "HomeIssue"
    }
</script>

<style scoped>
    .el-aside {
        overflow: hidden;
    }

    .el-aside img {
        width: 100%;
        height: 240px;
    }

    .el-button {
        padding-top: 6px;
        padding-bottom: 6px;
        font-size: 1rem;
    }

    .title {
        font-size: 2rem;
        margin-top: 0.4rem;
    }

    .description {
        word-wrap: break-word;
        margin-top: 0;
        font-size: 1.2rem;
    }
</style>