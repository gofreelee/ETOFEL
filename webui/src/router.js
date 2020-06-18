import Vue from 'vue';
import VueRouter from "vue-router";
// import Home from "./view/Home";
// import TofelArticle from "./view/TofelArticle";
// import Group from "./view/Group";
// import GroupInformation from "./view/GroupInformation";
// import ChatRoom from "./view/ChatRoom";
// import ArticleDetail from "./view/ArticleDetail";
// import Course from "./view/Course";
// import CourseDetail from "./view/CourseDetail";
// import Login from "./view/Login";
// import Register from "./view/Register";
// import PersonalCenter from "./view/PersonalCenter";

const Home = () => import('view/Home.vue')
const TofelArticle = () => import('view/TofelArticle.vue')
const Group = () => import('view/Group.vue')
const GroupInformation = () => import('view/GroupInformation.vue')
const ChatRoom = () => import('view/ChatRoom.vue')
const ArticleDetail = () => import('view/ArticleDetail.vue')
const Course = () => import('view/Course.vue')
const CourseDetail = () => import('view/CourseDetail.vue')
const Login = () => import('view/Login.vue')
const Register = () => import('view/Register.vue')
const PersonalCenter = () => import('view/PersonalCenter.vue')

// 管理员页面
const SysManager = () => import('view/sysManager.vue')
const UserManager = () => import('view/userManager.vue')
const ManagerTofelArticle = () => import('view/managerTofelArticle.vue')
const ManagerGroup = () => import('view/managerGroup.vue')
const OpenCourse = () => import('view/openCourse.vue')
const WelfareCastle = () => import('view/welfareCastle.vue')


Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        component: Home
    },
    {
        path: '/home',
        component: Home
    }, 
    {
        path: '/tofel-article',
        component: TofelArticle
    }, 
    {
        path: '/group',
        component: Group
    }, 
    {
        path: '/group/group-information',
        component: GroupInformation
    }, 
    {
        path: '/group/chat-room',
        component: ChatRoom
    }, 
    {
        path: '/tofel-article/detail',
        component: ArticleDetail
    }, 
    {
        path: '/course',
        component: Course
    }, 
    {
        path: '/course/course-detail',
        component: CourseDetail
    }, 
    {
        path: '/login',
        component: Login
    }, 
    {
        path: '/register',
        component: Register
    }, 
    {
        path: '/personal-center',
        component: PersonalCenter
    },
    {
        path: '/sys-manager',
        component: SysManager
    },
    {
        path: '/user-manager',
        component: UserManager
    },
    {
        path: '/manager-tofel-article',
        component: ManagerTofelArticle
    },
    {
        path: '/manager-group',
        component: ManagerGroup
    },
    {
        path: '/manager-open-course',
        component: OpenCourse
    },
    {
        path: '/manager-welfare-castle',
        component: WelfareCastle
    }
]

export default new VueRouter({
    mode: 'history',
    routes: routes
})