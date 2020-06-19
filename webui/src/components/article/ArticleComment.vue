<template>
    <el-container>
        <el-main style="padding-top: 0; padding-bottom: 0">
            <el-row type="flex" align="middle">
                <el-col :span="3">
                    <img :src="portrait" style="object-fit: fill; width: 100%; height: 100px" alt="用户头像"/>
                </el-col>
                <el-col :span="16" :push="1">
                    <el-row style="margin-bottom: 10px">
                        {{nickname}}
                    </el-row>
                    <el-row>
                        {{comment.cmt_content}}
                    </el-row>
                </el-col>
                <el-col :span="5">
                    {{comment.cmt_date_time}}
                </el-col>
            </el-row>
            <el-divider></el-divider>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "ArticleComment",
        props: {
            comment: Object
        },
        data() {
            return {
                portrait: '',
                nickname: ''
            }
        },
        methods: {
            getUser() {
                let config = {
                    method: 'get',
                    url: '/user/user/info?usr_username=' + this.comment.cmt_username,
                };

                this.$axios(config).then(res => {
                    this.portrait = res.data.usr_portrait;
                    this.nickname = res.data.usr_nickname;
                }).catch(function (error) {
                    console.log(error);
                });

                config.url = '/user/teacher/info?tch_username=' + this.comment.cmt_username;
                this.$axios(config).then(res => {
                    this.portrait = res.data.tch_portrait;
                    this.nickname = res.data.tch_name;
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        mounted() {
            this.getUser();
        }
    }
</script>

<style scoped>
    .el-divider--horizontal {
        margin-bottom: 0;
    }
</style>