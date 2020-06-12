<template>
    <el-container style="padding-left: 15%; padding-right: 15%">
        <el-main>
            <el-row type="flex" justify="space-around">
                <el-col :span="12">
                    <ArticleList type="Listening"/>
                </el-col>
                <el-col :span="12">
                    <ArticleList type="Speaking"/>
                </el-col>
            </el-row>
            <el-row type="flex" justify="space-around">
                <el-col :span="12">
                    <ArticleList type="Listening"/>
                </el-col>
                <el-col :span="12">
                    <ArticleList type="Speaking"/>
                </el-col>
            </el-row>
            <el-row type="flex" justify="space-around">
                <el-col :span="12">
                    <ArticleList type="Listening"/>
                </el-col>
                <el-col :span="12">
                    <ArticleList type="Speaking"/>
                </el-col>
            </el-row>
            <el-row type="flex" justify="space-around">
                <el-col :span="12">
                    <ArticleList type="Listening"/>
                </el-col>
                <el-col :span="12">
                    <ArticleList type="Speaking"/>
                </el-col>
            </el-row>
        </el-main>
        <el-aside style="width: 35%">
            <!--热门小组-->
            <el-row type="flex" align="middle" style="font-size: 1.3rem; margin-top: 40px">
                <el-col :span="18">
                    热门小组
                </el-col>
                <el-col :span="6">
                    <el-button type="text" icon="el-icon-refresh">换一批</el-button>
                </el-col>
            </el-row>
            <HomeGroup v-for="item in 4" :key="item"/>
        </el-aside>
    </el-container>
</template>

<script>
    import HomeGroup from "../components/home/HomeGroup";
    import ArticleList from "../components/article/ArticleList";

    export default {
        name: "TofelArticle",
        components: {
            HomeGroup,
            ArticleList
        }
    }
</script>

<style scoped>
    .el-aside {
        padding: 20px 20px 20px 40px;
    }
</style>