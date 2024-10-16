<template>
  <div id="alipay-page">
    <h2>支付宝支付</h2>
    <div class="qr-section">
      <p>请使用支付宝扫码支付</p>
      <img :src="wechatQRCode" alt="支付宝支付二维码" class="qr-code" />
    </div>
    <el-button type="primary" @click="back" class="cancel-button">取消支付</el-button>
  </div>
</template>
<script>
export default {
  data() {
    return {

      wechatQRCode: require('./img/wechat.jpg') // 确保路径正确
    };
  },
  methods: {
    back() {
      this.$router.go(-1); // 返回上一个页面
    }
  }
};
</script>


<style scoped>
#alipay-page {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  text-align: center;
  background-color: #f8f8f8; /* 页面背景色 */
  padding: 20px; /* 页面内边距 */
  font-family: Arial, sans-serif; /* 字体样式 */
}

h2 {
  font-size: 28px; /* 标题字体大小 */
  color: #333; /* 字体颜色 */
  margin-bottom: 10px;
}

.qr-section {
  margin: 20px 0;
}

.qr-code {
  width: 300px; /* 可以根据需要调整 */
  height: auto; /* 让高度自动，保持纵横比 */
  max-width: 100%; /* 确保在小屏幕上显示正常 */
}

.cancel-button {
  margin-top: 20px; /* 按钮上边距 */
  background-color: white; /* 背景色 */
  color: black; /* 字体颜色 */
  border: 1px solid #000; /* 边框颜色 */
}

.cancel-button:hover {
  background-color: black; /* 悬停时的背景色 */
  color: white; /* 悬停时的字体颜色 */
}
</style>
