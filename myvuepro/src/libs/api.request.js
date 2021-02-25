import HttpRequest from '@/libs/axios'
const baseUrl = 'http://localhost:8088'

const axios = new HttpRequest(baseUrl)

export default axios
