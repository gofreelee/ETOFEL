<template>
    <el-container style="padding-left: 15%; padding-right: 15%">
        <el-main>
            <el-row type="flex" justify="space-around">
                <el-col :span="12">
                    <ArticleList type="Listen" :articles="listen"/>
                </el-col>
                <el-col :span="12">
                    <ArticleList type="Speak" :articles="speak"/>
                </el-col>
            </el-row>
            <el-row type="flex" justify="space-around">
                <el-col :span="12">
                    <ArticleList type="Read" :articles="read"/>
                </el-col>
                <el-col :span="12">
                    <ArticleList type="Write" :articles="write"/>
                </el-col>
            </el-row>
            <el-row type="flex" justify="space-around">
                <el-col :span="12">
                    <ArticleList type="Vocabulary" :articles="vocabulary"/>
                </el-col>
                <el-col :span="12">
                    <ArticleList type="Information" :articles="information"/>
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
                    <el-button type="text" icon="el-icon-refresh" @click="groupCommend">换一批</el-button>
                </el-col>
            </el-row>
            <el-row v-for="item in groups" :key="item.grpId">
                <HomeGroup :group="item"/>
            </el-row>
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
        },
        data() {
            return {
                read: [],
                write: [],
                speak: [],
                listen: [],
                vocabulary: [],
                information: [],
                groups: []
            }
        },
        methods: {
            articles() {
                let config = {
                    method: 'get',
                    url: '/article/tofel-article/startpage',
                };

                this.$axios(config).then(res => {
                    this.read = res.data.Read;
                    this.write = res.data.Write;
                    this.speak = res.data.Speak;
                    this.listen = res.data.Listen;
                    this.vocabulary = res.data.Vocabulary;
                    this.information = res.data.Information;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            groupCommend() {
                let config = {
                    method: 'get',
                    url: '/group/group/randomGroup?need=4',
                };

                this.$axios(config).then(res => {
                    this.groups = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
        },
        mounted() {
            this.articles();
            this.groupCommend();
        }
    }
</script>

<style scoped>
    .el-aside {
        padding: 20px 20px 20px 40px;
    }
</style>