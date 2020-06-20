<template>
    <el-container>
        <el-main>
            <el-row style="padding-top: 100px; padding-left: 40px" class="group-info-title">
                <el-col :span="4">
                    <el-upload
                            class="avatar-uploader"
                            action="##"
                            :show-file-list="false"
                            :on-success="handleAvatarSuccess"
                            :before-upload="beforeAvatarUpload">
                        <img v-if="group.grpPortrait" :src="group.grpPortrait" class="avatar" alt="portrait">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </el-col>
                <el-col :span="14" :push="1">
                    <el-row style="font-weight: bold; font-size: 2.8rem">
                        <el-col :span="16">
                            <el-input v-model="group.grpName"/>
                        </el-col>
                    </el-row>
                    <el-row style="margin-top: 10px; margin-bottom: 20px">
                        建群时间: {{group.grpCreateTime}}
                    </el-row>
                    <el-row style="margin-top: 10px; margin-bottom: 20px">
                        {{groupMembers}}人已加入
                    </el-row>
                    <el-row>
                        <el-select v-model="group.grpType">
                            <el-option label="名师课堂群" value="名师课堂群"></el-option>
                            <el-option label="同城群" value="同城群"></el-option>
                            <el-option label="结伴备考群" value="结伴备考群"></el-option>
                        </el-select>
                    </el-row>
                </el-col>
                <el-col :span="4">
                    <el-row type="flex" justify="center" style="margin-top: 20px">
                        <el-button type="primary" icon="el-icon-chat-dot-round" @click="modifyInformation">
                            确认修改
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
                    <el-input type="textarea" :rows="6" v-model="group.grpDescription"/>
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
                    <el-input type="textarea" :rows="6" v-model="group.grpRule"/>
                </el-col>
            </el-row>
            <el-row class="admin-title">
                申请做管理员：
            </el-row>
            <el-row :gutter="20">
                <el-col :span="3" v-for="item in admins" :key="item.gmbUsername" style="margin-top: 20px">
                    <el-row>
                        <el-image :src="item.userPortrait"/>
                    </el-row>
                    <el-row style="text-align: center; padding: 5px 0 15px 0">
                        {{item.gmbUsername}}
                    </el-row>
                    <el-row>
                        <el-col :span="10">
                            <el-button type="success" @click="updateMemberType(item.gmbUsername, 'manager')">同意
                            </el-button>
                        </el-col>
                        <el-col :span="10" :push="4">
                            <el-button type="danger" @click="updateMemberType(item.gmbUsername, 'member')">拒绝
                            </el-button>
                        </el-col>
                    </el-row>
                </el-col>
            </el-row>
            <el-row class="admin-title">
                申请加群：
            </el-row>
            <el-row :gutter="20">
                <el-col :span="3" v-for="item in members" :key="item.gmbUsername" style="margin-top: 20px">
                    <el-row>
                        <el-image :src="item.userPortrait"/>
                    </el-row>
                    <el-row style="text-align: center; padding: 5px 0 15px 0">
                        {{item.gmbUsername}}
                    </el-row>
                    <el-row>
                        <el-col :span="10">
                            <el-button type="success" @click="updateMemberType(item.gmbUsername, 'member')">同意
                            </el-button>
                        </el-col>
                        <el-col :span="10" :push="4">
                            <el-button type="danger" @click="updateMemberType(item.gmbUsername, 'reject')">拒绝
                            </el-button>
                        </el-col>
                    </el-row>
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import router from "../router";

    export default {
        name: "GroupInfoModify",
        data() {
            return {
                grpId: '',
                group: '',
                groupMembers: '',
                admins: [],
                members: [],
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
                    this.group = res.data.baseInfo;
                    this.groupMembers = res.data.groupMembers;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            getTobeManager() {
                let config = {
                    method: 'get',
                    url: '/group/group/searchMember?grpId=' + this.grpId + '&gmpType=tobeManager',
                };

                this.$axios(config).then(res => {
                    this.admins = res.data
                }).catch(function (error) {
                    console.log(error);
                });
            },
            getTobeMember() {
                let config = {
                    method: 'get',
                    url: '/group/group/searchMember?grpId=' + this.grpId + '&gmpType=tobeMember',
                };

                this.$axios(config).then(res => {
                    this.members = res.data
                }).catch(function (error) {
                    console.log(error);
                });
            },
            updateMemberType(username, type) {
                let data = new FormData();
                data.append('gmbUsername', username);
                data.append('gmbGrpId', this.grpId);
                data.append('gmbType', type);

                let config = {
                    method: 'post',
                    url: '/group/group-member/updateMemberType',
                    data: data
                };

                this.$axios(config).then(res => {
                    console.log('修改成员状态', res.data);
                    this.getTobeManager();
                    this.getTobeMember();
                }).catch(function (error) {
                    console.log(error);
                });
            },
            modifyInformation() {
                let data = new FormData();
                data.append('grpId', this.grpId);
                data.append('grpName', this.group.grpName);
                data.append('grpDescription', this.group.grpDescription);
                data.append('grpRule', this.group.grpRule);
                data.append('grpType', this.group.grpType);
                data.append('grpPortrait', this.group.grpPortrait);
                let config = {
                    method: 'post',
                    url: '/group/group/modifyGroupInfo',
                    data: data
                };

                this.$axios(config).then(res => {
                    console.log('修改群信息', res.data);
                    alert("修改成功")
                }).catch(function (error) {
                    console.log(error);
                });
            },
            handleAvatarSuccess(res, file) {
                this.group.grpPortrait = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }

                let self = this;
                let fileReader = new FileReader();
                fileReader.readAsDataURL(file);
                fileReader.onload = function (e) {
                    self.group.grpPortrait = e.target.result;
                }
                return isJPG && isLt2M;
            }
        },
        mounted() {
            this.grpId = this.$route.query.group_id;
            this.getInformation();
            this.getTobeManager();
            this.getTobeMember();
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

    .avatar-uploader {
        width: 250px;
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .avatar-uploader:hover {
        border-color: #409EFF;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 250px;
        height: 200px;
        line-height: 200px;
        text-align: center;
    }

    .avatar {
        width: 250px;
        height: 200px;
        display: block;
    }
</style>