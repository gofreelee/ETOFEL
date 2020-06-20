<template>
    <el-container>
        <el-main>
            <el-tabs v-model="tabName" type="card">

                <el-tab-pane label="我的课程" name="myCourse">
                    <el-row v-for="item in courseShowed" :key="item.cosId">
                        <CourseItem :course="item"/>
                    </el-row>
                    <el-row style="text-align: right">
                        <el-pagination background layout="prev, pager, next"
                                       :total="course.length"
                                       :page-size="5"
                                       @current-change="pageChange"/>
                    </el-row>
                </el-tab-pane>

                <el-tab-pane label="发布课程" name="publish" v-if="isTeacher">
                    <el-row class="info" type="flex" align="middle">
                        <el-col :span="3">
                            课程标题：
                        </el-col>
                        <el-col :span="12">
                            <el-input v-model="courseTitle"/>
                        </el-col>
                    </el-row>
                    <el-row class="info" type="flex" align="middle">
                        <el-col :span="3">
                            课程价格：
                        </el-col>
                        <el-col :span="12">
                            <el-input v-model="fee"/>
                        </el-col>
                    </el-row>
                    <el-row class="info" type="flex" align="middle">
                        <el-col :span="3">
                            开始日期：
                        </el-col>
                        <el-col :span="12">
                            <el-date-picker type="date" placeholder="选择课程开始日期"
                                            v-model="startDate"
                                            format="yyyy-MM-dd"
                                            value-format="yyyy-MM-dd"/>
                        </el-col>
                    </el-row>
                    <el-row class="info" type="flex" align="middle">
                        <el-col :span="3">
                            结束日期：
                        </el-col>
                        <el-col :span="12">
                            <el-date-picker type="date" placeholder="选择课程结束日期"
                                            v-model="endDate"
                                            format="yyyy-MM-dd"
                                            value-format="yyyy-MM-dd"/>
                        </el-col>
                    </el-row>
                    <el-row class="info" type="flex" align="middle">
                        <el-col :span="3">
                            开始时间：
                        </el-col>
                        <el-col :span="12">
                            <el-time-picker v-model="startTime"
                                            :picker-options="{
                                                selectableRange: '08:00:00 - 22:00:00'
                                            }"
                                            format="HH:mm:ss"
                                            value-format="HH:mm:ss"
                                            placeholder="选择时间"/>
                        </el-col>
                    </el-row>
                    <el-row class="info" type="flex" align="middle">
                        <el-col :span="3">
                            结束时间：
                        </el-col>
                        <el-col :span="12">
                            <el-time-picker v-model="endTime"
                                            :picker-options="{
                                                selectableRange: '08:00:00 - 22:00:00'
                                            }"
                                            format="HH:mm:ss"
                                            value-format="HH:mm:ss"
                                            placeholder="结束时间"/>
                        </el-col>
                    </el-row>
                    <el-row class="info" type="flex" align="middle">
                        <el-col :span="3">
                            课程分类：
                        </el-col>
                        <el-col :span="12">
                            <el-select v-model="courseType" placeholder="课程类别">
                                <el-option label="托福听力" value="听力"/>
                                <el-option label="托福口语" value="口语"/>
                                <el-option label="托福阅读" value="阅读"/>
                                <el-option label="托福写作" value="写作"/>
                                <el-option label="托福词汇" value="词汇"/>
                            </el-select>
                        </el-col>
                    </el-row>
                    <el-row class="info">
                        <el-col :span="3">
                            课程安排：
                        </el-col>
                        <el-col :span="15">
                            <el-input type="textarea" :rows="6" v-model="plan"/>
                        </el-col>
                    </el-row>
                    <el-row class="info">
                        <el-col :span="3">
                            上课方式：
                        </el-col>
                        <el-col :span="15">
                            <el-input type="textarea" :rows="6" v-model="pattern"/>
                        </el-col>
                    </el-row>
                    <el-row class="info">
                        <el-col :span="3">
                            听课指南：
                        </el-col>
                        <el-col :span="15">
                            <el-input type="textarea" :rows="6" v-model="guide"/>
                        </el-col>
                    </el-row>
                    <el-row class="info">
                        <el-col :span="3">
                            宣传图片：
                        </el-col>
                        <el-col :span="20">
                            <el-upload
                                    class="avatar-uploader"
                                    action="##"
                                    :show-file-list="false"
                                    :on-success="handleAvatarSuccess"
                                    :before-upload="beforeAvatarUpload">
                                <img v-if="imageUpload" :src="imageUpload" class="avatar" alt="portrait">
                                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                            </el-upload>
                        </el-col>
                    </el-row>
                    <el-row class="info">
                        <el-col :span="3" :push="3">
                            <el-button type="primary" @click="createCourse">确认</el-button>
                        </el-col>
                    </el-row>

                </el-tab-pane>

            </el-tabs>
        </el-main>
    </el-container>
</template>

<script>
    import CourseItem from "../personal/CourseItem";

    export default {
        name: "Course",
        components: {
            CourseItem
        },
        data() {
            return {
                courseTitle: '',
                startDate: '',
                endDate: '',
                startTime: '',
                endTime: '',
                courseType: '',
                plan: '',
                fee: '',
                pattern: '',
                guide: '',
                imageUpload: '',
                course: [],
                currentPage: 1,
                tabName: 'myCourse',
                isTeacher: ''
            }
        },
        computed: {
            courseShowed() {
                let index = this.currentPage - 1;
                return this.course.slice(index * 5, index * 5 + 5);
            }
        },
        methods: {
            getJoinedCourse() {
                let config = {
                    method: 'get',
                    url: '/course/userJoinCourse/getJoinedCourse?ujcUsrUsername=' + sessionStorage.getItem("username"),
                };

                this.$axios(config).then(res => {
                    this.course = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            pageChange(currentPage) {
                this.currentPage = currentPage;
            },
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
            createCourse() {
                let data = new FormData();
                data.append('cosTitle', this.courseTitle);
                data.append('cosStartDate', this.startDate);
                data.append('cosEndDate', this.endDate);
                data.append('cosStartTime', this.startTime);
                data.append('cosEndTime', this.endTime);
                data.append('cosFee', this.fee);
                data.append('cosCategory', this.courseType);
                data.append('cdtTchUsername', sessionStorage.getItem("username"));
                data.append('cdtPortrait', this.imageUpload);
                data.append('cdtPlan', this.plan);
                data.append('cdtPattern', this.pattern);
                data.append('cdtGuide', this.guide);

                let config = {
                    method: 'post',
                    url: '/course/course/releaseCourse',
                    headers: {'Content-Type': 'application/json',},
                    data: data
                };

                this.$axios(config).then(res => {
                    if (res.data == null) {
                        alert("课程创建失败");
                    } else {
                        alert("课程创建成功")
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        mounted() {
            this.getJoinedCourse();
            this.isTeacher = sessionStorage.getItem('identity') === 'teacher';
        }
    }
</script>

<style scoped>
    .info {
        padding: 10px 0 10px 0;
    }

    .avatar-uploader {
        width: 400px;
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
        width: 400px;
        height: 200px;
        line-height: 200px;
        text-align: center;
    }

    .avatar {
        width: 400px;
        height: 200px;
        display: block;
    }
</style>