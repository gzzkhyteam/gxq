package com.hengyunsoft.platform.commons.sec;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.bouncycastle.util.Arrays;

/**
 * 编码与解码都提供了两个方法：<br/>
 * 1、对于字符串 {@link #encoding(String)} 编码，其对应的解码是 {@link #unencoding(String)}<br/>
 * 2、对于字节数组 {@link #encoding(byte[])} 编码，其对应的解码是 {@link #unencoding(byte[])}<br/>
 * <strong>注意：</strong>不管是使用哪一种编码方式，对于相同的输入，每次调用的结果基本会不一样。但是不用担心，因为解码后的结果都是相同的。<br/>
 * 
 * <br/>算法实现流程：<br/>
 * <ul>
 *      <li>编码：<p>
 *                  1、实列化一个数据结构，用于存储编码结果。<br/>
 *                  2、随机生成一个起始位数字startIndex（64~127）可见字符区域，根据这个值计算步长。<br/>
                    3、开始编码输入字节数组。每一个字节对应两个编码后的字节。<br/>
                    　　　3.1、通过输入索引index，计算移动位，得到结果为firstJM。返回值在0（包含）到127（包含）之间<br/>
                    　　　3.2、更具127-firstJM得到secondJM。<br/>
                    　　　3.3、编码后的字节是两个对应源码的一个。所以将源码的一个字节拆分成两个字节进行分开存储，<br/>
                             第一个字节存储firstJM在位上为1的部分数据，而第二个字节存储secondJM在位上为1的部分数据。<br/>
                             由于编码后希望所有的字节都是非负数，所以我将所有源码的第八字节全部存储在第一分量的第一个位上面。<br/>
                    4、当上述编码完成后，我的所有（输入数组长度*2）部分的数据都是介于0~127的，保证了符号位一定是0；但是由于
                       0~127之间有些ASCII码是不可见字符（特殊字符），不利于字符串的存储。所以需要将（输入数组长度*2）的所
                         有数据都转换到可见字符区域。故出现了第二部分数据（输入数组长度*2/6+1），把第一部分的数据中的所有字节的
                         第七位存储在这部分数据中。让后将其第七位设置为1，这样第一部分的数据的值范围在：[64,127]。同样我也需要
                         将这第二部分的数据保证的可见字符区域中，故我固定这部分数据的第七位为1，所有这部分数据的可使用位就剩下6位了。<br/>
                    5、编码的第三部分，也就是一个字节，用于存储第二部生成的起始位数字，解码时候需要使用.<br/>
                    6、因为127也是一个特殊字符，依然不利于存储，故我需要去去除这个字节。上面我的所有字节中，第七位都是1，所以我只要使用一个
                         可见字符，且第七位不是1的字节去替换就可以了。这里我使用了 ！（33） 这个可见字符。
                </p></li>
 *      <li>解码：1、将需要解码的字节数组中的所有特殊字符（33）换成（127）。与编码第6步相对应，执行相反的过程</li>
 * <ul>
 * 
 * <br/>编码后的存储容量：输入数组长度*2 + 输入数组长度*2/6+2 ,您可以简单的看成是：（2.2倍的输入字节长度+2）<br/>
 * 数据结构解释<br/>
 * <br/>1、输入数组长度*2　　　　　　<p>输入数组中，我使用一个字节用两个字节来存储</p>
 * <br/>2、输入数组长度*2/6+1　<p>为了让字节数组中的值在可见ASCII码范围内部，我让所有的字节中的第七位为1。为了实现透明的存储，
 *                      把第一部分的数据中的所有字节的第七位存储在这部分数据中了。当然了，我也要保证这部分的数据在第七位
 *                      也是1、所以这部分可用于存储的位数将会是6位。而我们知道，整数除法是向下取整的。所以我这里+1</p>
 * <br/>3、最后一位 　　　　　　　　　<p>最后一位用于保存bitIndex()的起始值，并且由这个起始值可以计算出步长。</p>
 * <br/>破解难度是较难的，至少我破解不了。
 */
public class BitEncrypt {

//    private final static byte replace127 = 33;
//    private final static byte byteMax = 127;
//    
//    //因为 \在很多程序中都是特殊字符    转意字符。故要屏蔽掉这个字符   使用  +  字符
//    private final static byte replace92 = 57;
//    private final static byte special92 = 92;
    
	
  //因为 \在很多程序中都是特殊字符    转意字符。故要屏蔽掉这个字符   使用  +  字符

    /**
     * 特殊字符对应替换字符
     */
    private final static Map<Byte,Byte>  specialByteReplaceByteMapping ;
    /**
     * 替换字符对应特殊字符
     */
    private final static Map<Byte,Byte>  replaceByteSpecialByteMapping ;
    
    static {
    	specialByteReplaceByteMapping = new HashMap<>();
    	replaceByteSpecialByteMapping = new HashMap<>();
    	byte[] byReplaceByte =   {64,91,92,93,94,126,96,123,124,125,127};
    	byte[]  replaceByte = {'0','1','2','3','4','5','6','7','8','9','.'};
    	for (int i = 0; i < byReplaceByte.length; i++) {
    		specialByteReplaceByteMapping.put(byReplaceByte[i], replaceByte[i]);
    		replaceByteSpecialByteMapping.put( replaceByte[i], byReplaceByte[i]);
		}
    }
    
//    private final static byte firstTemplate = 0X2B; 
//    private final static byte secondTemplate = 0X6C; 
    public static String encoding(String str){
        
        if(str == null || str.length() == 0)
            return str;
        byte[] encoding;
		try {
			encoding = encoding(str.getBytes("UTF-8"));
			return new String(encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("加密时通过UTF-8获取字节数组出错，这是不可能发生的事情。");
			throw new RuntimeException(e);
		}
    }
    
    public static String unencoding(String str){
        
        if(str == null || str.length() == 0)
            return str;
        byte[] encoding = unencoding(str.getBytes());
        return new String(encoding,Charset.forName("UTF-8"));
    }
    
    public static byte[] encoding(byte[] i) {
        
        //第一部分数据长度
        final int len = i.length * 2;
        // len/6+ 1 第二部分数据长度
        // + 1 第三部分数据长度
        byte[] result = new byte[len + len/6+ 1 + 1];
        
        
      final byte startIndex = (byte) (random.nextInt(63)+64);
        
        byte stepIndex = getStep(startIndex);
        result[result.length-1] = startIndex;
        for (int j = 0,s=startIndex; j < i.length; j++,s=(s+stepIndex)&127) {
            byte[] bb = jm(i[j],s);
            for (int k = 0; k < bb.length; k++) {
                result[k + j * 2] = bb[k];
            }
        }
        byte sevenBit = 0;
        result[len] = 0X40;
        result[result.length-2] = 0X40;
        for (int j = 0,k=0,step=0; j < len; j++,k++) {
            sevenBit = (byte) (result[j] >>> 6);
            result[j] = (byte) (result[j] | 0X40);
            if(k == 6){
                step++;
                k = 0;
                result[len+step] = 0X40;
            } 
            result[len+step] = (byte) (result[len+step] | sevenBit << k);
        }
        
//        replace127(result);
        replaceSpecialByte(result);
        return result;
    }

    /**
     * 替换特殊字符
     * @param result
     */
    private static void replaceSpecialByte(byte[] result) {

    	for (int i = 0,len = result.length; i < len; i++) {
    		Byte replaceByte = specialByteReplaceByteMapping.get(result[i]);
    		if(replaceByte != null) {
    			result[i] = replaceByte;
    		}
        }
	}


    /**
     * 还原特殊字符
     * @param result
     */
    private static void unReplaceSpecialByte(byte[] result) {
        

        for (int i = 0,len = result.length; i < len; i++) {
        	
    		Byte specialByte = replaceByteSpecialByteMapping.get(result[i]);
    		if(specialByte != null) {
    			result[i] = specialByte;
    		}
        }
    }
    
    

    /**
     * 就是将b的位通过打撒，分别存储在不同的数据当中，而且由于一个
     * 数据被分配到几个数据中去存储，所以需要位填充，这些位填充我使用随机数
     * 。所以每次加密结果都会不一样的。
     * @param b
     * @return
     */
    private static byte[] jm(byte b,int index) {

        
        byte[] result = new byte[2];
        //除去firstJM指定的位以外：其余的位由随机数生成
        //将部分数据隐藏在第一分量中去
        final byte firstJM = (byte) (bitIndex(index) & 126);
        final byte secondJM = (byte) (127-firstJM);
        
      result[0] = (byte) ((firstJM & b) | (random.nextInt(128) & secondJM));
        
        
        //符号位不存储   保证是非负数   将b的符号位保存在firstJM的第一位上面
        result[0] = (byte) (result[0] & 126);
        if(b < 0){
            result[0] += 1; 
        }
        //除去secondJM指定的位以外：其余的位由随机数生成
        //将部分数据隐藏在第二分量中去
        
      result[1] = (byte) ((secondJM & b) | (random.nextInt(128) & firstJM));
        return result;
    }

    final static Random random = new Random();
    final static byte[] template = {1,2,4,8,16,32,64};
    public static byte[] unencoding(byte[] ii) {

    	unReplaceSpecialByte(ii);
        int len = (int) Math.ceil(6*(ii.length-2.0)/14);
        
        byte[] result = new byte[len];
        
        int len1 = len*2;
        byte sevenBit = 0;
        for (int j = 0,k=0,h=len1; j < len1; j++,k++) {
            sevenBit = (byte) (ii[h] & template[k]);
            if(sevenBit != 0){
                ii[j] = (byte) (ii[j] | 0X40);
            } else {
                ii[j] = (byte) (ii[j] & 0XBF);
            }
            if(k == 5){
                h++;
                k = -1;
            } 
        }

        final byte startIndex = ii[ii.length-1];
        final byte stepIndex = getStep(startIndex);
        for (int i = 0,k=0,s=startIndex; i < result.length; i++,k++,s=(s+stepIndex)&127) {
            final byte  firstJM = (byte) (bitIndex(s) & 126);
            final byte  secondJM = (byte) (127-firstJM);
            //取出在第一分量中隐藏的数据
            result[i] = (byte) (ii[k] & firstJM);
            //因为符号位保存在第一个分量的第一个字节中   所以这里把第一位取出放到result[i]中去
            result[i] = (byte) (result[i] | (ii[k] << 7));
            ++k;
            //取出在第二个分量中的隐藏数据
            result[i] = (byte) (result[i] | (ii[k] & secondJM));
        }
        return result;
    }

    private static byte getStep(final byte startIndex) {
        byte stepIndex = 1;
        for (byte b=0;b<7;b++) {
            if((startIndex >>> b & 1) == 1)
                stepIndex++;
        }
        return stepIndex;
    }

    
    /**
     * 计算位数   这个方程越复杂   越好！让这个方程不能能够经过简单计算求出是最好的了。
     * 
     * @param i 不限制   不是null就行
     * @return 返回值在0（包含）到127（包含）之间
     */
    public static byte bitIndex(int i){
        int x = ((i<<7) + (i<<6) + (i<<2) + (i<<1) + i) & 127 ;
        return (byte) (x );
    } 
}
