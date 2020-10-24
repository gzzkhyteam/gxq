package com.hengyunsoft.test;

import com.hengyunsoft.platform.controller.sso.AppInfoEncoder;

public class AppKeyGenerator {

	public static void main(String[] args) {

		String text = AppInfoEncoder.encoder("55kj6310","form55kj6310");
		System.out.println(text);
		 text = AppInfoEncoder.encoder("55kj6311","folw55kj6311");
		System.out.println(text);

        String[] aaa = AppInfoEncoder.uncoder("XlNYtFxQxkbzJtrv8uXlVfhDnOR96truxcJdvzdrzedXlv03OiAB7");
        System.out.println(aaa);

    }
}
