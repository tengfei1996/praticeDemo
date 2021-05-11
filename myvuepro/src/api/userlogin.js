import axios from '@/libs/api.request'

export default{
  userLogin: (data)=>{
    return axios.request({
      url: '/systemUser/userLogin',
      method: 'post',
      data: data
    })
  },
  getTableData: (condition) => {
    return axios.request({
      url: '/odBusiNotelog/getTableData',
      method: 'post',
      data: condition
    })
  }
}
