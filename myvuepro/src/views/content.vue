<template>
  <div>
    <Table
      height="600"
      :columns="columnsData"
      :data="tableRowData">
    </Table>
    <Page
      @on-change="pageChange"
      :total="total"
      show-total
      size="small"
    />
  </div>
</template>

<script>
import tableContent from '@/api/userlogin.js'
export default {
  data () {
    return {
      tableContent,
      total: 0,
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
      ],
      searchData: {
        page: 1,
        size: 10,
        orderType: 'desc',
        orderParam: '',
        queryParam: {},
      },
    }
  },
  mounted () {  //钩子函数
    this.$nextTick(() => {//整体渲染结束nextTick()
      this.TableContentData()
    })
  },
  methods: {
    TableContentData () {
      console.log("TableContentData")
      tableContent.getTableData(this.searchData).then((res) => {
        if (res.success) {
          this.tableRowData = res.data.list,
          this.total = res.data.total
        } else {
          this.$Message.error(res.message)
        }
      })
    },
    pageChange (page) {
      console.log("pageChange")
      this.searchData.page= page,
      this.TableContentData()
    }
  }
}
</script>
