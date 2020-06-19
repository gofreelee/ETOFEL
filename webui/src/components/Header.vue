<template>
    <el-row type="flex" align="middle">
        <el-col :span="10" :offset="4">
            <img src="../assets/logo.png" alt="logo">
        </el-col>
        <el-col :span="2" @click.native="toPersonalCenter">
            {{username}}
        </el-col>
        <el-col :span="2">
            <i class="el-icon-bell">消息</i>
        </el-col>
        <el-col :span="4">
            <el-button type="success" @click="toLogin" v-if="!login">登录</el-button>
            <el-button type="success" @click="toRegister" v-if="!login">注册</el-button>
        </el-col>
    </el-row>
</template>

<script>
    import Vue from 'vue';
    import router from "../router";
    import bus from "../bus";

    export default {
        name: "Header",
        data() {
            return {
                login: false,
                username: '请登录'
            }
        },
        methods: {
            toLogin() {
                router.push({path: '/login'})
            },
            toRegister() {
                router.push({path: '/register'})
            },
            toPersonalCenter() {
                if (this.username !== '请登录') router.push({path: '/personal-center'})
            },
            loginEasy(username, password) {
                let identity = sessionStorage.getItem("identity");

                let url = '';
                if (identity === 'user') {
                    url = '/login/user/ulogin?username=' + username + "&password=" + password;
                } else if (identity === 'teacher') {
                    url = '/login/teacher/tlogin?username=' + username + "&password=" + password;
                } else {
                    url = '/login/administer/alogin?username=' + username + "&password=" + password;
                }

                this.$axios.get(url).then(res => {
                    if (res.data.information == null) {
                        alert('登录失败');
                    } else {
                        let information = res.data.information;
                        if (sessionStorage.getItem("identity") === 'teacher') {
                            information.usr_username = information.tch_username;
                            information.usr_nickname = information.tch_name;
                            information.usr_gender = information.tch_gender;
                            information.usr_email = information.tch_email;
                            information.usr_phone = information.tch_phone;
                            information.usr_birthday = information.tch_birthday;
                            information.usr_sign = information.tch_description;
                            information.usr_portrait = information.tch_portrait;
                        }
                        Vue.prototype.$user = information;
                        bus.$emit('loginSuccess');
                        router.push({path: '/home'})
                    }
                })
            }
        },
        mounted() {
            bus.$on('loginSuccess', () => {
                this.login = true;
                this.username = Vue.prototype.$user.usr_username;
            })

            let username = sessionStorage.getItem("username");
            let password = sessionStorage.getItem("password");
            if (username !== null) this.loginEasy(username, password);
        }
    }
</script>

<style scoped>

</style>