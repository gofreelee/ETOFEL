<template>
    <el-container>
        <el-main>
            <el-tabs v-model="tabName" type="card">
                <el-tab-pane label="基本资料" name="information">
                    <el-container>
                        <el-main>
                            <el-row type="flex" align="middle">
                                <el-col :span="3">
                                    用户名:
                                </el-col>
                                <el-col :span="12">
                                    <el-input></el-input>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    性别:
                                </el-col>
                                <el-col :span="12">
                                    <el-radio-group v-model="gender">
                                        <el-radio label="male">男</el-radio>
                                        <el-radio label="female">女</el-radio>
                                    </el-radio-group>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    邮箱:
                                </el-col>
                                <el-col :span="12">
                                    <el-input></el-input>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    电话:
                                </el-col>
                                <el-col :span="12">
                                    <el-input></el-input>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    出生日期:
                                </el-col>
                                <el-col :span="12">
                                    <el-date-picker type="date" placeholder="选择日期" v-model="birthday"></el-date-picker>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    个性签名:
                                </el-col>
                                <el-col :span="12">
                                    <el-input type="textarea" :rows="8" placeholder="请输入内容" v-model="sign"></el-input>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="4" :push="3">
                                    <el-button type="primary">提交修改</el-button>
                                </el-col>
                            </el-row>
                        </el-main>
                    </el-container>
                </el-tab-pane>


                <el-tab-pane label="头像管理" name="portrait">
                    <el-row style="font-size: 1.2rem; margin: 20px 0 20px 0">
                        选择上传的头像
                    </el-row>
                    <el-upload class="avatar-uploader"
                            action="##"
                            :show-file-list="false"
                            :on-success="handleAvatarSuccess"
                            :before-upload="beforeAvatarUpload">
                        <img v-if="imageUrl" :src="imageUrl" class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                    <el-row style="margin: 20px 0 20px 0">
                        <el-button type="primary">上传头像</el-button>
                    </el-row>
                </el-tab-pane>


                <el-tab-pane label="密码修改" name="password">
                    <el-row type="flex" align="middle">
                        <el-col :span="4">
                            原始密码:
                        </el-col>
                        <el-col :span="12">
                            <el-input></el-input>
                        </el-col>
                    </el-row>
                    <el-row type="flex" align="middle" class="info">
                        <el-col :span="4">
                            新密码:
                        </el-col>
                        <el-col :span="12">
                            <el-input></el-input>
                        </el-col>
                    </el-row>
                    <el-row type="flex" align="middle" class="info">
                        <el-col :span="4">
                            确认新密码:
                        </el-col>
                        <el-col :span="12">
                            <el-input></el-input>
                        </el-col>
                    </el-row>
                    <el-row type="flex" align="middle" class="info">
                        <el-col :span="4" :push="4">
                            <el-button type="primary">提交修改</el-button>
                        </el-col>
                    </el-row>
                </el-tab-pane>
            </el-tabs>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "Information",
        data() {
            return {
                tabName: 'information',
                gender: 'male',
                birthday: '',
                sign: '',
                imageUrl: ''
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
        width: 300px;
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
        width: 300px;
        height: 300px;
        line-height: 300px;
        text-align: center;
    }

    .avatar {
        width: 300px;
        height: 300px;
        display: block;
    }

</style>