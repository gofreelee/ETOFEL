<template>
    <el-container>
        <el-header style="margin-top: 10px;">
            <el-row type="flex" align="middle" class="header-first" style="text-align: center">
                <el-col :span="2" :offset="5" @click.native="selectCourseType(0)"
                        v-bind:class="{'course-type-select': courseTypeList[0]}">
                    公益课程
                </el-col>
                <el-col :span="2" @click.native="selectCourseType(1)"
                        v-bind:class="{'course-type-select': courseTypeList[1]}">
                    热门课程
                </el-col>
                <el-col :span="2" @click.native="selectCourseType(2)"
                        v-bind:class="{'course-type-select': courseTypeList[2]}">
                    名师精品课
                </el-col>
            </el-row>
        </el-header>
        <el-main style="margin-left: 15%; margin-right: 15%;">
            <el-row class="header-second" type="flex" align="middle" style="padding: 10px 0 10px 0">
                <el-col :span="2" :offset="1" @click.native="selectCourseCategory(0)"
                        v-bind:class="{'course-category-select':categorySelected[0]}">
                    全部课程
                </el-col>
                <el-col :span="2" @click.native="selectCourseCategory(1)"
                        v-bind:class="{'course-category-select':categorySelected[1]}">
                    托福口语
                </el-col>
                <el-col :span="2" @click.native="selectCourseCategory(2)"
                        v-bind:class="{'course-category-select':categorySelected[2]}">
                    托福听力
                </el-col>
                <el-col :span="2" @click.native="selectCourseCategory(3)"
                        v-bind:class="{'course-category-select':categorySelected[3]}">
                    托福阅读
                </el-col>
                <el-col :span="2" @click.native="selectCourseCategory(4)"
                        v-bind:class="{'course-category-select':categorySelected[4]}">
                    托福写作
                </el-col>
                <el-col :span="2" @click.native="selectCourseCategory(5)"
                        v-bind:class="{'course-category-select':categorySelected[5]}">
                    托福词汇
                </el-col>
<!--                <el-col :span="5" :push="5">-->
<!--                    <el-input placeholder="请输入课程名" prefix-icon="el-icon-search"/>-->
<!--                </el-col>-->
            </el-row>

            <CourseItem v-for="item in lazyShow"
                        :key="item.cosId" :course="item"/>

            <el-row style="text-align: center; margin-top: 40px">
                <el-pagination background layout="prev, pager, next" :total="courseList.length"
                               :page-size="5"
                               @current-change="pageChange"/>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import CourseItem from "../components/course/CourseItem";

    export default {
        name: "Course",
        data() {
            return {
                courseType: 4,
                courseTypeList: [false, false, false, false],
                category: 0,
                categoryNames: ['全部', '口语', '听力', '阅读', '写作', '词汇'],
                categorySelected: [true, false, false, false, false, false],
                courseList: [],
                currentPage: 1
            }
        },
        components: {
            CourseItem
        },
        computed: {
            lazyShow() {
                let index = this.currentPage - 1;
                return this.courseList.slice(index * 5, index * 5 + 5);
            }
        },
        methods: {
            selectCourseType(type) {
                if (this.courseTypeList[type] === false) {
                    this.$set(this.courseTypeList, this.courseType, false);
                    this.$set(this.courseTypeList, type, true);
                    this.courseType = type;
                } else {
                    this.$set(this.courseTypeList, type, false);
                    this.courseType = 4;
                }
                this.getCourse();
            },
            selectCourseCategory(category) {
                this.$set(this.categorySelected, this.category, false);
                this.$set(this.categorySelected, category, true);
                this.category = category;
                this.getCourse();
            },
            getCourse() {
                let url = "/course/course/welfareCastle?type=" + this.courseType + "&cosCategory=" + this.categoryNames[this.category];
                this.$axios.get(url).then(res => {
                    this.courseList = res.data;
                });
            },
            pageChange(currentPage) {
                this.currentPage = currentPage;
            }
        },
        mounted() {
            this.getCourse();
        }
    }
</script>

<style scoped>
    .header-first {
        background: #f0f0f0;
    }

    .header-first .el-col {
        padding-top: 15px;
        padding-bottom: 15px;
        cursor: pointer;
    }

    .header-second {
        border-style: solid;
        border-width: 1px;
        border-radius: 10px;
        border-color: #ededed;
        background: aliceblue;
        text-align: center;
    }

    .header-second .el-col {
        padding: 10px;
        height: 100%;
        cursor: pointer;
    }

    .course-type-select {
        background-color: #8c939d;
    }

    .course-category-select {
        background-color: #409EFF;
        border: 1px solid #409EFF;
        border-radius: 10px;
    }
</style>