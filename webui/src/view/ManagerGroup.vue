<template>
    <div class="openCourseWrapper">
        <el-form ref="search_form" :inline="true" :model="searchCondition" class="demo-form-inline">
            <el-form-item label="群名称">
                <el-input v-model="searchCondition.group_title" placeholder="群名称"></el-input>
            </el-form-item>
            <el-form-item label="创建日期">
                <el-date-picker
                    v-model="searchCondition.searchDate"
                    type="date"
                    value-format="yyyy-MM-dd"
                    placeholder="选择日期">
                </el-date-picker>
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
                width="55">
            </el-table-column>
            <el-table-column
                prop="grpName"
                label="标题"
                width="160">
            </el-table-column>
            <el-table-column
                prop="grpDescription"
                label="描述"
                width="190">
            </el-table-column>
            <el-table-column
                prop="grpCreateTime"
                label="创建日期"
                width="150"
                >
            </el-table-column>
            <el-table-column
                prop="gmsUsername"
                label="创建人"
                width="130"
                >
            </el-table-column>
            <el-table-column
                prop="grpAllMembers"
                label="群组人数"
                width="130"
                >
            </el-table-column>
            <el-table-column
                prop="grpManagerNumber"
                label="管理员人数"
                >
            </el-table-column>
        </el-table>
        <div class="btn_group">
            <el-button type="danger" size="small" @click="_delete">删除</el-button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'managerGroup',
    data() {
        return {
            searchCondition: {
                group_title: '',
                searchDate: null
            },
            tableData: [],
            delete_selected_id: [],
            delete_selected_list: []
        }
    },
    mounted() {
        this.getDataSource()
    },
    methods: {
        // 表格 action 监听（checkbox 选择）
        handleSelectionChange(value) {
            console.log(value)
            this.delete_selected_list = value
            value.forEach(item => {
                this.delete_selected_id.push(item.grpId)
            })
        },
        // 获取 table 数据
        getDataSource() {
            let url =  `/group/group/managerGetGroupInfo`
            this.$axios(url).then(res => {
                console.log('数据源：', res)
                res.data.forEach(item => {
                    // 日期数据格式化
                    let temp = new Date(item.grpCreateTime)
                    let year = temp.getFullYear()
                    let mounth = temp.getMonth() + 1
                    if(mounth < 10) {
                        mounth = `0${mounth}`
                    }
                    let date =  temp.getDate()
                    if(date < 10) {
                        date = `0${date}`
                    }
                    item.grpCreateTime = `${year}-${mounth}-${date}`
                })
                this.tableData = res.data
            }).catch(err => {
                console.log('获取数据失败：', err)
            })
        },
        // 查询
        onSearch() {
            console.log(this.searchCondition.group_title, this.searchCondition.searchDate)
            let url =  `/group/group/queryGroupByNameAndDate`
            this.$axios.get(url, {
                params: {
                    grpName: this.searchCondition.group_title,
                    grpDate: this.searchCondition.searchDate
                }
            }).then(res => {
                console.log('搜索成功：', res)
                if(res.data) {
                    this.tableData = res.data 
                }
            }).catch(err => {
                console.log('搜索失败：', err)
            })
        },
        // 删除
        _delete() {
            console.log(this.delete_selected_id)
            // 要删除到 id 列表
            let body = { grpIds: this.delete_selected_id }
            this.$axios({
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                url: '/group/group/deleteGroup',
                data: JSON.stringify(body)
            }).then(() => {
                console.log('删除聊天组成功！')
                this.delete_selected_id.forEach(item => {
                    // 数据表删除对应项，表 id 从 1 开始，数据从 0 开始
                    this.tableData.splice(item - 1, 1)
                })
            }).catch(err => {
                console.log('删除聊天组失败...', err)
            })
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