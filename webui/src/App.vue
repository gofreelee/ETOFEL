<template>
    <el-container direction="vertical">
        <Header/>
        <MenuUser/>
        <Footer/>
    </el-container>
</template>

<script>
    import Header from "@/components/Header";
    import MenuUser from "@/components/MenuUser";
    import Footer from "@/components/Footer";

    export default {
        name: 'App',
        components: {
            Header,
            MenuUser,
            Footer
        }
    }
</script>

<style>
    .el-container .el-header {
        padding: 0;
    }
</style>
