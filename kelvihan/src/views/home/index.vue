<template>
    <div>
        <!-- 公告栏 -->
        <div style="display: flex; min-height: 35%; max-height: 48%;">
            <!-- 图表内容 -->

        </div>
        
        <!-- 使用说明 -->
        <div style="display: flex;">
            <!-- 左侧 -->
            <div style="width: 50%;">
                {{ data.Data }}
            </div>
            <!-- 右侧 -->
            <div style="width: 50%;">
                456
            </div>
        </div>
    </div>
</template>

<script setup>
import request from '@/utils/request'
import { reactive } from 'vue';

const data = reactive({
    Data: [


    ]
})



request.get('/employee/selectAll').then(res => {
    data.Data = res.data
})


</script>

<style scoped>
</style>