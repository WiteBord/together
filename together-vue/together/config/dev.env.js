'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  //nas后端
  //API_ROOT:'"192.168.195.16"'
  //本地后端
  API_ROOT:'"127.0.0.1"'
})
