import axios from 'axios';
import { ElMessage } from 'element-plus';

const reqeust = axios.create({
    baseURL: 'http://localhost:9090',
    timeout: 10000,
});

reqeust.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=UTF-8';
    return config;
}, error => {
    ElMessage.error('请求超时，请检查网络连接');
    return Promise.reject(error);
});

reqeust.interceptors.response.use(response => {
    let res = response.data;
    if (typeof res === 'string') {
        res = res ? JSON.parse(res) : res
        }
        return res;
}, error => {
    if (error.response) {
        if (error.response.status === 404) {
            ElMessage.error('请求的资源不存在');
        } else if (error.response.status === 500) {
            ElMessage.error('服务器内部错误');
        } else {
            ElMessage.error(error.message);
        }
    }
    return Promise.reject(error);
})


export default reqeust;