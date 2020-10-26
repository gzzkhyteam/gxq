package com.hengyunsoft.base.id;

public class CodeGenerate implements IdGenerate<String> {

	private SnowflakeIDGenerate snowflakeIDGenerate;
	private char[] codes ;
	private int codeNum;
	private int count;

	public CodeGenerate(final long machineCode,char[] codes) {
		
		snowflakeIDGenerate = new SnowflakeIDGenerate(machineCode);
		this.codes = codes;
		this.codeNum = this.codes.length;
		int count = 1;
		for (long l=Long.MAX_VALUE; l != 0; count++) {
			l = l/this.codeNum;
		}
		this.count = count;
	}

	@Override
	public String generate() {
		
		
		long id = snowflakeIDGenerate.generate();
		StringBuilder result = new StringBuilder(this.count);
		for (int i = 0; i < this.count; i++) {
			result.append(this.codes[(int) (id%this.codeNum)]);
			id = id/this.codeNum;
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		
		int bitNum = 26;
		char[] codes = new char[90];
		
		for (char i = 65,j=0; i < 91; i++,j++) {
			codes[j] = i;
		}
		for (char j=26,i=50; j < bitNum; j++) {
			codes[j] = i++;
		}
		
		CodeGenerate c = new CodeGenerate(1, codes);
		for (int i = 0; i < 10; i++) {

			System.out.println(c.generate());
		}
		System.out.println(Long.MAX_VALUE);
	}

}
