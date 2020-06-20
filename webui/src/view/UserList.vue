<template>
    <div class="openCourseWrapper">
        <el-form ref="search_form" :inline="true" :model="searchCondition" class="demo-form-inline">
            <el-form-item label="用户名">
                <el-input v-model="searchCondition.user_name" placeholder="用户名"></el-input>
            </el-form-item>
            <el-form-item label="状态">
                <el-select v-model="selectedState" placeholder="状态" >
                    <el-option v-for="(item, index) in ['normal', 'frozen']" :key="index + '_status'" :label="item" :value="item"></el-option>
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
                width="65">
            </el-table-column>
            <el-table-column
                prop="usr_portrait"
                label="头像"
                width="80">
                <template slot-scope="scope">
                    <el-avatar :src="scope.row.usr_portrait"></el-avatar>
                </template>
            </el-table-column>
            <el-table-column
                prop="usr_nickname"
                label="用户名称"
                width="120">
            </el-table-column>
            <el-table-column
                prop="usr_gender"
                label="性别"
                width="120"
                show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                prop="usr_email"
                label="邮箱"
                width="180"
                >
            </el-table-column>
            <el-table-column
                prop="usr_phone"
                label="电话"
                width="170"
                >
            </el-table-column>
            <el-table-column
                prop="usr_birthday" 
                label="出生日期"
                width="130"
                >
            </el-table-column>
            <el-table-column
                fixed="right"
                prop="usr_state"
                label="状态"
                >
            </el-table-column>
        </el-table>
        <div class="btn_group">
            <el-button type="success" size="small" @click="_freezing">冷冻</el-button>
            <el-button type="primary" size="small" @click="_thaw">解冻</el-button>
            <el-button type="danger" size="small" @click="_delete">删除</el-button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'openCourse',
    data() {
        return {
            tableData: [],
            searchCondition: {
                user_name: '',
                user_state: []
            },
            selectedState: '',
            selectedList: [],
            selectedUserName: []
        }
    },
    mounted() {
        this.getDataSource()
    },
    methods: {
        // 勾选 checkbox
        handleSelectionChange(value) {
            console.log(value)
            this.selectedList = value
            this.selectedUserName = []
            value.forEach(item => {
                this.selectedUserName.push(item.usr_username)
            })
            console.log(this.selectedUserName)
        },
        // 获取数据源
        getDataSource() {
            let self = this;
            function getData1() {
                return self.$axios.get(`/login/userlist/userlist`, { params: { state: 'normal' } })
            }
            function getData2() {
                return self.$axios.get(`/login/userlist/userlist`, { params: { state: 'frozen' } })
            }
            let temp = []
            this.$axios.all([getData1(), getData2()])
                .then(this.$axios.spread(function(res1, res2) {
                    console.log(res1, res2)
                    temp = temp.concat(res1.data).concat(res2.data)
                    self.tableData = temp;
                    console.log(self.tableData)
                }))
            // let total_list = []
            // let url =  `/login/userlist/userlist`
            // this.$axios.get(url, {
            //     params: {
            //         state: 'normal'
            //     }
            // }).then(res1 => {
            //     total_list = res1.data
            // }).catch(err => {
            //     console.log('获取失败', err)
            // })
            // this.$axios.get(url, {
            //     params: {
            //         state: 'frozen'
            //     }
            // }).then(res2 => {
            //     total_list.concat(res2.data)
            // }).catch(err => {
            //     console.log('获取失败', err)
            // })
            // total_list.forEach(item => {
            //     let temp = new Date(item.usr_birthday)
            //     let year = temp.getFullYear()
            //     let month = temp.getMonth() + 1
            //     if(month < 10) month = `0${month}`
            //     let date = temp.getDate()
            //     if(date < 10) date = `0${date}`
            //     item.usr_birthday = `${year}-${month}-${date}`
            // })
            // this.tableData = total_list
        },
        // 搜索
        onSearch() {
            console.log('搜索')
        },
        // 冷冻
        _freezing() {
            let body = { usernames: this.selectedUserName }
            this.$axios({
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                url: '/login/userlist/updateUserToFrozen',
                data: JSON.stringify(body)
            }).then(() => {
                console.log('冷冻用户成功！')
            }).catch(err => {
                console.log('冷冻用户失败...', err)
            })
        },
        // 解冻
        _thaw() {
            let body = { usernames: this.selectedUserName }
            this.$axios({
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                url: '/login/userlist/updateUserToNormal',
                data: JSON.stringify(body)
            }).then(() => {
                console.log('解冻成功成功！')
            }).catch(err => {
                console.log('解冻失败...', err)
            })
        },
        // 删除
        _delete() {
            let body = { usernames: this.selectedUserName }
            this.$axios({
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                url: '/login/userlist/deleteUser',
                data: JSON.stringify(body)
            }).then(() => {
                console.log('删除成功!')
            }).catch(err => {
                console.log('删除失败...', err)
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