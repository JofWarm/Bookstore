<script>
import axios from 'axios';

export default {
  data() {
    return {
      bookTitle: '', // 用于存储书籍标题
      book: null, // 存储从后端获取的书籍信息
    };
  },
  mounted() {
    console.log("组件已挂载，正在获取书籍标题...");
    this.bookTitle = this.$route.query.title; // 从路由参数获取书籍标题
    console.log("获取到的书籍标题:", this.bookTitle); // 打印书籍标题
    if (this.bookTitle) {
      this.fetchBookDetails(this.bookTitle);
    } else {
      console.error("书籍标题未找到");
    }
  },
  methods: {

    fetchBookDetails(title) {
      console.log(`请求的 URL: /api/books/${encodeURIComponent(title)}`);

      axios.get(`/api/books/${encodeURIComponent(title)}`)
          .then(response => {
            this.book = response.data; // 确保这个数据是非空的
            console.log("获取的书籍信息:", this.book); // 输出获取的书籍信息
          })
          .catch(error => {
            console.error("获取书籍信息失败:", error);
          });
    },
    payOrder() {
      console.log('支付订单');
      this.$router.push({ name: 'pay' }); // 假设你的路由名称是 'pay'
    },
    cancelOrder() {
      window.history.back(); // 处理取消逻辑，返回前一页面
    },
  },
};
</script>

<template>
  <div id="order-page">
    <el-container>
      <el-header class="header">
        <h2>订单确认</h2>
      </el-header>
      <el-main class="main-content">
        <el-card class="order-card" v-if="book">
          <h3>《{{ book.title }}》</h3>
          <p><strong>作者：</strong>{{ book.author }}</p>
          <p><strong>简介：</strong>{{ book.description }}</p>
          <p><strong>价格：</strong>¥{{ book.price }}</p>

          <div class="button-group">
            <el-button type="primary" @click="payOrder" class="black-white-button">支付订单</el-button>
            <el-button @click="cancelOrder" class="black-white-button">取消返回</el-button>
          </div>
        </el-card>
        <p v-else>加载中...</p>
      </el-main>
    </el-container>
  </div>
</template>

<style scoped>
#order-page {
  width: 100%;
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #f5f5f5; /* 浅灰色背景，增强简约感 */
  color: #333; /* 全局字体颜色为黑色系 */
}

.header {
  background-color: #fff;
  border-bottom: 1px solid #000; /* 黑色底边，明确分界 */
  padding: 10px;
  text-align: center;
}

.main-content {
  display: flex;
  justify-content: center;
  align-items: center;
}

.order-card {
  width: 420px;
  padding: 20px;
  text-align: left; /* 左对齐，提升阅读感 */
  border: 2px solid #000; /* 边框更明显 */
  border-radius: 8px;
  background-color: #fff;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); /* 添加轻微阴影，提升层次感 */
}

h3 {
  font-size: 1.5em;
  margin-bottom: 10px;
  color: #000;
}

p {
  margin: 10px 0;
  font-size: 1.1em;
}

.button-group {
  margin-top: 20px;
  display: flex;
  justify-content: space-between;
}

.black-white-button {
  width: 48%;
  background-color: white;
  color: black;
  border: 1px solid black;
  border-radius: 4px;
  font-weight: bold;
  transition: all 0.3s ease;
}

.black-white-button:hover {
  background-color: black;
  color: white;
}

</style>
