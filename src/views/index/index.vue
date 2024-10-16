<script >
/* 获取username */
export default {
  data() {
    return {
      username: '',
      activeName: 'index',
    };
  },
  mounted() {
    // 获取路由传递过来的 username 并赋值
    this.username = this.$route.query.username || '游客';
  },
  methods: {
    changePage(page) {
      if (page === 'exit') {
        // 处理退出登录的逻辑
        this.$router.push('/login');
        console.log('退出登录');
      } else {
        this.currentPage = page;
        console.log(`切换到 ${page} 页面`);
      }
    },

    handleClick(tab) {
      // 可选的处理逻辑
      console.log('当前激活的标签:', tab.name);
      console.log('当前 activeName 的值:', this.activeName); // activeName 当前值
      this.activeName = tab.name;
    },

    goToOrderPage(bookTitle) {
      // 跳转到订单页面，携带书名作为参数
      this.$router.push({ name: 'OrderPage', query: { title: bookTitle } });
    },

  },

};

</script>

<template>
  <div id="index">
    <el-container>
      <el-header style="height: 35px;">
        <ul>
          <li>
            <div class="userImg">
              <el-avatar icon="el-icon-s-custom"></el-avatar>
              <!-- 把用户名传递过来 -->
              欢迎 {{ username }}
            </div>
          </li>
          <li @click='changePage("index")'>商城首页</li>
          <li @click='changePage("PerCenter")'>个人中心</li>
          <li @click='changePage("exit")'>退出登录</li>
        </ul>
      </el-header>

      <el-main>
        <div>
          <p>
            <input type="search" name="" id="" value="" placeholder="请输入搜索内容" />
            <el-button type="primary" icon="el-icon-search">搜索</el-button>
          </p>
        </div>
        <div>
          <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="每日推荐" name="first">
              <div class="book-container">

                <div class="book-row">
                  <!-- 第一部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/time.png" alt="书籍封面1" class="book-cover">
                    <h3>书名: 《时间的秩序》</h3>
                    <p>作者: 卡尔·萨根</p>
                    <p>价格: ¥65.00</p>
                    <p>简介: 本书从科学的角度探讨时间的本质，讲述时间如何影响我们的生活与宇宙，是一部思维启发的作品...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('时间的秩序')" >购买</el-button> <!-- 添加购买按钮 -->
                    </div>
                  </el-card>

                  <!-- 第二部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/renleijianshi.png" alt="书籍封面2" class="book-cover">
                    <h3>书名: 《人类简史》</h3>
                    <p>作者: 尤瓦尔·赫拉利</p>
                    <p>价格: ¥70.00</p>
                    <p>简介: 这本书通过跨越几千年的历史，阐述了人类的发展与变迁，揭示了文明背后的复杂性与未来的可能性...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('人类简史')">购买</el-button> <!-- 添加购买按钮 -->
                    </div>
                  </el-card>

                  <!-- 第三部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/jieyou.png" alt="书籍封面3" class="book-cover">
                    <h3>书名: 《解忧杂货店》</h3>
                    <p>作者: 东野圭吾</p>
                    <p>价格: ¥55.00</p>
                    <p>简介: 本书讲述了一家能解忧的杂货店，通过信件的方式解决人们的烦恼，故事温暖而感人，充满人性光辉...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('解忧杂货店')">购买</el-button> <!-- 添加购买按钮 -->
                    </div>
                  </el-card>

                  <!-- 第四部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/weicheng.png" alt="书籍封面4" class="book-cover">
                    <h3>书名: 《围城》</h3>
                    <p>作者: 钱钟书</p>
                    <p>价格: ¥60.00</p>
                    <p>简介: 这是一部描绘知识分子婚姻与生活的经典小说，讽刺了社会的种种不合理现象，深入探讨了人性的复杂...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('围城')">购买</el-button> <!-- 添加购买按钮 -->
                    </div>
                  </el-card>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="历史名著" name="second">
              <div class="book-container">
                <div class="book-row">
                  <!-- 第一部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/xiyouji.png" alt="书籍封面1" class="book-cover">
                    <h3>书名: 《西游记》</h3>
                    <p>作者: 吴承恩</p>
                    <p>价格: ¥45.00</p>
                    <p>简介: 该书通过唐僧师徒四人西天取经的故事，反映了人性、友情、信仰等主题，情节引人入胜...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('西游记')">购买</el-button> <!-- 添加购买按钮 -->
                    </div>
                  </el-card>

                  <!-- 第二部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/1984.png" alt="书籍封面2" class="book-cover">
                    <h3>书名: 《1984》</h3>
                    <p>作者: 乔治·奥威尔</p>
                    <p>价格: ¥45.00</p>
                    <p>简介: 该书描绘了一个极权政府控制下的未来世界，探讨了自由与监控的主题，是反乌托邦文学的经典...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('1984')">购买</el-button> <!-- 添加购买按钮 -->
                    </div>
                  </el-card>

                  <!-- 第三部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/bainiangudu.png" alt="书籍封面3" class="book-cover">
                    <h3>书名: 《百年孤独》</h3>
                    <p>作者: 加西亚·马尔克斯</p>
                    <p>价格: ¥75.00</p>
                    <p>简介: 本书通过描绘布恩迪亚家族的兴衰历程，展现了拉丁美洲的魔幻现实主义，深刻影响了世界文学...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('百年孤独')">购买</el-button> <!-- 添加购买按钮 -->
                    </div>
                  </el-card>

                  <!-- 第四部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/sanguoyanyi.png" alt="书籍封面4" class="book-cover">
                    <h3>书名: 《三国演义》</h3>
                    <p>作者: 罗贯中</p>
                    <p>价格: ¥68.00</p>
                    <p>简介: 以东汉末年到三国时期为背景，描写了众多英雄人物的智谋与胆略，是中国古典小说中的巅峰之作...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('三国演义')">购买</el-button> <!-- 添加购买按钮 -->
                    </div>
                  </el-card>
                </div>
              </div>

            </el-tab-pane>
            <el-tab-pane label="流行小说" name="third">
              <div class="book-container">
                <div class="book-row">
                  <!-- 第一部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/time.png" alt="书籍封面1" class="book-cover">
                    <h3>书名: 《时间的秩序》</h3>
                    <p>作者: 卡尔·萨根</p>
                    <p>价格: ¥65.00</p>
                    <p>简介: 本书从科学的角度探讨时间的本质，讲述时间如何影响我们的生活与宇宙，是一部思维启发的作品...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('时间的秩序')">购买</el-button>
                    </div>
                  </el-card>

                  <!-- 第二部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/renleijianshi.png" alt="书籍封面2" class="book-cover">
                    <h3>书名: 《人类简史》</h3>
                    <p>作者: 尤瓦尔·赫拉利</p>
                    <p>价格: ¥70.00</p>
                    <p>简介: 这本书通过跨越几千年的历史，阐述了人类的发展与变迁，揭示了文明背后的复杂性与未来的可能性...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('人类简史')">购买</el-button>
                    </div>
                  </el-card>

                  <!-- 第三部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/jieyou.png" alt="书籍封面3" class="book-cover">
                    <h3>书名: 《解忧杂货店》</h3>
                    <p>作者: 东野圭吾</p>
                    <p>价格: ¥55.00</p>
                    <p>简介: 本书讲述了一家能解忧的杂货店，通过信件的方式解决人们的烦恼，故事温暖而感人，充满人性光辉...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('解忧杂货店')">购买</el-button>
                    </div>
                  </el-card>

                  <!-- 第四部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/xiaowangzi.png" alt="书籍封面4" class="book-cover">
                    <h3>书名: 《小王子》</h3>
                    <p>作者: 安东尼·德·圣埃克苏佩里</p>
                    <p>价格: ¥35.00</p>
                    <p>简介: 本书以简单的故事传达深刻的哲理，讲述了一位小王子在宇宙中的旅行与思考，适合各年龄层读者...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('小王子')">购买</el-button>
                    </div>
                  </el-card>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="网络小说" name="fourth">
              <div class="book-container">

                <div class="book-row">
                  <!-- 第一部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/quanzhigaoshou.png" alt="书籍封面1" class="book-cover">
                    <h3>书名: 《全职高手》</h3>
                    <p>作者: 蝴蝶蓝</p>
                    <p>价格: ¥55.00</p>
                    <p>简介: 讲述了职业战队的顶级选手叶修在退役后重返电竞界的故事，展现了电竞的魅力与热血...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('全职高手')">购买</el-button> <!-- 添加购买按钮 -->
                    </div>
                  </el-card>

                  <!-- 第二部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/zetian.png" alt="书籍封面2" class="book-cover">
                    <h3>书名: 《择天记》</h3>
                    <p>作者: 猫腻</p>
                    <p>价格: ¥48.00</p>
                    <p>简介: 故事围绕一个年轻人寻找自身命运与责任的旅程，结合了历史与幻想，情节跌宕起伏，令人向往...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('择天记')">购买</el-button> <!-- 添加购买按钮 -->
                    </div>
                  </el-card>

                  <!-- 第三部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/doupocangqiong.png" alt="书籍封面3" class="book-cover">
                    <h3>书名: 《斗破苍穹》</h3>
                    <p>作者: 天蚕土豆</p>
                    <p>价格: ¥60.00</p>
                    <p>简介: 讲述了少年萧炎通过努力不断成长，逆袭崛起的热血传奇故事，充满了友情与挑战...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('斗破苍穹')">购买</el-button> <!-- 添加购买按钮 -->
                    </div>
                  </el-card>

                  <!-- 第四部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/dazhuzai.png" alt="书籍封面4" class="book-cover">
                    <h3>书名: 《大主宰》</h3>
                    <p>作者: 天蚕土豆</p>
                    <p>价格: ¥58.00</p>
                    <p>简介: 本书讲述了一个少年在异界拼搏、成长与寻找真相的冒险故事，充满热血与感动，吸引了无数读者...</p>
                    <div class="card-footer">
                      <el-button type="primary" @click="goToOrderPage('大主宰')">购买</el-button> <!-- 添加购买按钮 -->
                    </div>
                  </el-card>
                </div>
              </div>
            </el-tab-pane>


          </el-tabs>

          <div class="background-image" v-show="activeName === 'index'">
            <div class="welcome-message">
              <h2>𝖂𝖊𝖑𝖈𝖔𝖒𝖊 𝕿𝖔 𝖂𝖆𝖗𝖒 𝕭𝖔𝖔𝖐𝖘𝖙𝖔𝖗𝖊</h2>
              <p>请选择一个标签以查看相关内容</p>
            </div>
          </div>

        </div>

      </el-main>
    </el-container>


  </div>
</template>

<style>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

.el-tabs {
  margin-bottom: 80px; /* 标签与内容之间的间距 */
}

#index {
  position: absolute;
  display: flex;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  /* background-color: #FF0000; */

}



.el-header>ul {
  position: absolute;
  right: 5px;
}

.el-header>ul>li {
  float: left;
  list-style: none;
  margin: 5px;
  user-select: none;
}

.el-header>ul>li:not(:first-child):hover {
  color: red;
  text-decoration: underline;
}


.userImg {
  display: flex;
  /* align-items: center; */
  vertical-align: middle;
}

input[type="search"] {
  width: 600px;
  height: 35px;
  font-size: 15px;
  outline: none;
  border: 2px solid #0000FF;
  border-radius: 5px;
}


el-container {
  height: 100vh; /* 确保容器占满全屏 */

}

.el-main>div {
  margin-top: 5px;
  /* background-image: url(../assets/7.png); */
}

.el-main>div:nth-of-type(2) {
  position: absolute;
  width: 88%;
  left: 50%;
  transform: translate(-50%, 0);
  /* background-color: #0000FF; */
  /* background-image: url(../assets/7.png); */
}

.book-container {
  padding: 20px;
  text-align: center;
}

.book-row {
  display: flex;
  flex-wrap: wrap; /* 如果屏幕宽度不足，书籍会自动换行 */
  justify-content: space-between; /* 水平排列的书籍之间有相同的间距 */
  gap: 20px; /* 书籍之间的间距 */
}

.book-card {
  width: 23%; /* 每本书占据容器的 23%，适合四本书水平排列 */
  padding: 15px;
  border-radius: 8px;
  box-sizing: border-box; /* 确保 padding 不影响宽度 */
  display: flex;
  flex-direction: column; /* 垂直排列内容 */
  justify-content: space-between; /* 在可用空间内分配间距 */

}
.card-footer {
  margin-top: auto; /* 将按钮推到底部 */
}

.book-cover {
  width: 100%;
  height: auto;
  border-radius: 4px;
  margin-bottom: 15px;
}

h3 {
  font-size: 18px;
  margin: 10px 0;
}

p {
  color: #666;
  font-size: 14px;
  margin-top: 10px;
}


.background-image {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 90vh;
  background: url(./pictures/welcome.jpg) no-repeat center center / cover;
  z-index: -1; /* 确保背景在后面 */
}

.welcome-message {
  display: flex;
  flex-direction: column; /* 让内容纵向排列 */
  align-items: center; /* 水平居中 */
  justify-content: center; /* 垂直居中 */
  position: relative;
  z-index: -1; /* 确保文字在前面 */
  height: 100%; /* 让欢迎信息的高度填满父容器 */
  color: black; /* 设置文字颜色为纯黑色 */
}

.el-main {
  height: 100vh; /* 确保填满容器 */
  position: relative; /* 确保背景图相对于这个容器定位 */
}

.el-button {
  background-color: white; /* 背景色 */
  color: black; /* 字体颜色 */
  border: 1px solid black; /* 边框颜色 */
  margin-top: auto;
}

.el-button:hover {
  background-color: black; /* 悬停时的背景色 */
  color: white; /* 悬停时的字体颜色 */
}


</style>