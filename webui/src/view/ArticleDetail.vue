<template>
    <el-container style="margin-left: 15%; margin-right: 15%">
        <el-main style="margin-right: 20px">
            <img :src="article.art_img" style="height: 400px; width: 100%; object-fit: fill"/>
            <el-row class="article-title">
                {{article.art_title}}
            </el-row>
            <el-row class="article-info">
                发布时间：{{article.art_date}}
            </el-row>
            <el-row class="article-info">
                发布人：{{article.art_username}}
            </el-row>
            <el-row class="article-info" type="flex" align="middle">
                <el-col :span="3">
                    <i class="fa fa-heart"/> 点赞 28
                </el-col>
                <el-col :span="3">
                    <i class="fa fa-share-square-o"/> 转发 28
                </el-col>
                <el-col :span="12">
                    发送至
                    &nbsp;<i class="fa fa-weixin"/>
                    &nbsp;<i class="fa fa-qq"/>
                    &nbsp;<i class="fa fa-weibo"/>
                    &nbsp;<i class="fa fa-tencent-weibo"/>
                </el-col>
            </el-row>
            <el-divider>文章内容</el-divider>
            <el-row class="article">
                {{article.art_text}}
            </el-row>
            <el-divider>文章内容</el-divider>

            <el-row>
                文章评论 {{comments.length}}
            </el-row>
            <el-row style="margin-top: 20px; margin-bottom: 20px">
                <el-input type="textarea" :rows="8" placeholder="请输入您的评论" v-model="comment"/>
            </el-row>
            <el-row>
                <el-col :span="8" :push="16" style="text-align: right">
                    <el-button type="success" @click="sendComment">提交评论</el-button>
                </el-col>
            </el-row>

            <el-row v-for="item in commentShow" :key="item.cmt_date_time">
                <ArticleComment :comment="item"/>
            </el-row>

            <el-row style="text-align: right; margin-top: 20px">
                <el-pagination background layout="prev, pager, next"
                               :total="comments.length"
                               :page-size="4"
                               @current-change="pageChange"/>
            </el-row>
        </el-main>

        <el-aside>
            <!--最新公开课-->
            <el-row type="flex" align="middle" style="font-size: 1.3rem; margin-top: 40px">
                <el-col :span="18">
                    最新课程
                </el-col>
                <el-col :span="6">
                    <el-button type="text" icon="el-icon-refresh" @click="courseCommend">换一批</el-button>
                </el-col>
            </el-row>
            <el-row v-for="item in courses" :key="item.cosId">
                <HomeCourse :course="item"/>
            </el-row>
        </el-aside>
    </el-container>
</template>

<script>
    import HomeCourse from "../components/home/HomeCourse";
    import ArticleComment from "../components/article/ArticleComment";

    export default {
        name: "ArticleDetail",
        components: {
            HomeCourse,
            ArticleComment
        },
        computed: {
            commentShow() {
                let index = this.currentPage - 1;
                return this.comments.slice(index * 4, index * 4 + 4);
            }
        },
        data() {
            return {
                comment: '',
                article: '',
                comments: [],
                currentPage: 1,
                courses: []
            }
        },
        methods: {
            getArticleDetail() {
                let config = {
                    method: 'get',
                    url: '/article/tofel-article/getArtInfo?artId=' + this.$route.query.art_id,
                };

                this.$axios(config).then(res => {
                    console.log(res.data);
                    this.article = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            getComments() {
                let config = {
                    method: 'get',
                    url: '/article/comment/selectArtComment?art_id=' + this.$route.query.art_id,
                };


                this.$axios(config).then(res => {
                    this.comments = res.data
                }).catch(function (error) {
                    console.log(error);
                });
            },
            pageChange(currentPage) {
                this.currentPage = currentPage;
            },
            sendComment() {
                console.log(1)
                let username = sessionStorage.getItem("username");
                if (username == null) {
                    alert("请先登录再发表评价");
                    return;
                }
                if (this.comment === '') {
                    alert("发送评论不能为空");
                    return;
                }

                let data = new FormData();
                data.append('cmtUsername', username);
                data.append('cmtArtId', this.article.art_id);
                data.append('cmtContent', this.comment);

                let config = {
                    method: 'post',
                    url: '/article/comment/releaseComment',
                    headers: {'Content-Type': 'application/json',},
                    data: data
                };

                this.$axios(config).then(res => {
                    console.log(res.data);
                    this.comment = '';
                    this.getComments();
                }).catch(function (error) {
                    console.log(error);
                });
            },
            courseCommend() {
                let config = {
                    method: 'get',
                    url: '/course/course/courseRecommend?need=4',
                };

                this.$axios(config).then(res => {
                    this.courses = res.data;
                }).catch(function (error) {
                    console.log(error);
                });

            }
        },
        mounted() {
            this.getArticleDetail();
            this.getComments();
            this.courseCommend();
        }
    }
</script>

<style scoped>
    .article-title {
        font-size: 2.6rem;
        margin-top: 20px;
        font-weight: bold;
    }

    .article-info {
        margin-top: 20px;
    }

    .article {
        margin-top: 30px;
        line-height: 1.8;
        font-size: 1.1rem;
    }
</style>