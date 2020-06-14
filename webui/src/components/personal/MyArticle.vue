<template>
    <el-container>
        <el-main style="position: relative">

            <el-tabs type="card" v-model="activeTab">
                <el-tab-pane label="我点赞的文章" name="like">
                    <ArticleItem :is-mine="false" v-for="item in 4" :key="item"/>
                    <el-row style="text-align: right">
                        <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
                    </el-row>
                </el-tab-pane>
                <el-tab-pane label="我发布的文章" name="publish">
                    <ArticleItem :is-mine="true" v-for="item in 4" :key="item"/>
                    <el-row style="text-align: right">
                        <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
                    </el-row>
                </el-tab-pane>
            </el-tabs>

            <div style="position: absolute; left: 80%; top: 0">
                <el-button type="success" plain icon="el-icon-plus">发布新文章</el-button>
            </div>
        </el-main>
    </el-container>
</template>

<script>
    import ArticleItem from "./ArticleItem";

    export default {
        name: "MyArticle",
        components: {
            ArticleItem
        },
        data() {
            return {
                activeTab: 'like'
            }
        }
    }
</script>

<style scoped>
</style>