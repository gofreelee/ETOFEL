<template>
    <el-container>
        <el-main>
            <el-tabs v-model="activeTab" type="card">

                <el-tab-pane label="我加入的群" name="join">
                    <GroupItem v-for="item in 5" :key="item" :is-admin="false"/>
                    <el-row style="text-align: right">
                        <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
                    </el-row>
                </el-tab-pane>


                <el-tab-pane label="我管理的群" name="admin">
                    <GroupItem v-for="item in 5" :key="item" :is-admin="true"/>
                    <el-row style="text-align: right">
                        <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
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
                                        <el-option label="名师课堂群" value="course"></el-option>
                                        <el-option label="同城群" value="city"></el-option>
                                        <el-option label="结伴考试群" value="team"></el-option>
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
                                    <el-button type="success" style="width: 100%">确定</el-button>
                                </el-col>
                                <el-col :span="3" :push="5">
                                    <el-button type="warning" style="width: 100%">重置</el-button>
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
        data() {
            return {
                activeTab: 'join',
                groupType: 'course',
                groupName: '',
                imageUrl: '',
                groupDescription: '',
                groupRule: ''
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
                return isJPG && isLt2M;
            }
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