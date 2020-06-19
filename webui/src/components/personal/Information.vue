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
                                    <el-input v-model="information.usr_username"/>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    昵称:
                                </el-col>
                                <el-col :span="12">
                                    <el-input v-model="information.usr_nickname"/>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    性别:
                                </el-col>
                                <el-col :span="12">
                                    <el-radio-group v-model="information.usr_gender">
                                        <el-radio label="男">男</el-radio>
                                        <el-radio label="女">女</el-radio>
                                    </el-radio-group>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    邮箱:
                                </el-col>
                                <el-col :span="12">
                                    <el-input v-model="information.usr_email"/>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    电话:
                                </el-col>
                                <el-col :span="12">
                                    <el-input v-model="information.usr_phone"/>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    出生日期:
                                </el-col>
                                <el-col :span="12">
                                    <el-date-picker type="date" placeholder="选择日期"
                                                    v-model="information.usr_birthday"
                                                    format="yyyy-MM-dd"
                                                    value-format="yyyy-MM-dd"/>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="3">
                                    个性签名:
                                </el-col>
                                <el-col :span="12">
                                    <el-input type="textarea" :rows="8" placeholder="请输入内容"
                                              v-model="information.usr_sign"/>
                                </el-col>
                            </el-row>
                            <el-row type="flex" align="middle" class="info">
                                <el-col :span="4" :push="3">
                                    <el-button type="primary" @click="updateInformation">提交修改</el-button>
                                </el-col>
                            </el-row>
                        </el-main>
                    </el-container>
                </el-tab-pane>


                <el-tab-pane label="头像管理" name="portrait">
                    <el-row style="font-size: 1.2rem; margin: 20px 0 20px 0">
                        选择上传的头像
                    </el-row>
                    <el-upload
                            class="avatar-uploader"
                            action="##"
                            :show-file-list="false"
                            :on-success="handleAvatarSuccess"
                            :before-upload="beforeAvatarUpload">
                        <img v-if="imageUpload" :src="imageUpload" class="avatar" alt="portrait">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                    <el-row style="margin: 20px 0 20px 0">
                        <el-button type="primary" @click="updatePortrait">上传头像</el-button>
                    </el-row>
                </el-tab-pane>


                <el-tab-pane label="密码修改" name="password">
                    <el-row type="flex" align="middle">
                        <el-col :span="4">
                            原始密码:
                        </el-col>
                        <el-col :span="12">
                            <el-input v-model="inputOriginalPwd" show-password/>
                        </el-col>
                    </el-row>
                    <el-row type="flex" align="middle" class="info">
                        <el-col :span="4">
                            新密码:
                        </el-col>
                        <el-col :span="12">
                            <el-input v-model="inputNewPwd" show-password/>
                        </el-col>
                    </el-row>
                    <el-row type="flex" align="middle" class="info">
                        <el-col :span="4">
                            确认新密码:
                        </el-col>
                        <el-col :span="12">
                            <el-input v-model="inputNewPwd2" show-password/>
                        </el-col>
                    </el-row>
                    <el-row type="flex" align="middle" class="info">
                        <el-col :span="4" :push="4">
                            <el-button type="primary" @click="updatePassword">提交修改</el-button>
                        </el-col>
                    </el-row>
                </el-tab-pane>
            </el-tabs>
        </el-main>
    </el-container>
</template>

<script>
    import Vue from "vue";

    export default {
        name: "Information",
        data() {
            return {
                tabName: 'information',
                information: '',
                imageUpload: '',
                inputOriginalPwd: '',
                inputNewPwd: '',
                inputNewPwd2: ''
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
                    self.imageUpload = e.target.result;
                }
                return isJPG && isLt2M;
            },
            updateInformation() {
                let data = new FormData();
                data.append('usr_username', this.information.usr_username);
                data.append('usr_nickname', this.information.usr_nickname);
                data.append('usr_email', this.information.usr_email);
                data.append('usr_birthday', this.information.usr_birthday);
                data.append('usr_sign', this.information.usr_sign);
                data.append('usr_phone', this.information.usr_phone);
                data.append('usr_gender', this.information.usr_gender);

                let config = {
                    method: 'post',
                    url: '/user/user/update',
                    headers: {'Content-Type': 'application/json'},
                    data: data
                };

                this.$axios(config).then(res => {
                    this.information = res.data;
                    Vue.prototype.$user = res.data;
                    alert("修改成功");
                }).catch(function (error) {
                    console.log(error);
                });
            },
            updatePassword() {
                if (this.inputOriginalPwd !== this.information.usr_password) {
                    alert("原始密码输入错误");
                    return;
                } else if (this.inputNewPwd !== this.inputNewPwd2) {
                    alert("两次输入新密码不一致");
                    return;
                }

                let data = new FormData();
                data.append('usr_username', this.information.usr_username);
                data.append('newpassword1', this.inputNewPwd);

                let config = {
                    method: 'post',
                    url: '/user/user/updatePwd',
                    headers: {'Content-Type': 'application/json'},
                    data: data
                };

                this.$axios(config).then(res => {
                    this.information.usr_password = res.data;
                    Vue.prototype.$user.usr_password = res.data;
                    alert("密码修改成功");
                }).catch(function (error) {
                    console.log(error);
                });
            },
            updatePortrait() {
                let data = new FormData();
                data.append('imgFile', this.imageUpload);
                data.append('usr_username', this.information.usr_username);

                let config = {
                    method: 'post',
                    url: '/user/user/updatePhoto',
                    data: data
                };

                this.$axios(config).then(res => {
                    this.information.usr_portrait = res.data;
                    Vue.prototype.$user.usr_portrait = res.data;
                    alert("头像修改成功，刷新显示");
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        mounted() {
            this.information = Vue.prototype.$user;
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