<template>
    <el-container>
        <el-main style="position: relative">

            <el-tabs type="card" v-model="activeTab">
                <el-tab-pane label="我点赞的文章" name="like">
                    <el-row v-for="item in likeArticleShow" :key="item.art_id">
                        <ArticleItem :is-mine="false" :article="item"/>
                    </el-row>
                    <el-row style="text-align: right">
                        <el-pagination background layout="prev, pager, next"
                                       :total="likeArticles.length"
                                       :page-size="4"
                                       @current-change="pageLikeChange"/>
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
                    <el-row class="info">
                        <el-col :span="3">
                            宣传图片：
                        </el-col>
                        <el-col :span="21">
                            <el-upload
                                    class="avatar-uploader"
                                    action="##"
                                    :show-file-list="false"
                                    :on-success="handleAvatarSuccess"
                                    :before-upload="beforeAvatarUpload">
                                <img v-if="imageUpload" :src="imageUpload" class="avatar" alt="portrait">
                                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                            </el-upload>
                        </el-col>
                    </el-row>
                    <el-row class="info" type="flex" align="middle">
                        <el-col :span="3">
                            文章标题：
                        </el-col>
                        <el-col :span="12">
                            <el-input v-model="articleTitle"/>
                        </el-col>
                    </el-row>
                    <el-row class="info" type="flex" align="middle">
                        <el-col :span="3">
                            文章类别：
                        </el-col>
                        <el-col :span="12">
                            <el-select v-model="articleType" placeholder="文章类别">
                                <el-option label="托福听力" value="Listen"/>
                                <el-option label="托福口语" value="Speak"/>
                                <el-option label="托福阅读" value="Read"/>
                                <el-option label="托福写作" value="Write"/>
                                <el-option label="托福词汇" value="Vocabulary"/>
                                <el-option label="托福资讯" value="Information"/>
                            </el-select>
                        </el-col>
                    </el-row>
                    <el-row class="info">
                        <el-col :span="3">
                            文章内容：
                        </el-col>
                        <el-col :span="12">
                            <el-input v-model="articleText" type="textarea" :rows="8"/>
                        </el-col>
                    </el-row>
                    <el-row class="info">
                        <el-col :span="3" :push="3">
                            <el-button type="primary" @click="publishArticle">上传文章</el-button>
                        </el-col>
                    </el-row>
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
                likeArticles: [],
                pagePublished: 1,
                pageLike: 1,
                articleType: '',
                articleTitle: '',
                articleText: '',
                imageUpload: ''
            }
        },
        computed: {
            myArticleShow() {
                let index = this.pagePublished - 1;
                return this.myArticles.slice(index * 4, index * 4 + 4);
            },
            likeArticleShow() {
                let index = this.pageLike - 1;
                return this.likeArticles.slice(index * 4, index * 4 + 4);
            }
        },
        methods: {
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }

                let self = this;
                let fileReader = new FileReader();
                fileReader.readAsDataURL(file);
                fileReader.onload = function (e) {
                    self.imageUpload = e.target.result;
                }
                return isJPG && isLt2M;
            },
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
                let config = {
                    method: 'get',
                    url: '/article/tofel-article/likeArticle?ulaUsername=' + sessionStorage.getItem("username"),
                };

                this.$axios(config).then(res => {
                    this.likeArticles = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            pagePublishedChange(page) {
                this.pagePublished = page;
            },
            pageLikeChange(page) {
                this.pageLike = page;
            },
            publishArticle() {
                let data = new FormData();
                data.append('artUsername', sessionStorage.getItem("username"));
                data.append('artTitle', this.articleTitle);
                data.append('artImg', this.imageUpload);
                data.append('artText', this.articleText);
                data.append('artType', this.articleType);

                let config = {
                    method: 'post',
                    url: '/article/tofel-article/createArticle',
                    headers: {'Content-Type': 'application/json',},
                    data: data
                };

                this.$axios(config).then(res => {
                    console.log(res.data);
                    alert("发布成功");
                    this.articleTitle = '';
                    this.articleText = '';
                    this.imageUpload = '';
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        mounted() {
            this.getMyArticles();
            this.getLikeArticles();
        }
    }
</script>

<style scoped>
    .info {
        padding-top: 20px;
    }

    .avatar-uploader {
        width: 400px;
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .avatar-uploader:hover {
        border-color: #409EFF;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 400px;
        height: 200px;
        line-height: 200px;
        text-align: center;
    }

    .avatar {
        width: 400px;
        height: 200px;
        display: block;
    }
</style>