import request from '@/utils/request'

// 查询设备列表
export function listEquiment(query) {
  return request({
    url: '/system/equiment/list',
    method: 'get',
    params: query
  })
}

// 查询设备详细
export function getEquiment(id) {
  return request({
    url: '/system/equiment/' + id,
    method: 'get'
  })
}

// 新增设备
export function addEquiment(data) {
  return request({
    url: '/system/equiment',
    method: 'post',
    data: data
  })
}

// 修改设备
export function updateEquiment(data) {
  return request({
    url: '/system/equiment',
    method: 'put',
    data: data
  })
}

// 删除设备
export function delEquiment(id) {
  return request({
    url: '/system/equiment/' + id,
    method: 'delete'
  })
}
