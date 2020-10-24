#!/bin/bash
ps -ef | grep tyjkpt.sh | awk '{print $2}'| xargs kill -9 #先停之前运行的脚本

while true
do

    url1={config_fileurl} #fileurl为运维手动输入后替换的路径，如/usr/local/nginx，下同。
    if [ -d $url1 ];then
        url1_total=`du -m -s $url1 | sort | awk '{print $1}'` #读取文件目录大小

    else
	echo $url1"路径不存在！"
        url1_total=-1
    fi

    url2={config_logurl}
    if [ -d $url2 ];then
        url2_total=`du -m -s $url2 | sort | awk '{print $1}'`

    else
	echo $url2"路径不存在！"
        url2_total=-1
    fi

    url3={config_dburl}
    if [ -d $url3 ];then
        url3_total=`du -m -s $url3 | sort | awk '{print $1}'`
    else
	echo $url3"路径不存在！"
        url3_total=-1
    fi

    url="http://{config_ip}/api/supervise/storagesupervise/updateScript?dbSpaceNum=$url3_total&logSpaceNum=$url2_total&fileSpaceNum=$url1_total&id={config_id}"
    #echo $url
    wget $url
    rm -rf updateScript*
    sleep 300

done