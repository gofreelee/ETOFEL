<template>
    <el-container style="margin-top: 10px">
        <el-aside style="width: 10%; margin-right: 30px">
            <el-image :src="portrait"></el-image>
        </el-aside>
        <el-main>
            <el-row type="flex" justify="space-between" align="middle">
                <el-col style="font-weight: bold; font-size: 1.4rem" :span="12">
                    夏天吹过的小妹妹
                </el-col>
                <el-col :span="8" style="text-align: right">
                    创建时间 2020-6-12 10:00
                </el-col>
            </el-row>
            <el-row class="chat-content">
                香港股市近日连续多日均见升幅，前日恒指更一度升穿28000点，而无线前日宣布为配合港股热潮，将于下周一深宵黄金时段(即21日凌晨12时15分)重播由郑少秋、刘青云、郭蔼明、周慧敏及刘松仁主演的《大时代》，即令大批股民喊惊及呼吁别放!言犹在耳，股民最不想发生的“丁蟹效应”似乎已应验，恒指昨日收市跌454点，报收27561点，八日连升之势停止，令不少有买股票的艺人赔钱!
            </el-row>
            <el-divider></el-divider>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "GroupChatBox",
        data() {
            return {
                portrait: "http://up.enterdesk.com/edpic/fb/53/a6/fb53a628568bd0de99608fa5537be845.jpg"
            }
        }
    }
</script>

<style scoped>
    .chat-content {
        background-color: #f0f0f0;
        margin-top: 20px;
        padding: 15px
    }
</style>