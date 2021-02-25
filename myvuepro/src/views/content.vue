<template>
  <Table height="1000" :columns="columnsData" :data="tableRowData"></Table>
</template>

<script>
import tableContent from '@/api/userlogin.js'
export default {
  data () {
    return {
      tableContent,
      columnsData: [
        {
          title: 'ID',
          key: 'id'
        },
        {
          title: 'userName',
          key: 'userName'
        },
        {
          title: 'createDate',
          key: 'createDate'
        },
        {
          title: 'relationId',
          key: 'relationId'
        },
        {
          title: 'modifyDate',
          key: 'modifyDate'
        },
        {
          title: 'note',
          key: 'note'
        },
        {
          title: 'version',
          key: 'version'
        }
      ],
      tableRowData: [
        {
          id: '',
          userName: '',
          createDate: '',
          relationId: '',
          modifyDate: '',
          note: '',
          version: ''
        }
      ]
    }
  },
  mounted () {  //钩子函数
    this.$nextTick(() => {//整体渲染结束nextTick()
      this.TableContentData()
    })
  },
  methods: {
    TableContentData () {
      console.log("1234")
      tableContent.getTableData().then((res) => {
        if (res.success) {
          debugger
          this.tableRowData = res.data
        } else {
          this.$Message.error(res.message)
        }
      })
    }
  }
}
</script>