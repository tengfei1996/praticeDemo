import axios from '@/libs/api.request'

export default{
  userLogin: (data)=>{
    return axios.request({
      url: '/systemUser/userLogin',
      method: 'post',
      data: data
    })
  },
  getTableData: () => {
    return axios.request({
      url: '/odBusiNotelog/getTableData',
      method: 'get'
    })
  }
}