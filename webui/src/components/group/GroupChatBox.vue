<template>
    <el-container style="margin-top: 10px">
        <el-aside style="width: 10%; margin-right: 30px">
            <el-image :src="portrait"/>
        </el-aside>
        <el-main>
            <el-row type="flex" justify="space-between" align="middle">
                <el-col style="font-weight: bold; font-size: 1.4rem" :span="12">
                    {{nickname}}
                </el-col>
                <el-col :span="8" style="text-align: right">
                    创建时间 {{message.gmsCreateTime}}
                </el-col>
            </el-row>
            <el-row class="chat-content">
                {{message.gmsContext}}
            </el-row>
            <el-divider></el-divider>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "GroupChatBox",
        props: {
            message: Object
        },
        data() {
            return {
                portrait: "",
                nickname: ''
            }
        },
        methods: {
            getUser() {
                let config = {
                    method: 'get',
                    url: '/user/user/info?usr_username=' + this.message.gmsUsername,
                };

                this.$axios(config).then(res => {
                    this.nickname = res.data.usr_nickname;
                    this.portrait = res.data.usr_portrait;
                }).catch(function (error) {
                    console.log(error);
                });

                config.url = '/user/teacher/info?tch_username=' + this.message.gmsUsername;
                this.$axios(config).then(res => {
                    console.log(res.data);
                    this.nickname = res.data.tch_name;
                    this.portrait = res.data.tch_portrait;
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
    .chat-content {
        background-color: #f0f0f0;
        margin-top: 20px;
        padding: 15px
    }
</style>