<template>
  <div>
    <el-form label-width="120px">
      <el-form-item label="收款人姓名">
        <el-input v-model="name" placeholder="请输入收款人姓名"></el-input>
      </el-form-item>

      <el-form-item label="收款人账号">
        <el-input v-model="account" placeholder="请输入收款人账号"></el-input>
      </el-form-item>

      <el-form-item label="支付方式">
        <el-radio-group v-model="type" class="payment-options">
          <el-radio label="alipay">
            <img src="./img/alipay.png" class="payment-icon" alt="支付宝" />
            支付宝
          </el-radio>
          <el-radio label="wechat">
            <img src="./img/wechatpay.png" class="payment-icon" alt="微信支付" />
            微信支付
          </el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitTap">确认支付</el-button>
        <el-button @click="back">取消返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: "",
      account: "",
      type: "",
      table: "",
      obj: ""
    };
  },
  mounted() {
    let table = this.$storage.get("paytable");
    let obj = this.$storage.getObj("payObject");
    this.table = table;
    this.obj = obj;
  },
  methods: {
    submitTap() {
      if (!this.type) {
        this.$message.error("请选择支付方式");
        return;
      }

      // 根据不同的支付方式跳转到不同的支付页面
      switch (this.type) {
        case "alipay":
          this.$router.push("/pay/alipay");
          break;
        case "wechat":
          this.$router.push("/pay/wechat");
          break;
      }
    },
    back() {
      this.$router.go(-1);
    }
  }
};
</script>

<style scoped>
.payment-options {
  display: flex;
  align-items: center;
}

.payment-icon {
  width: 24px;
  height: 24px;
  margin-right: 8px;
}

.payment-options el-radio {
  display: flex;
  align-items: center;
  margin-right: 20px;
}
</style>