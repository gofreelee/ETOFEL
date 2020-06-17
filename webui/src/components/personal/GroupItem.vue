<template>
    <el-container>
        <el-aside style="width: 100px; padding: 20px 0 20px 0">
            <el-image :src="group.grpPortrait" fit="fill" style="align-self: center"/>
        </el-aside>
        <el-main>
            <el-row type="flex" align="middle">
                <el-col class="title" :span="8">
                    {{group.grpName}}
                </el-col>
                <el-col :span="12" style="color: #68BF4A">
                    {{group.grpType}}
                </el-col>
            </el-row>
            <el-row class="info">
                <el-col :span="10">
                    建群时间: {{group.grpCreateTime}}
                </el-col>
                <el-col :span="8">
                    群人数: {{groupMembers}}
                </el-col>
            </el-row>
            <el-row class="info">
                {{group.grpDescription}}
            </el-row>
            <el-row class="info" style="text-align: center">
                <el-col :span="4">
                    <el-button type="primary" plain @click="toChatRoom">进入群聊</el-button>
                </el-col>
                <el-col :span="4">
                    <el-button type="primary" plain @click="toGroupInformation">群信息</el-button>
                </el-col>
                <el-col :span="4" v-if="!isAdmin">
                    <el-button type="primary" plain>申请做管理员</el-button>
                </el-col>
                <el-col :span="4" v-if="isAdmin">
                    <el-button type="primary" plain>退出管理员</el-button>
                </el-col>
                <el-col :span="4" v-if="!isAdmin">
                    <el-button type="primary" plain>退出群</el-button>
                </el-col>
                <el-col :span="4" v-if="isAdmin">
                    <el-button type="primary" plain>解散群</el-button>
                </el-col>
            </el-row>
            <el-divider></el-divider>
        </el-main>
    </el-container>
</template>

<script>
    import router from "../../router";

    export default {
        name: "GroupItem",
        props: {
            isAdmin: Boolean,
            group: Object
        },
        data() {
            return {
                groupMembers: 0
            }
        },
        methods: {
            toChatRoom() {
                router.push({path: '/group/chat-room', query: {group_id: this.group.grpId}});
            },
            toGroupInformation() {
                router.push({path: '/group/group-information', query: {group_id: this.group.grpId}});
            },
            getGroupMemberNumber() {
                let config = {
                    method: 'get',
                    url: '/group/group/countMembers?grpId=' + this.group.grpId,
                };

                this.$axios(config).then(res => {
                    this.groupMembers = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        mounted() {
            this.getGroupMemberNumber();
        }
    }
</script>

<style scoped>
    .title {
        font-weight: bold;
        font-size: 1.4rem;
    }

    .info {
        padding: 15px 0 0 0;
    }
</style>