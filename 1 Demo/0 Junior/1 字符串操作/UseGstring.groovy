package org.test

class UseGstring {

  static main(def args) {
    
    gstring���÷�(����ת��Ҳ��)
    def str1=�������
    def str2=Groovy
    println $str1$str2
    println '$str2'
    
    
    �ַ�����������
    def str3=�Ϻ����ֶ����������ͨ2����
    def str4=hello world
    def str5=��,��
    ��ȡ�ַ���
    println str3.substring(0,7)
    ��Сдת��
    println str4.toUpperCase()
    ����ַ���
    def split=str5.split(",")
    for(item in split){
      println item
    }
    �ַ����滻
    println str4.replaceAll(world, Tom)
    �ַ���תΪ����
    def str6=28
    def str7=2
    println str6.toInteger()+str7.toInteger()
    �ַ����ļ���
    def str8=abcd
    println str8-c
    contains��ʹ��
    println str8.contains(c)
  }

}