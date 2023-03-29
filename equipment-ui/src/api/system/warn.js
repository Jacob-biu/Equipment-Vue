import request from '@/utils/request'

// 查询报警信息列表
export function listWarn(query) {
  return request({
    url: '/system/warn/list',
    method: 'get',
    params: query
  })
}

// 查询报警信息列表
export function statistics() {
  return request({
    url: '/system/warn/statistics',
    method: 'get'
  })
}

// 查询报警信息详细
export function getWarn(id) {
  return request({
    url: '/system/warn/' + id,
    method: 'get'
  })
}

// 新增报警信息
export function addWarn(data) {
  return request({
    url: '/system/warn',
    method: 'post',
    data: data
  })
}

// 修改报警信息
export function updateWarn(data) {
  return request({
    url: '/system/warn',
    method: 'put',
    data: data
  })
}

// 删除报警信息
export function delWarn(id) {
  return request({
    url: '/system/warn/' + id,
    method: 'delete'
  })
}
