package com.hengyunsoft.security.logoutflag.impl;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.hengyunsoft.security.logoutflag.ILogoutFlagStorage;


public class ArraylistLogoutFlagStorage implements ILogoutFlagStorage {

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    
	private int[] flags = null;
	private int size = 0;
	private int flags_max_index = 0;
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	ReadLock readLock = lock.readLock() ;
	WriteLock writeLock = lock.writeLock();
	/////////////////////////////读多写少，所以读将大量占用我们的锁，导致写迟迟不能够操作，我这里借助外力/////////////////////////////////////
	private volatile AtomicInteger writeCount = new AtomicInteger(0);
	
	public ArraylistLogoutFlagStorage(int initialCapacity) {
        if (initialCapacity > 0) {
            this.flags = new int[initialCapacity];
        } else if (initialCapacity == 0) {
            this.flags = new int[16];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        }
        flags_max_index = this.flags.length-1;
    }
	
	@Override
	public  void addLogoutFlag(int logoutFlag) {

		//计算器追加
		writeCount.incrementAndGet();
		writeLock.lock();
		try {
			if(flags_max_index < size) {
				grow(size);
			} 
			
			put(logoutFlag);
		} finally {
			//计数器递减
			writeCount.decrementAndGet();
			writeLock.unlock();
			synchronized (writeCount) {
				writeCount.notifyAll();
			}
		}		
	}
	
    private void put(int logoutFlag) {

    	
    	int j = size-1;
    	for (; j > -1; j--) {
			if(flags[j] > logoutFlag) {
				flags[j+1] = flags[j];
			} else if(flags[j] == logoutFlag) {
				return ;
			} else {
				break;
			}
		}
    	flags[j+1] = logoutFlag;
    	size++;
	}

    /**
     * 扩容  参考ArrayList的grow方法
     * @param minCapacity
     */
	private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = flags.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        flags = Arrays.copyOf(flags, newCapacity);
        flags_max_index = this.flags.length-1;
    }
    
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }

	@Override
	public  boolean existLogutFlag(int logoutFlag) {
		if(size == 0) {
			return false;
		}
		if(writeCount.get() > 0) {
			//计数器
			synchronized (writeCount) {
				try {
					if(writeCount.get() > 0) {
						writeCount.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		readLock.lock();
		try {
			int[] templateFlags = this.flags;
			return Arrays.binarySearch(templateFlags, 0,size , logoutFlag) >= 0;
		} finally {
			readLock.unlock();
		}
	}

	public static void main(String[] args) {
		
		ArraylistLogoutFlagStorage s = new ArraylistLogoutFlagStorage(5);
		for (int i = 1; i < 100000; i++) {
			s.addLogoutFlag(i);
		}
		System.out.println(Arrays.toString(s.flags));
		System.out.println(s.existLogutFlag(9989));
	}
}
