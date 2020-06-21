<template>
    <div class="openCourseWrapper">
        <el-form ref="search_form" :inline="true" :model="searchCondition" class="demo-form-inline">
            <el-form-item label="标题">
                <el-input v-model="searchCondition.course_title" placeholder="标题"></el-input>
            </el-form-item>
            <el-form-item label="发布讲师">
                <el-select v-model="selectedTeacher" placeholder="发布讲师" >
                    <el-option v-for="(item, index) in searchCondition.teacher_list" :key="index + '_teacher'" :label="item" :value="item"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSearch">查询</el-button>
            </el-form-item>
        </el-form>
        <el-table
                ref="multipleTable"
                :data="tableData"
                tooltip-effect="dark"
                style="width: 100%"
                @selection-change="handleSelectionChange">
            <el-table-column
                type="selection"
                width="75">
            </el-table-column>
            <el-table-column
                prop="art_title"
                label="文章标题"
                width="220">
            </el-table-column>
            <el-table-column
                prop="art_type"
                label="文章类别"
                width="220">
            </el-table-column>
            <el-table-column
                prop="art_username"
                label="发布讲师"
                width="220"
                show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                prop="art_date"
                label="发布时间"
                >
            </el-table-column>
        </el-table>
<!--        <div class="btn_group">-->
<!--            <el-button type="success" size="small" @click="_forbidden">禁读</el-button>-->
<!--            <el-button type="primary" size="small" @click="_liftTheBan">解禁</el-button>-->
<!--            <el-button type="danger" size="small" @click="_delete">删除</el-button>-->
<!--        </div>-->
    </div>
</template>

<script>
export default {
    name: 'openCourse',
    data() {
        return {
            tableData: [],
            articleSelectedTitle: [],
            searchCondition: {
                course_title: '',
                teacher_list: []
            },
            selectedTeacher: ''
        }
    },
    mounted() {
        this.getDataSource()
    },
    methods: {
        // 勾选 checkbox
        handleSelectionChange(value) {
            console.log(value)
            this.articleSelectedTitle = []
            value.forEach(item => {
                this.articleSelectedTitle.push(item.art_title)
            })
        },
        // 获取数据源
        getDataSource() {
            let url =  `/article/tofel-article/getAllArticle`
            this.$axios(url).then(res => {
                console.log('文章数据源：', res)
                this.tableData = res.data 
                // 填充查询条件讲师下拉列表
                res.data.forEach(item => {
                    // this.searchCondition.course_type_list.push(item.cosCategory)
                    this.searchCondition.teacher_list.push(item.art_username)
                    // 日期格式化
                    let temp = new Date(item.art_date)
                    let year = temp.getFullYear()
                    let month = temp.getMonth() + 1
                    if(month < 10) month = `0${month}`
                    let date = temp.getDate()
                    if(date < 10) date = `0${date}`
                    item.art_date = `${year}-${month}-${date}`
                }) 
                // 列表去重复
                this.searchCondition.teacher_list = new Set(this.searchCondition.teacher_list)
            }).catch(err => {
                console.log('获取文章数据失败：', err)
            })
        },
        // 搜索
        onSearch() {
            let url =  `/article/tofel-article/managerSearchDynamic`
            console.log(this.selectedTeacher, this.searchCondition.course_title)
            this.$axios.get(url, {
                params: {
                    artUsername: this.selectedTeacher,
                    artTitle: this.searchCondition.course_title
                }
            }).then(res => {
                console.log('文章数据源：', res)
                if(res) {
                    this.tableData = res.data 
                    res.data.forEach(item => {
                        // 日期格式化
                        let temp = new Date(item.art_date)
                        let year = temp.getFullYear()
                        let month = temp.getMonth() + 1
                        if(month < 10) month = `0${month}`
                        let date = temp.getDate()
                        if(date < 10) date = `0${date}`
                        item.art_date = `${year}-${month}-${date}`
                    }) 
                }
            }).catch(err => {
                console.log('获取文章数据失败：', err)
            })
        },
        // 禁读
        _forbidden() {
        },
        _liftTheBan() {

        },
        _delete() {
            // let body = { artIds: this.articleSelectedTitle }
            // this.$axios({
            //     method: 'POST',
            //     headers: {
            //         'Content-Type': 'application/json'
            //     },
            //     url: '',
            //     data: JSON.stringify(body)
            // }).then(() => {
            //     console.log('删除文章成功！')
            //     // this.articleSelectedTitle.forEach(item => {
            //     //     // 数据表删除对应项，表 id 从 1 开始，数据从 0 开始
            //     //     this.tableData.splice(item - 1, 1)
            //     // })
            // }).catch(err => {
            //     console.log('删除文章失败...', err)
            // })
        }
    }
}
</script>

<style scoped>
    .openCourseWrapper {
        width: 70%;
        margin: 0 auto;
        margin-top: 40px;
        margin-bottom: 60px;
    }
    .btn_group {
        margin-top: 15px;
    }
    .el-table .warning-row {
        background: oldlace;
    }
</style>