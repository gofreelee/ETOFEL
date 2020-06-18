<template>
    <el-container>
        <el-aside style="width: 40%; padding-top: 20px">
            <img :src="article.art_img" alt="logo" style="height: 200px; object-fit: fill"/>
        </el-aside>
        <el-main>
            <el-row>
                <el-col style="cursor: pointer" class="title" @click.native="toArticleDetail">
                    {{article.art_title}}
                </el-col>
            </el-row>
            <el-row class="description">
                {{article.art_text.substring(0,60) + "......"}}
            </el-row>
            <el-row>
                <el-col :span="12">
                    {{article.art_date}}
                </el-col>
                <el-col :span="12">
                    {{typeMap[article.art_type]}}
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import router from "../../router";

    export default {
        name: "HomeIssue",
        props: {
            article: Object
        },
        data() {
            return {
                typeMap: {
                    "Write": "托福写作",
                    "Read": "托福阅读",
                    "Listen": "托福听力",
                    "Speak": "托福口语",
                    "Information": "托福资讯",
                    "Vocabulary": "托福词汇"
                }
            }
        },
        methods: {
            toArticleDetail() {
                router.push({path: '/tofel-article/detail', query: {art_id: this.article.art_id}});
            }
        }
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
        font-weight: bold;
        font-size: 1.2rem;
    }

    .description {
        word-wrap: break-word;
        padding: 20px 0 20px 0;
        font-size: 1rem;
    }
</style>