<template>
    <el-container style="margin: 60px 20% 60px 20%">
        <el-main style="width: 50%">
            <el-row type="flex" align="middle">
                <el-col :span="12" style="font-size: 2rem">
                    欢迎登陆人人托福
                </el-col>
                <el-col :span="6" :push="2">
                    <el-select v-model="loginType">
                        <el-option label="用户登陆" value="user"></el-option>
                        <el-option label="老师登陆" value="teacher"></el-option>
                    </el-select>
                </el-col>
            </el-row>
            <el-row style="margin: 40px 20px 20px 0">
                <el-input prefix-icon="el-icon-user" placeholder="请输入用户名" v-model="username"/>
            </el-row>
            <el-row style="margin: 30px 20px 20px 0">
                <el-input prefix-icon="el-icon-lock" placeholder="请输入用户名" v-model="password" show-password/>
            </el-row>
            <el-row style="margin: 30px 20px 20px 0">
                <el-col :span="12" ref="verifyCode" id="verify-code">
                    <el-input prefix-icon="el-icon-key" placeholder="请输入验证码" v-model="verifyCode"/>
                </el-col>
                <el-col :span="10" :push="2" ref="verifyImg">
                    <el-image style="width: 100%; height: 100%" fit="fill" :src="verifyImg" @click="getVerifyCode"/>
                </el-col>
            </el-row>
            <el-row style="margin: 30px 20px 20px 0">
                <el-button type="success" style="width: 100%" @click="login">登陆</el-button>
            </el-row>
            <el-row style="margin: 0 20px 20px 0">
                <el-col :span="12">
                    <el-button type="text" @click="toRegister">注册帐号</el-button>
                </el-col>
                <el-col :span="12" style="text-align: right">
                    <el-button type="text">找回密码</el-button>
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
    import Vue from 'vue';
    import bus from "../bus";

    export default {
        name: "Login",
        data() {
            return {
                loginType: 'user',
                verifyImg: '',
                username: '',
                password: '',
                verifyCode: '',
                token: ''
            }
        },
        methods: {
            toRegister() {
                router.push({path: '/register'})
            },
            createToken() {
                let chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';
                let maxPos = chars.length;
                let token = '';
                for (let i = 0; i < 32; i++) {
                    token += chars.charAt(Math.floor(Math.random() * maxPos));
                }
                return token;
            },
            getVerifyCode() {
                let element = document.getElementById('verify-code');
                let height = window.getComputedStyle(element).height;
                height = Math.floor(parseFloat(height.substring(0, height.length - 2)));
                let width = window.getComputedStyle(element).width;
                width = Math.floor(parseFloat(width.substring(0, width.length - 2)));
                let url = '/login/user/verify-code?width=' + width + "&height=" + height + "&token=" + this.token;
                this.$axios.get(url).then(res => {
                    this.verifyImg = 'data:image/jpeg;base64,' + res.data;
                })
            },
            login() {
                let url = '/login/user/ulogin?username=' + this.username + "&password=" + this.password + "&verifyCode=" + this.verifyCode + "&token=" + this.token;
                this.$axios.get(url).then(res => {
                    if (res.data == null) {
                        alert('登录失败');
                    } else {
                        Vue.prototype.$user = res.data;
                        Vue.prototype.$login = true;
                        bus.$emit('loginSuccess');
                    }
                })
            }
        },
        mounted() {
            this.token = this.createToken();
            this.getVerifyCode();
        }
    }
</script>

<style scoped>

</style>