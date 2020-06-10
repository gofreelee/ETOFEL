<template>
    <el-container class="main">
        <el-main>
            <!--轮播台-->
            <el-carousel arrow="always">
                <el-carousel-item v-for="item in 4" :key="item">
                    <h3>dfsdfsfsdf</h3>
                </el-carousel-item>
            </el-carousel>
            <el-row type="flex" justify="space-between" align="middle" style="margin-top: 10px">
                <el-col :span="6" style="font-size: 1.4rem">
                    最新发布
                </el-col>
                <el-col :span="6">
                    <el-button type="text" icon="el-icon-refresh">换一批</el-button>
                </el-col>
            </el-row>
            <hr/>
            <HomeIssue v-for="item in 4" :key="item"/>
        </el-main>
        <el-aside style="width: 35%">
            <!--签到-->
            <el-row>
                <el-col :span="11">
                    <el-button type="success" icon="el-icon-date" class="sign">签到</el-button>
                </el-col>
                <el-col :span="11" :push="2">
                    <el-button type="success" plain class="number">已签到<br>1000人</el-button>
                </el-col>
            </el-row>

            <!--热门小组-->
            <el-row type="flex" align="middle" style="font-size: 1.3rem; margin-top: 40px">
                <el-col :span="18">
                    热门小组
                </el-col>
                <el-col :span="6">
                    <el-button type="text" icon="el-icon-refresh">换一批</el-button>
                </el-col>
            </el-row>
            <HomeGroup v-for="item in 4" :key="item"/>

            <!--最新公开课-->
            <el-row type="flex" align="middle" style="font-size: 1.3rem; margin-top: 40px">
                <el-col :span="18">
                    最新公开课
                </el-col>
                <el-col :span="6">
                    <el-button type="text" icon="el-icon-refresh">换一批</el-button>
                </el-col>
            </el-row>
            <HomeCourse v-for="item in 4" :key="item"/>
        </el-aside>
    </el-container>
</template>

<script>
    import HomeIssue from "../components/home/HomeIssue";
    import HomeGroup from "../components/home/HomeGroup";
    import HomeCourse from "../components/home/HomeCourse";

    export default {
        name: "Home",
        components: {
            HomeIssue,
            HomeGroup,
            HomeCourse
        },
    }
</script>

<style scoped>
    .el-aside {
        width: 40%;
        padding: 20px 20px 20px 40px;
    }

    .main {
        padding-left: 15%;
        padding-right: 15%;
    }

    .sign {
        width: 100%;
        font-size: 2rem;
        padding-top: 20px;
        padding-bottom: 20px;
    }

    .number {
        width: 100%;
        height: 100%;
        font-size: 1rem;
        padding-top: 20px;
        padding-bottom: 20px;
    }
</style>