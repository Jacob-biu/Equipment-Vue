<template>
  <div>
    <div style="display: flex ;margin-top: 50px">
      <div id="head" style="width: 600px;height:400px;"></div>
      <div id="main" style="width: 600px;height:400px;"></div>
    </div>

  </div>
</template>

<script>
import * as echarts from 'echarts'
import {listData} from "@/api/system/dict/data";
import {statistics} from "@/api/system/warn";
import router from '@/router'
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.5",
      chartColumn: null,
      option: {
        tooltip:{
          trigger: 'item'
        },

        title: {
          text: '近一周告警统计'
        },
        legend: {
          orient: 'vertical',
          bottom: 10,
          data: ['告警类型']
        },
        xAxis: {
          data: ['网关', '链路', '服务器', '网络']
        },
        yAxis: {},
        series: [
          {
            name: 'pie',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20],
            color: [
              '#f6ed3f'
            ]
          }

        ]
      },
      option1: {
        tooltip:{
          trigger: 'item'
        },

        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            type: 'pie',
            data: [
              {
                value: 2,
                name: '危险',
                itemStyle: {
                  color: '#ff0216'
                }
              },
              {
                value: 234,
                name: '正常',
                itemStyle: {
                  color: '#5cae4b'
                }
              },
              {
                value: 50,
                name: '警告',
                itemStyle: {
                  color: '#fff200'
                }
              }
            ]
          }
        ]
      }
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },

    initChart: function () {
      var myChart1 = echarts.init(document.getElementById('head'));
      myChart1.setOption(this.option1)
      myChart1.on('click', function(params) {
        // 控制台打印数据的名称
        console.log(params.name);
        router.push({path:"/equiment"})
      });
      var myChart = echarts.init(document.getElementById('main'));
      myChart.setOption(this.option)
    },
    getDist(){
      statistics().then(response => {
        console.log(response.data)
        if (response.data){
          this.option.xAxis.data=[];
          this.option.series[0].data=[];
          response.data.forEach(x=>{
            this.option.xAxis.data.push(x.typeName)
            this.option.series[0].data.push(x.count)
          })
        }
        this.initChart();
      });
    }
  },
  mounted: function() {
    this.getDist();

  }
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

