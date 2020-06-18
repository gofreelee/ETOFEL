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
                <el-tab-pane label="我发布的文章" name="published">
                    <el-row v-for="item in myArticleShow" :key="item.art_id">
                        <ArticleItem :is-mine="true" :article="item"/>
                    </el-row>
                    <el-row style="text-align: right">
                        <el-pagination background layout="prev, pager, next"
                                       :total="myArticles.length"
                                       :page-size="4"
                                       @current-change="pagePublishedChange"/>
                    </el-row>
                </el-tab-pane>
                <el-tab-pane label="发布新的文章" name="publish">

                </el-tab-pane>
            </el-tabs>
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
                activeTab: 'like',
                myArticles: [],
                pagePublished: 1,
                pageLike: 1
            }
        },
        computed: {
            myArticleShow() {
                let index = this.pagePublished - 1;
                return this.myArticles.slice(index * 4, index * 4 + 4);
            }
        },
        methods: {
            getMyArticles() {
                let config = {
                    method: 'get',
                    url: '/article/tofel-article/myArticle?artUsername=' + sessionStorage.getItem("username"),
                };

                this.$axios(config).then(res => {
                    this.myArticles = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            getLikeArticles() {

            },
            pagePublishedChange(page) {
                this.pagePublished = page;
            }
        },
        mounted() {
            this.getMyArticles();
        }
    }
</script>

<style scoped>
</style>