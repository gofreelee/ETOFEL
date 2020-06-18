<template>
    <el-container>
        <el-main>
            <el-row style="font-size: 1.2rem" align="middle" type="flex">
                <el-col :span="21">
                    <i v-bind:class="icon"/> {{ChineseNameList[type]}} / {{type}}
                </el-col>
                <el-col :span="3">
                    <el-button type="text">全部</el-button>
                </el-col>
            </el-row>
            <hr/>
            <el-row v-for="item in articles" :key="item.art_id"
                    type="flex" align="middle" style="line-height: 40px"
                    :gutter="25">
                <el-col :span="1" :offset="1">
                    <i class="el-icon-search"/>
                </el-col>
                <el-col :span="20" style="font-size: 1.1rem; cursor: pointer"
                        @click.native="toArticleDetail(item.art_id)">
                    {{item.art_title}}
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import router from "../../router";

    export default {
        name: "ArticleList",
        props: {
            type: String,
            articles: Array
        },
        data() {
            return {
                iconList: {
                    "Listen": "el-icon-headset",
                    "Speak": "el-icon-phone-outline",
                    "Read": "el-icon-reading",
                    "Write": "el-icon-edit-outline",
                    "Vocabulary": "el-icon-notebook-1",
                    "Information": "el-icon-chat-line-square",
                    "Activity": "el-icon-basketball",
                    "Prediction": "el-icon-trophy"
                },
                ChineseNameList: {
                    "Listen": "听力",
                    "Speak": "口语",
                    "Read": "阅读",
                    "Write": "写作",
                    "Vocabulary": "词汇",
                    "Information": "资讯",
                }
            }
        },
        computed: {
            icon() {
                return this.iconList[this.type]
            }
        },
        methods: {
            toArticleDetail(art_id) {
                router.push({path: "/tofel-article/detail", query: {art_id: art_id}});
            }
        }
    }
</script>

<style scoped>

</style>