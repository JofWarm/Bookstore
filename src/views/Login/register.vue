<script>
export default {
  data() {
    return {
      ruleForm: {
        user: '',
        pass: '',
        checkPass: ''
      },
      rules: {
        user: [{ require: true, message:'请输入用户名', trigger:'blur' }],
        pass: [{ require: true, message:'请输入密码', trigger: 'blur' }],
        checkPass: [{ require: true, message:'请确认密码', trigger: 'blur' }]
      }
    }
  },
  methods: {
    returnForm() {
      // 返回login界面
      this.$router.push('/login')
    }
  }
}
</script>

<template>
  <div class="box">
    <div class="zhuce">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="账号名称" prop="user">
          <el-input v-model="ruleForm.user" clearable></el-input>
        </el-form-item>
        <el-form-item label="账号密码" prop="pass">
          <el-input type="password" v-model="ruleForm.pass" clearable></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPass">
          <el-input type="password" v-model="ruleForm.checkPass" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" >注册</el-button>
          <el-button @click="returnForm">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.box {
  height: 100%;
  background-color: #2e4e6e;
}
.zhuce {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 450px;
  height: 450px;
  background-color: #fff;
  border-radius: 3px;
}
.el-form-item {
  margin-top: 30px;
  width: 400px;
}

</style>