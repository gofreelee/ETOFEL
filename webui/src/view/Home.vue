<template>
    <el-container class="main">
        <el-main>
            <!--轮播台-->
            <el-carousel arrow="always">
                <el-carousel-item v-for="item in imgUrls" :key="item">
                    <el-image :src="item" fit="fill" style="width: 100%; height: 100%"/>
                </el-carousel-item>
            </el-carousel>
            <el-row type="flex" justify="space-between" align="middle" style="margin-top: 10px">
                <el-col :span="6" style="font-size: 1.4rem">
                    最新发布
                </el-col>
                <el-col :span="6">
                    <el-button type="text" icon="el-icon-refresh" @click="articleCommend">换一批</el-button>
                </el-col>
            </el-row>
            <hr/>
            <el-row v-for="item in articles" :key="item">
                <HomeIssue :article="item"/>
            </el-row>
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
                    <el-button type="text" icon="el-icon-refresh" @click="groupCommend">换一批</el-button>
                </el-col>
            </el-row>
            <el-row v-for="item in groups" :key="item">
                <HomeGroup :group="item"/>
            </el-row>

            <!--最新公开课-->
            <el-row type="flex" align="middle" style="font-size: 1.3rem; margin-top: 40px">
                <el-col :span="18">
                    最新公开课
                </el-col>
                <el-col :span="6">
                    <el-button type="text" icon="el-icon-refresh" @click="courseCommend">换一批</el-button>
                </el-col>
            </el-row>
            <el-row v-for="item in courses" :key="item.cosId">
                <HomeCourse :course="item"/>
            </el-row>
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
        data() {
            return {
                imgUrls: ["https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3989732581,3676180283&fm=26&gp=0.jpg",
                    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1592474268779&di=8d0b3720b8f08cd47bfdde14db69eef0&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F11%2F93%2F16pic_1193108_b.jpg"],
                articles: [],
                groups: [],
                courses: []
            }
        },
        methods: {
            articleCommend() {
                let config = {
                    method: 'get',
                    url: '/article/tofel-article/random-article',
                };

                this.$axios(config).then(res => {
                    this.articles = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            groupCommend() {
                let config = {
                    method: 'get',
                    url: '/group/group/randomGroup?need=4',
                };

                this.$axios(config).then(res => {
                    this.groups = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            courseCommend() {
                let config = {
                    method: 'get',
                    url: '/course/course/courseRecommend?need=4',
                };

                this.$axios(config).then(res => {
                    this.courses = res.data;
                }).catch(function (error) {
                    console.log(error);
                });

            }
        },
        mounted() {
            this.articleCommend();
            this.groupCommend();
            this.courseCommend();
        }
    }
</script>

<style scoped>
    .el-aside {
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