<template>
    <el-container>
        <el-main>
            <el-tabs v-model="activeTab" type="card">

                <el-tab-pane label="我加入的群" name="join">
                    <el-row v-for="item in joinList" :key="item.grpId">
                        <GroupItem :is-admin="false" :group="item"/>
                    </el-row>
                    <el-row style="text-align: right">
                        <el-pagination background layout="prev, pager, next"
                                       :total="groupJoinedList.length"
                                       :page-size="5"
                                       @current-change="joinPageChange"/>
                    </el-row>
                </el-tab-pane>


                <el-tab-pane label="我管理的群" name="admin">
                    <el-row v-for="item in manageList" :key="item.grpId">
                        <GroupItem :is-admin="true" :group="item"/>
                    </el-row>
                    <el-row style="text-align: right">
                        <el-pagination background layout="prev, pager, next"
                                       :total="groupManageList.length"
                                       :page-size="5"
                                       @current-change="managePageChange"/>
                    </el-row>
                </el-tab-pane>


                <el-tab-pane label="我要建群" name="establish">
                    <el-container>
                        <el-main>

                            <el-row type="flex" align="middle">
                                <el-col :span="3">
                                    选择群类别
                                </el-col>
                                <el-col :span="18" :push="1">
                                    <el-select v-model="groupType" placeholder="群类别">
                                        <el-option label="名师课堂群" value="名师课堂群"></el-option>
                                        <el-option label="同城群" value="同城群"></el-option>
                                        <el-option label="结伴备考群" value="结伴备考群"></el-option>
                                    </el-select>
                                </el-col>
                            </el-row>

                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    群名称
                                </el-col>
                                <el-col :span="18" :push="1">
                                    <el-input v-model="groupName"></el-input>
                                </el-col>
                            </el-row>

                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    上传群头像
                                </el-col>
                                <el-col :span="18" :push="1">
                                    <el-upload class="avatar-uploader"
                                               action="##"
                                               :show-file-list="false"
                                               :on-success="handleAvatarSuccess"
                                               :before-upload="beforeAvatarUpload">
                                        <img v-if="imageUrl" :src="imageUrl" class="avatar" alt="群头像">
                                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                                    </el-upload>
                                </el-col>
                            </el-row>

                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    群介绍
                                </el-col>
                                <el-col :span="18" :push="1">
                                    <el-input v-model="groupDescription" type="textarea" :rows="5"
                                              placeholder="至少10个字"></el-input>
                                </el-col>
                            </el-row>

                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    群规则
                                </el-col>
                                <el-col :span="18" :push="1">
                                    <el-input v-model="groupRule" type="textarea" :rows="5"
                                              placeholder="至少10个字"></el-input>
                                </el-col>
                            </el-row>

                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3" :push="4">
                                    <el-button type="success" style="width: 100%" @click="createGroup">确定</el-button>
                                </el-col>
                                <el-col :span="3" :push="5">
                                    <el-button type="warning" style="width: 100%" @click="clearGroup">重置</el-button>
                                </el-col>
                            </el-row>
                        </el-main>
                    </el-container>
                </el-tab-pane>
            </el-tabs>
        </el-main>
    </el-container>
</template>

<script>
    import GroupItem from "./GroupItem";

    export default {
        name: "MyGroup",
        components: {
            GroupItem
        },
        computed: {
            joinList() {
                let index = this.joinedPage - 1;
                return this.groupJoinedList.slice(index * 5, index * 5 + 5);
            },
            manageList() {
                let index = this.managePage - 1;
                return this.groupManageList.slice(index * 5, index * 5 + 5);
            }
        },
        data() {
            return {
                activeTab: 'join',
                groupType: '名师课堂群',
                groupName: '',
                imageUrl: '',
                groupDescription: '',
                groupRule: '',

                groupJoinedList: [],
                joinedPage: 1,
                groupManageList: [],
                managePage: 1
            }
        },
        methods: {
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
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
                    self.imageUrl = e.target.result;
                }

                return isJPG && isLt2M;
            },
            getManageGroup() {
                let config = {
                    method: 'get',
                    url: '/group/group/groupManaged?gmsUsername=' + sessionStorage.getItem("username"),
                };

                this.$axios(config).then(res => {
                    console.log(res.data);
                    this.groupManageList = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            getJoinGroup() {
                let config = {
                    method: 'get',
                    url: '/group/group/groupJoined?gmsUsername=' + sessionStorage.getItem("username"),
                };

                this.$axios(config).then(res => {
                    this.groupJoinedList = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            joinPageChange(currentPage) {
                this.joinedPage = currentPage;
            },
            managePageChange(currentPage) {
                this.managePage = currentPage;
            },
            createGroup() {
                let data = new FormData();
                data.append('grpType', this.groupType);
                data.append('grpName', this.groupName);
                data.append('grpDescription', this.groupDescription);
                data.append('grpRule', this.groupRule);
                data.append('grpPortrait', this.imageUrl);
                data.append('grpCreator', sessionStorage.getItem("username"));

                let config = {
                    method: 'post',
                    url: '/group/group/createGroup',
                    data: data
                };

                this.$axios(config).then(res => {
                    if (res.data !== 0) {
                        alert("成功创建群");
                        this.getManageGroup();
                        this.clearGroup();
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            },
            clearGroup() {
                this.groupName = '';
                this.groupDescription = '';
                this.groupRule = '';
                this.imageUrl = null;
            }
        },
        mounted() {
            this.getJoinGroup();
            this.getManageGroup();
        }
    }
</script>

<style scoped>
    .info {
        padding: 20px 0 0 0;
    }

    .avatar-uploader {
        width: 200px;
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
        width: 200px;
        height: 200px;
        line-height: 200px;
        text-align: center;
    }

    .avatar {
        width: 200px;
        height: 200px;
        display: block;
    }
</style>