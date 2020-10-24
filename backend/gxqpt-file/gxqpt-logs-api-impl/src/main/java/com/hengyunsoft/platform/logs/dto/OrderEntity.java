package com.hengyunsoft.platform.logs.dto;

public class OrderEntity implements Comparable<OrderEntity> {
    public Integer number = 0;
    public String name = "";
    public Integer getNumber() {
         return number;
    }
     public void setNumber(int number) {
         this.number = number;
     }

     public String getName() {
        return name;
     }
     public void setName(String name) {
         this.name = name;
     }

      public OrderEntity(int number,String name){
         this.number = number;
        this.name = name;
      }

      @Override
      public int compareTo(OrderEntity s) {
                 //自定义比较方法，如果认为此实体本身大则返回1，否则返回-1
         if(this.number > s.getNumber()){
                 return 1;
             }
         return -1;
     }
 }
