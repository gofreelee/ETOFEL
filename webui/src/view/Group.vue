<template>
    <el-container>
        <el-header>
            <el-row class="header" type="flex" align="middle">
                <el-col :span="3" v-bind:class="tabClass(0)" @click.native="selectTab(0)">
                    {{typeNames[0]}}
                </el-col>
                <el-col :span="3" v-bind:class="tabClass(1)" @click.native="selectTab(1)">
                    {{typeNames[1]}}
                </el-col>
                <el-col :span="3" v-bind:class="tabClass(2)" @click.native="selectTab(2)">
                    {{typeNames[2]}}
                </el-col>
                <el-col :span="3" v-bind:class="tabClass(3)" @click.native="selectTab(3)">
                    {{typeNames[3]}}
                </el-col>
                <el-col :span="4" :offset="2">
                    <el-input placeholder="请输入群聊名" prefix-icon="el-icon-search"
                              v-model="groupName"
                              @change="getByName"/>
                </el-col>
            </el-row>
        </el-header>
        <el-main style="padding-left: 15%; padding-right: 15%">
            <el-row v-for="(item, index) in lazyShow" :key="item.grpId">
                <el-col :span="12" v-if="index % 2 === 0">
                    <GroupItem :group="lazyShow[index]"/>
                </el-col>
                <el-col :span="12" v-if="index % 2 === 0 && index + 1 < lazyShow.length">
                    <GroupItem :group="lazyShow[index+1]"/>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="9" :offset="15">
                    <el-pagination background layout="prev,pager,next"
                                   :total="groupList.length"
                                   :page-size="8"
                                   @current-change="pageChange"/>
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import GroupItem from "../components/group/GroupItem";

    export default {
        name: "Group",
        components: {
            GroupItem
        },
        computed: {
            tabClass() {
                return function (id) {
                    let obj = {
                        'select-background': false,
                        'tab': true
                    }
                    if (id === this.typeSelect) {
                        obj["select-background"] = true;
                    }
                    return obj;
                }
            },
            lazyShow() {
                let index = this.currentPage - 1;
                return this.groupList.slice(index * 8, index * 8 + 8);
            }
        },
        data() {
            return {
                typeNames: ['全部', '名师课堂群', '同城群', '结伴备考群'],
                typeSelect: 0,
                groupList: '',
                currentPage: 1,
                groupName: ''
            }
        },
        methods: {
            selectTab(id) {
                this.typeSelect = id;
                this.getByType();
            },
            getByType() {
                let config = {
                    method: 'post',
                    url: '/group/group/searchGroupByType?groupType=' + this.typeNames[this.typeSelect],
                };
                this.$axios(config).then(res => {
                    console.log(res);
                    this.groupList = res.data;
                    console.log(this.groupList);
                }).catch(function (error) {
                    console.log(error);
                });
            },
            getByName() {
                let config = {
                    method: 'post',
                    url: '/group/group/searchGroupByName?groupName=' + this.groupName,
                };
                this.$axios(config).then(res => {
                    this.groupList = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            pageChange(currentPage) {
                this.currentPage = currentPage;
            }
        },
        mounted() {
            this.getByType();
        }
    }
</script>

<style scoped>
    .header {
        margin-top: 10px;
        background-color: #f0f0f0;
        padding: 0 15% 0 17%;
        text-align: center;
        font-size: 1.1rem;
    }

    .tab {
        padding: 15px 0 15px 0;
    }

    .select-background {
        background-color: #8c939d;
    }
</style>