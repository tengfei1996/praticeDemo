import axios from 'axios'
import Router from '../router'



class HttpRequest {
  constructor(baseUrl = baseURL) {
    this.baseUrl = baseUrl
    this.queue = {}
  }

  getInsideConfig() {
    const config = {
      baseURL: this.baseUrl,
      headers: {
        //
      }
    }
    return config
  }

  destroy(url) {
    delete this.queue[url]
    if (!Object.keys(this.queue).length) {
      // Spin.hide()
    }
  }

  interceptors(instance, url) {
    instance.defaults.headers.post['Content-Type'] =
      'application/x-www-form-urlencoded;charset=UTF-8' // 配置请求头

    // 响应拦截
    instance.interceptors.response.use(
      res => {
        this.destroy(url)
        // code返回码判断
        if (res.data.code === 403 || res.data.code === 401) {
          setTimeout(() => {
            Router.push({
              name: 'login'
            })
          }, 500)
        }
        return res.data
      },
      error => {
        this.destroy(url)
        let errorInfo = error.response
        if (!errorInfo) {
          const {
            request: { statusText, status },
            config
          } = JSON.parse(JSON.stringify(error))
          errorInfo = {
            statusText,
            status,
            request: { responseURL: config.url }
          }
        }
        return Promise.reject(error)
      }
    )
  }

  request(options) {
    const instance = axios.create()
    options = Object.assign(this.getInsideConfig(), options)
    this.interceptors(instance, options.url)
    return instance(options)
  }
}

export default HttpRequest
