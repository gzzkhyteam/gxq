package com.hengyunsoft.platform.modular.repository;
/**
 * 这里如果模块管理服务的模块比较多，就考虑根据功能或者模块分包。
 * 比较少，就统一在repository/dao、repository/service、repository/example
 * 下建包即可。
 *
 * 如： 功能比较多时：
 *  repository
 *      user
 *          dao
 *          service
 *          example
 *      role
 *          dao
 *          service
 *          example
 *
 *   功能比较少时：
 *      repository
 *          dao
 *          service
 *          example
 *
 */