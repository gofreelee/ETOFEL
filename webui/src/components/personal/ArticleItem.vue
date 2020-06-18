<template>
    <el-container class="box">
        <el-aside style="padding: 20px 0 20px 0">
            <img :src="article.art_img" style="object-fit: fill; width: 100%; height: 180px"/>
        </el-aside>
        <el-main>
            <el-row type="flex" align="middle">
                <el-col style="font-weight: bold; font-size: 1.4rem" :span="16">
                    {{article.art_title}}
                </el-col>
                <el-col :span="5" v-if="!isMine">
                    作者：{{nickname}}
                </el-col>
            </el-row>
            <el-row style="padding: 20px 0 20px 0">
                {{article.art_text.substring(0,100) + " ......"}}
            </el-row>
            <el-row type="flex" align="middle">
                <el-col :span="7">
                    所属分类：{{article.art_type}}
                </el-col>
                <el-col :span="11">
                    发布日期：{{article.art_date}}
                </el-col>
                <el-col :span="4" v-if="isMine">
                    <el-button type="danger">删除文章</el-button>
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "ArticleItem",
        props: {
            isMine: Boolean,
            article: Object
        },
        data() {
            return {
                nickname: ''
            }
        },
        methods: {
            getNickName() {
                let config = {
                    method: 'get',
                    url: '/user/user/info?usr_username=' + this.article.art_username,
                };
                this.$axios(config).then(res => {
                    this.nickname = res.data.usr_nickname;
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        mounted() {
            this.getNickName();
        }
    }
</script>

<style scoped>
    .box {
        margin-bottom: 20px;
        border-bottom: solid 1px #8c939d;
    }
</style>