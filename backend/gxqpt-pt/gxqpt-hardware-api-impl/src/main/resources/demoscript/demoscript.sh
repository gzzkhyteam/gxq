#!/bin/bash

network=`ifconfig | awk 'NR==1{print $1}'` ###获取监控网卡

while true
do 
    #####time#########
    sj=`date "+%Y-%m-%d %H:%M:%S"`
    warnTime1="${sj//:/%3A}"
    warnTime="${warnTime1// /%20}" ##时间   
 	
    ###########MEMOYR#########

    ###memNum/M###
    memNum=`free -m | awk 'NR==2{print $2}'`
    meuse=`free -m | awk 'NR==2{print $3}'`
    ###memUseRate###
    memUseRate=`echo "scale=2; $meuse/$memNum*100" | bc | awk '{printf "%.2f", $0}'`
    
    #############C-P-U###########
    freecpu=`top -n1 -b | head -3 | awk 'NR==3{print +$5}'`
    cpuUseRate=`echo "100.0 - $freecpu" | bc | awk '{printf "%.2f", $0}'`
	 
    ###########F-D-I-S-K###########

    ###diskNum/M###
    num=`df -m | awk 'END{print NR}'`
    diskNum=0
    j=1
    while [ $j -lt $num ]
    do 
        j=`expr $j + 1 `
        h=`df -m | awk 'NR=='$j'{print +$2}'`
        diskNum=`expr $diskNum + $h `   
    done
    

    ###### diskUseRate####
    #num=`df -m | awk 'END{print NR}'`
    s=0
    i=1
    while [ $i -lt $num ]
    do
        i=`expr $i + 1`
        c=`df -m | awk 'NR=='$i'{print +$5}'`
        s=`expr $s + $c`
    done
    nu=`expr $num - 1 `
    diskUseRate=`echo "scale=2; $s/$nu" | bc | awk '{printf "%.2f", $0}'`
     
    ##############liuliang##############
     
    # 获取当前时刻网口接收与发送的流量,需要手动修改网卡。
    RXpre=$(cat /proc/net/dev | grep ${network} | tr : " " | awk '{print $2}')
    TXpre=$(cat /proc/net/dev | grep ${network} | tr : " " | awk '{print $10}')
    # 获取1秒后网口接收与发送的流量,需要手动修改网卡。
    sleep 1
    RXnext=$(cat /proc/net/dev | grep ${network} | tr : " " | awk '{print $2}')
    TXnext=$(cat /proc/net/dev | grep ${network} | tr : " " | awk '{print $10}')
    clear
    # 获取这1秒钟实际的进出流量
    RX=$((RXnext-RXpre))
    TX=$((TXnext-TXpre))
     
    url="http://{config_ip}/api/hardware/serverstatistics/save?serverId={config_serverId}&time=$warnTime&cpu=$cpuUseRate&mem=$memUseRate&disk=$diskUseRate&wideUp=$RX&wideDown=$TX"
    wget $url
	rm -rf save*
    sleep 300

done

