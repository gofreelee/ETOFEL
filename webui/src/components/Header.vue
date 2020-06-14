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
            }
        },
        mounted() {
            bus.$on('loginSuccess', () => {
                this.login = true;
                this.username = Vue.prototype.$user.usr_username;
            })
        }
    }
</script>

<style scoped>

</style>