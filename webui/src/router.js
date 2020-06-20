import Vue from 'vue';
import VueRouter from "vue-router";

// 用户页面
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
const GroupInfoModify =() => import("view/GroupInfoModify")

// 管理员页面
const SysManager = () => import('view/SysManager.vue')
const UserList = () => import('view/UserList.vue')
const TeacherList = () => import('view/TeacherList.vue') 
const ManagerTofelArticle = () => import('view/ManagerTofelArticle.vue')
const ManagerGroup = () => import('view/ManagerGroup.vue')
const LearningCourse = () => import('view/LearningCourse.vue')

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
        path: '/group/group-info-modify',
        component: GroupInfoModify
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
        path: '/user-list-manager',
        component: UserList
    },
    {
        path: '/teacher-list-manager',
        component: TeacherList
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
        path: '/manager-learning-course',
        component: LearningCourse
    }
]

export default new VueRouter({
    mode: 'history',
    routes: routes
})