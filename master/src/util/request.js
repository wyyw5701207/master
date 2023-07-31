import axios from 'axios';
// import CryptoJS from 'crypto-js';  //加密算法库
// import JSEncrypt from 'jsencrypt';//对称加密（如 RSA 加密）的库
// import sm from 'sm-crypto';//国密算法（SM2/SM3/SM4）的加密和解密操作的库。

export default class Request {
  /**
   * 封装get请求
   *
   * @param {string} url - 请求的URL地址
   * @param {object} params - 请求参数
   * @returns {Promise<object>} - 返回Promise对象，包含请求结果
   */
  static async get(url, params) {
    if (params === undefined) {
      params = {};
    }
    let response = await axios.get(url, { params });
    return response.data;
  }

  /**
   * 封装post请求
   *
   * @param {string} url - 请求的URL地址
   * @param {object} data - 请求数据
   * @returns {Promise<object>} - 返回Promise对象，包含请求结果
   */
  static async post(url, params) {
    if (params === undefined) {
      params = {};
    }
    let response = await axios.post(url, { params });
    return response.data;
  }
}