<template>
    <div class="menu">
        <el-row v-if="!isManager">
            <el-col :offset="4" :span="2">
                <p v-bind:style="color(0)" @click="switchView(0)">首页</p>
            </el-col>
            <el-col :span="2">
                <p v-bind:style="color(1)" @click="switchView(1)">托福人</p>
            </el-col>
            <el-col :span="2">
                <p v-bind:style="color(2)" @click="switchView(2)">学习课程</p>
            </el-col>
            <el-col :span="2">
                <p v-bind:style="color(3)" @click="switchView(3)">群聊组</p>
            </el-col>
        </el-row>
        <el-row v-else>
            <el-col :offset="4" :span="2">
                <p v-bind:style="color(0)" @click="managerSwitchView(0)">首页</p>
            </el-col>
<!--            <el-col :span="2">-->
<!--                <p v-bind:style="color(1)" @click="managerSwitchView(1)">系统管理</p>-->
<!--            </el-col>-->
            <el-col :span="2">
                <!-- <p v-bind:style="color(2)" class="el-dropdown-link" @click="managerSwitchView(2)">用户管理</p> -->
                <el-menu text-color="#fff" 
                         background-color="#68BF4A"
                         class="el-menu-demo" 
                         mode="horizontal" 
                         active-text-color="#fff"
                         @select="handleSelect">
                    <el-submenu index="1">
                        <template slot="title"><span class="_text">用户管理</span></template>
                        <el-menu-item index="user_list">用户列表</el-menu-item>
<!--                        <el-menu-item index="teacher_list">讲师列表</el-menu-item>-->
                    </el-submenu>
                </el-menu>
            </el-col>
            <el-col :span="2">
                <p v-bind:style="color(3)" @click="managerSwitchView(3)">托福人</p>
            </el-col>
            <el-col :span="2">
                <p v-bind:style="color(4)" @click="managerSwitchView(4)">群组聊天</p>
            </el-col>
            <el-col :span="2">
                <p v-bind:style="color(5)" @click="managerSwitchView(5)">学习课程</p>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import router from "../router";
    import bus from "../bus";

    export default {
        name: "MenuUser",
        data() {
            return {
                selectId: 0,
                isManager: false
            }
        },
        methods: {
            switchView(id) {
                this.selectId = id;
                switch (id) {
                    case 0:
                        router.push({path: '/home'});
                        break;
                    case 1:
                        router.push({path: '/tofel-article'});
                        break;
                    case 2:
                        router.push({path: '/course'});
                        break;
                    case 3:
                        router.push({path: '/group'})
                }
            },
            managerSwitchView(id) {
                if (this.selectId === id) return;
                this.selectId = id;
                switch (id) {
                    case 0:
                        router.push({ path: '/home' });
                        break;
                    case 1:
                        router.push({ path: '/sys-manager' });
                        break;
                    case 2:
                        router.push({ path: '/user-manager' });
                        break;
                    case 3:
                        router.push({ path: '/manager-tofel-article' })
                        break;
                    case 4:
                        router.push({ path: '/manager-group' })
                        break;
                    case 5:
                        router.push({ path: '/manager-learning-course' })
                }
            },
            // 下拉列表选择，处理路由跳转
            handleSelect(value) {
                console.log(value)
                switch (value) {
                    case 'user_list':
                        router.push({ path: '/user-list-manager' })
                        break
                    case 'teacher_list':
                        router.push({ path: '/teacher-list-manager' })
                }
            }
        },
        computed: {
            color() {
                return function (id) {
                    return id === this.selectId ? "background-color:#063" : "background-color:#68BF4A"
                }
            }
        },
        mounted() {
            bus.$on('loginSuccess', () => {
                this.isManager = sessionStorage.getItem("identity") === 'manager';
            })
        }
    }
</script>

<style scoped>
    .el-row {
        background-color: #68BF4A;
    }
    p {
        font-size: 18px;
        color: white;
        margin: 0;
        padding: 1em;
        text-align: center;
    }
    ._text{
        font-size: 18px;
    }
    .el-menu--horizontal > .el-submenu .el-submenu__title {
        border-bottom: none;
    }
</style>