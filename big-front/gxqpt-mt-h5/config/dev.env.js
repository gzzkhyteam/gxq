'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  API_ROOT: '"http://127.0.0.1:10086/api"'//(日志)
  // API_ROOT: '"http://127.0.0.1:10086/api"'
  // API_ROOT:'"http://192.168.1.23:10003/api"'
})
