<template>
  <div class="layout">
    <Layout>
      <Header>
        <Menu mode="horizontal" theme="dark" active-name="1">
          <div class="layout-logo"></div>
          <div class="layout-nav">
            <MenuItem name="1">
              <Icon type="ios-navigate"></Icon>
              Item 1
            </MenuItem>
            <MenuItem name="2">
              <Icon type="ios-keypad"></Icon>
              Item 2
            </MenuItem>
            <MenuItem name="3">
              <Icon type="ios-analytics"></Icon>
              Item 3
            </MenuItem>
            <MenuItem name="4">
              <Icon type="ios-paper"></Icon>
              Item 4
            </MenuItem>
          </div>
        </Menu>
      </Header>
      <Layout :style="{padding: '0 50px'}">
        <Breadcrumb :style="{margin: '16px 0'}">
          <BreadcrumbItem to="/login">Home</BreadcrumbItem>
          <BreadcrumbItem>Components</BreadcrumbItem>
          <BreadcrumbItem>Layout</BreadcrumbItem>
        </Breadcrumb>
        <Content :style="{padding: '24px 0', minHeight: '480px', background: '#fff'}">
          <Layout>
            <Sider hide-trigger :style="{background: '#fff'}">
              <Menu active-name="1-2" theme="light" width="auto" :open-names="['1']">
                <Submenu name="1">
                  <template slot="title">
                    <Icon type="ios-navigate"></Icon>
                    Item 1
                  </template>
                  <MenuItem name="1-1">Option 1</MenuItem>
                  <MenuItem name="1-2">Option 2</MenuItem>
                  <MenuItem name="1-3">Option 3</MenuItem>
                </Submenu>
                <Submenu name="2">
                  <template slot="title">
                    <Icon type="ios-keypad"></Icon>
                    Item 2
                  </template>
                  <MenuItem name="2-1">Option 1</MenuItem>
                  <MenuItem name="2-2">Option 2</MenuItem>
                </Submenu>
                <Submenu name="3">
                  <template slot="title">
                    <Icon type="ios-analytics"></Icon>
                    Item 3
                  </template>
                  <MenuItem name="3-1">Option 1</MenuItem>
                  <MenuItem name="3-2">Option 2</MenuItem>
                </Submenu>
                <Submenu name="4">
                  <template slot="title">
                    <Icon type="ios-paper"></Icon>
                    Item 4
                  </template>
                  <MenuItem name="4-1">Option 1</MenuItem>
                  <MenuItem name="4-2">Option 2</MenuItem>
                </Submenu>
              </Menu>
            </Sider>
            <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
              <!--Content-->
              <div>
                <Table
                  :height="hight"
                  :columns="columnsData"
                  :data="tableRowData">
                </Table>
                <Page
                  @on-change="pageChange"
                  :total="total"
                  show-total
                  size="small"
                  show-sizer
                  :page-size="pageSize"
                  @on-page-size-change="pageSizeChange"
                />
              </div>
            </Content>
          </Layout>
        </Content>
      </Layout>
      <Footer class="layout-footer-center">2011-2016 &copy; TalkingData</Footer>
    </Layout>
  </div>
</template>
<script>
  import tableContent from '@/api/userlogin.js'
  export default {
    data () {
      return {
        tableContent,
        total: 0,
        hight: 400,
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
          size: 20,
          orderType: 'desc',
          orderParam: '',
          queryParam: {},
        },
      }
    },
    props: {
      data: { // 传入的数据
        type: Array,
        default () {
          return []
        }
      },
      orderParam: String,
      size: String,
      pageSize: {
        type: Number,
        default () {
          return 20
        }
      },
      condition: { // 查询条件
        type: Object,
        default () {
          return {}
        }
      },
    },
    mounted () {  //钩子函数
      this.$nextTick(() => {//整体渲染结束nextTick()
        this.TableContentData()
      })
    },
    methods: {
      TableContentData () {
        console.log("TableContentData")
        this.searchData.queryParam = this.condition
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
      },
      pageSizeChange (pageSize) {
        console.log("pageSizeChange")
        this.searchData.size = pageSize,
          this.TableContentData()
      },
    }
  }
</script>
<style scoped>
  .layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
  .layout-logo{
    width: 100px;
    height: 30px;
    background: #5b6270;
    border-radius: 3px;
    float: left;
    position: relative;
    top: 15px;
    left: 20px;
  }
  .layout-nav{
    width: 420px;
    margin: 0 auto;
    margin-right: 20px;
  }
  .layout-footer-center{
    text-align: center;
  }
</style>
