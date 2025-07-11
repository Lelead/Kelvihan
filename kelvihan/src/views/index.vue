<template>
    <!-- 顶部 -->
    <div class="heder" style="height: 65px; background-color: #fff; display: flex; justify-content: space-between; align-items: center; padding: 0 20px; border-bottom: 1px solid #eee;">
        <!-- 左侧logo -->
        <div class="">
            <img src="">
            <span>学生管理系统</span>
        </div>
        
        <!-- 右侧用户信息 -->
        <div class="user-info">
            <el-dropdown placement="bottom-end" trigger="click" style="border: none;">
                <span style="cursor: pointer; display: flex; align-items: center;">
                    <img :src="user.avatar" style="width: 30px; height: 30px; border-radius: 50%; margin-right: 10px;">
                    {{ user.name }}
                    <el-icon>
                        <arrow-down />
                    </el-icon>
                </span>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item>个人中心</el-dropdown-item>
                        <el-dropdown-item>退出当前账户</el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>
    </div>

    <!-- 主体 -->
    <div class="main" style="display: flex;">
        <!-- 左侧 -->
        <div style="width: 180px; min-height: calc(100vh - 40px); border-right: 1px solid #eee;">
            <el-menu
            style="border: 0;"
            :default-active="activeIndex"
            router="true"
            unique-opened="true"
            >
                <el-menu-item index="/home">首页</el-menu-item>
                <el-sub-menu index="/system">
                    <template #title>系统管理</template>
                    <el-menu-item index="/system/menu">菜单管理</el-menu-item>
                    <el-menu-item index="/system/role">字典管理</el-menu-item>
                    <el-menu-item index="/system/user">用户管理</el-menu-item>
                </el-sub-menu>
                <el-sub-menu index="/students">
                    <template #title>学生管理</template>
                    <el-menu-item index="/students/list">学生列表</el-menu-item>
                    <el-menu-item index="/students/info">学生信息</el-menu-item>
                    <el-menu-item index="/students/score">评分管理</el-menu-item>
                </el-sub-menu>
                <el-sub-menu index="/teachers">
                    <template #title>教师管理</template>
                        <el-menu-item index="/teachers/list">教师列表</el-menu-item>
                        <el-menu-item index="/teachers/info">教师信息</el-menu-item>
                        <el-menu-item index="/teachers/score">评分管理</el-menu-item>
                </el-sub-menu>
            </el-menu>
        </div>
        <!-- 右侧 -->
        <div style="flex: 1; padding: 10px 0 0 20px;">
            <RouterView/>
        </div>
    </div>
</template>

<script setup>
// import { ArrowDown } from '@element-plus/icons-vue'
import { useRoute, RouterView } from 'vue-router';
import { ref, watch, computed } from 'vue';

const user = ref({
    name: 'admin',
    avatar: 'https://cdn.picui.cn/vip/2025/07/11/68710d5fbdbb3.jpg'
})

const activeIndex =  computed(() => route.path)
const openedIndex = ref([])
const route = useRoute()


watch(() => route.path, (newPath) => {
    const paths = newPath.split('/').filter(p => p)
  if (paths.length > 1) {
    openedIndex.value = [`/${paths[0]}`]
  }
}, { immediate: true })
</script>

<style scoped>

</style>