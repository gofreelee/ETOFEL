<template>
    <el-container style="margin: 60px 20% 60px 20%">
        <el-main style="width: 50%">
            <el-row type="flex" align="middle">
                <el-col :span="12" style="font-size: 2rem">
                    欢迎注册人人托福
                </el-col>
            </el-row>
            <el-row style="margin: 40px 20px 20px 0">
                <el-input prefix-icon="el-icon-user" placeholder="请输入用户名"></el-input>
            </el-row>
            <el-row style="margin: 30px 20px 20px 0">
                <el-input prefix-icon="el-icon-lock" placeholder="请输入密码"></el-input>
            </el-row>
            <el-row style="margin: 30px 20px 20px 0">
                <el-input prefix-icon="el-icon-folder-opened" placeholder="请输入邮箱"></el-input>
            </el-row>
            <el-row style="margin: 30px 20px 20px 0">
                <el-col :span="12">
                    <el-input prefix-icon="el-icon-key" placeholder="请输入验证码"></el-input>
                </el-col>
            </el-row>
            <el-row>
                <el-checkbox v-model="agree">我同意《人人托福网服务协议》</el-checkbox>
            </el-row>
            <el-row style="margin: 30px 20px 20px 0">
                <el-button type="success" style="width: 100%">注册</el-button>
            </el-row>
            <el-row style="margin: 0 20px 20px 0">
                <el-col :span="12">
                    <el-button type="text" @click="toLogin">已有帐号，马上登陆</el-button>
                </el-col>
            </el-row>
        </el-main>
        <el-main style="width: 50%; border-left: solid 1px #000">
            <el-row style="margin: 20% 20px 20px 20px">
                您也可以用以下方式登陆
            </el-row>
            <el-row style="margin: 20px 20px 20px 20px">
                您也可以用以下方式登陆
            </el-row>
            <el-row style="margin: 20px 20px 20px 20px">
                您也可以用以下方式登陆
            </el-row>
            <el-row style="margin: 20px 20px 20px 20px">
                您也可以用以下方式登陆
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import router from "../router";

    export default {
        name: "Register",
        date() {
            return {
                agree: ''
            }
        },
        methods: {
            toLogin() {
                router.push({path: '/login'});
            }
        }
    }
</script>

<style scoped>

</style>