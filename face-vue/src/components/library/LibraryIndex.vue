<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <SideMenu @indexSelect="listByCategory" ref="sideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <students class="students-area" ref="studentsArea"></students>
    </el-main>
  </el-container>
</template>

<script>
import SideMenu from './SideMenu'
import Students from './Students'
export default {
  name: 'AppLibrary',
  components: {Students, SideMenu},
  methods: {
    listByCategory () {
      var _this = this
      var cid = this.$refs.sideMenu.cid
      var url = 'categories/' + cid + '/students'
      this.$axios.get(url).then(resp => {
        if (resp && resp.status === 200) {
          _this.$refs.studentsArea.students = resp.data
        }
      })
    }
  }
}
</script>

<style scoped>
  .students-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
