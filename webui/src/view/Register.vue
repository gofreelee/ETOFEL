<template>
    <el-container style="margin: 60px 20% 60px 20%">
        <el-main style="width: 50%">
            <el-row type="flex" align="middle">
                <el-col :span="12" style="font-size: 2rem">
                    欢迎注册人人托福
                </el-col>
            </el-row>
            <el-row style="margin: 40px 20px 20px 0">
                <el-input prefix-icon="el-icon-user" placeholder="请输入用户名" v-model="username"/>
            </el-row>
            <el-row style="margin: 30px 20px 20px 0">
                <el-input prefix-icon="el-icon-lock" placeholder="请输入密码" v-model="password" show-password/>
            </el-row>
            <el-row style="margin: 30px 20px 20px 0">
                <el-input prefix-icon="el-icon-folder-opened" placeholder="请输入邮箱" v-model="email"/>
            </el-row>
            <el-row style="margin: 30px 20px 20px 0">
                <el-col :span="12" id="verify-code">
                    <el-input prefix-icon="el-icon-key" placeholder="请输入验证码" v-model="verifyCode"/>
                </el-col>
                <el-col :span="10" :push="2" ref="verifyImg">
                    <el-image style="width: 100%; height: 100%" fit="fill" :src="verifyImg" @click="getVerifyCode"/>
                </el-col>
            </el-row>
            <el-row>
                <el-checkbox v-model="agree">我同意《人人托福网服务协议》</el-checkbox>
            </el-row>
            <el-row style="margin: 30px 20px 20px 0">
                <el-button type="success" style="width: 100%" @click="register">注册</el-button>
            </el-row>
            <el-row style="margin: 0 20px 20px 0">
                <el-col :span="12">
                    <el-button type="text" @click="toLogin">已有帐号，马上登陆</el-button>
                </el-col>
            </el-row>
        </el-main>
        <el-main style="width: 50%; border-left: solid 1px #000">
            <el-row class="login-method" style="margin-top: 20%">
                您也可以用以下方式登陆 <i class="fa fa-weibo" aria-hidden="true"></i>
            </el-row>
            <el-row class="login-method">
                您也可以用以下方式登陆 <i class="fa fa-weixin" aria-hidden="true"></i>
            </el-row>
            <el-row class="login-method">
                您也可以用以下方式登陆 <i class="fa fa-qq" aria-hidden="true"></i>
            </el-row>
            <el-row class="login-method">
                您也可以用以下方式登陆 <i class="fa fa-tencent-weibo" aria-hidden="true"></i>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import router from "../router";

    export default {
        name: "Register",
        data() {
            return {
                agree: '',
                verifyImg: '',
                verifyText: '',
                username: '',
                password: '',
                email: '',
                verifyCode: ''
            }
        },
        methods: {
            toLogin() {
                router.push({path: '/login'});
            },
            getVerifyCode() {
                let element = document.getElementById('verify-code');
                let height = window.getComputedStyle(element).height;
                height = Math.floor(parseFloat(height.substring(0, height.length - 2)));
                let width = window.getComputedStyle(element).width;
                width = Math.floor(parseFloat(width.substring(0, width.length - 2)));
                let url = '/login/user/verify-code?width=' + width + "&height=" + height;
                this.$axios.get(url).then(res => {
                    this.verifyImg = 'data:image/jpeg;base64,' + res.data.img;
                    this.verifyText = res.data.text;
                })
            },
            register() {
                if (this.agree !== true) {
                    alert("未同意协议，无法注册");
                    return;
                }

                let data = new FormData();
                data.append('username', this.username);
                data.append('password', this.password);
                data.append('email', this.email);

                let config = {
                    method: 'post',
                    url: '/login/user/register',
                    data: data
                };

                this.$axios(config).then(res => {
                    if (res.data === null) {
                        alert("用户名重复，注册失败");
                    } else {
                        alert("注册成功，请前往登录");
                        router.push({path: "/login"})
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        mounted() {
            this.getVerifyCode();
        }
    }
</script>

<style scoped>
    .login-method {
        margin: 0 20px 20px 20px;
        font-size: 1.1rem;
    }
</style>