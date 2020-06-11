<template>
    <el-row>
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
</template>

<script>
    import router from "../router";

    export default {
        name: "MenuUser",
        data() {
            return {
                selectId: 0
            }
        },
        methods: {
            switchView(id) {
                if (this.selectId === id) return;
                this.selectId = id;
                switch (id) {
                    case 0:
                        router.push({path: '/home'});
                        break;
                    case 1:
                        router.push({path: '/tofel-article'});
                        break;
                    case 3:
                        router.push({path: '/group'})
                }
            }
        },
        computed: {
            color() {
                return function (id) {
                    return id === this.selectId ? "background-color:#063" : "background-color:#68BF4A"
                }
            }
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
</style>