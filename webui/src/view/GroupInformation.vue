<template>
    <el-container>
        <el-main>
            <el-row style="padding-top: 100px; padding-left: 40px" class="group-info-title">
                <el-col :span="4">
                    <el-image :src="group.grpPortrait" style="width: 100%; height: 200px" fit="fill" alt="群头像"/>
                </el-col>
                <el-col :span="14" :push="1">
                    <el-row style="font-weight: bold; font-size: 2.8rem">
                        {{group.grpName}}
                    </el-row>
                    <el-row style="margin-top: 10px; margin-bottom: 20px">
                        建群时间: {{group.grpCreateTime}}
                    </el-row>
                    <el-row style="margin-top: 10px; margin-bottom: 20px">
                        {{groupMembers}}人已加入
                    </el-row>
                    <el-row>
                        {{group.grpType}}
                    </el-row>
                </el-col>
                <el-col :span="4">
                    <el-row type="flex" justify="center" style="margin-top: 20px">
                        <el-button type="primary" icon="el-icon-chat-dot-round" v-if="isMember" @click="toChatRoom">
                            进群聊天
                        </el-button>
                        <el-button type="primary" icon="el-icon-chat-dot-round" v-else @click="joinGroup">申请加群
                        </el-button>
                    </el-row>
                    <el-row type="flex" justify="center" style="margin-top: 20px" v-if="isAdmin">
                        <el-button type="warning" icon="el-icon-chat-dot-round" @click="toGroupInfoModify">修改群信息
                        </el-button>
                    </el-row>
                </el-col>
            </el-row>
            <el-row type="flex" align="middle" style="margin-top: 50px">
                <el-col :span="4" style="font-size: 3rem">
                    群介绍
                </el-col>
                <el-col :span="1">
                    <img src="../assets/qzl_CyInfoDl.png" style="object-fit: fill" alt="分割图片"/>
                </el-col>
                <el-col :span="18">
                    {{group.grpDescription}}
                </el-col>
            </el-row>
            <el-row type="flex" align="middle" style="margin-top: 30px">
                <el-col :span="4" style="font-size: 3rem">
                    群规则
                </el-col>
                <el-col :span="1">
                    <img src="../assets/qzl_CyInfoDl.png" style="object-fit: fill" alt="分割图片"/>
                </el-col>
                <el-col :span="18">
                    {{group.grpRule}}
                </el-col>
            </el-row>
            <el-row class="admin-title">
                管理员
            </el-row>
            <el-row :gutter="20">
                <el-col :span="3" v-for="item in admins" :key="item.gmbUsername" style="margin-top: 20px">
                    <el-row>
                        <el-image :src="item.userPortrait"/>
                    </el-row>
                    <el-row style="text-align: center">
                        {{item.gmbUsername}}
                    </el-row>
                </el-col>
            </el-row>
            <el-row class="admin-title">
                群成员
            </el-row>
            <el-row :gutter="20">
                <el-col :span="2" v-for="item in members" :key="item.gmbUsername" style="margin-top: 20px">
                    <el-row>
                        <el-image :src="item.userPortrait"/>
                    </el-row>
                    <el-row style="text-align: center">
                        {{item.gmbUsername}}
                    </el-row>
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import router from "../router";

    export default {
        name: "GroupInformation",
        data() {
            return {
                grpId: '',
                group: '',
                groupMembers: '',
                admins: [],
                members: [],
                isAdmin: false,
                isMember: false
            }
        },
        methods: {
            toGroupInfoModify() {
                router.push({path: '/group/group-info-modify', query: {group_id: this.grpId}});
            },
            toChatRoom() {
                router.push({path: '/group/chat-room', query: {group_id: this.grpId}});
            },
            getInformation() {
                let config = {
                    method: 'get',
                    url: '/group/group/searchGroupInfo?grpId=' + this.grpId,
                };

                this.$axios(config).then(res => {
                    console.log(res.data);
                    this.group = res.data.baseInfo;
                    this.groupMembers = res.data.groupMembers;
                    this.admins = res.data.managers;
                    this.members = res.data.members;
                    this.isMemberOrAdmin();
                }).catch(function (error) {
                    console.log(error);
                });
            },
            joinGroup() {
                let data = new FormData();
                data.append('gmbUsername', sessionStorage.getItem("username"));
                data.append('gmbGrpId', this.grpId);

                let config = {
                    method: 'post',
                    url: '/group/group-member/addGroupMember',
                    data: data
                };

                this.$axios(config).then(function (response) {
                    console.log(JSON.stringify(response.data));
                    alert("申请成功，等待管理员确认")
                }).catch(function (error) {
                    console.log(error);
                });

            },
            isMemberOrAdmin() {
                let username = sessionStorage.getItem("username");
                if (username == null) return;
                for (let i = 0; i < this.admins.length; i++) {
                    if (username === this.admins[i].gmbUsername) {
                        this.isAdmin = true;
                        this.isMember = true;
                        return;
                    }
                }
                for (let i = 0; i < this.members.length; i++) {
                    if (username === this.members[i].gmbUsername) {
                        this.isAdmin = false;
                        this.isMember = true;
                        return;
                    }
                }
            }
        },
        mounted() {
            this.grpId = this.$route.query.group_id;
            this.getInformation();
        }
    }
</script>

<style scoped>
    .el-main {
        margin-left: 15%;
        margin-right: 15%;
        margin-top: 20px;
    }

    .group-info-title {
        background-image: url('https://i.loli.net/2020/06/17/RnhJbk5VLNZKT3o.png');
        background-size: 100% 100%;
    }

    .admin-title {
        margin-top: 60px;
        border-top: solid 1px #ededed;
        line-height: 60px;
        font-size: 2rem;
        background: url("../assets/classInfo_Button.png") 0 -195px no-repeat;
        padding-left: 10px;
    }
</style>