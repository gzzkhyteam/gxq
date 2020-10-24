package com.hengyunsoft.platform.mail.repository.service.mail.receive;

import javax.mail.Flags;

/**
 * 类说明：邮件标志类
 * 
 * @author 作者: LiuJunGuang
 * @version 创建时间：2011-7-24 下午04:56:49
 */
public enum Flag {
	/**
	 * 已回复
	 */
	ANSWERED {
		@Override
		public Flags getFlag() {
			return new Flags(Flags.Flag.ANSWERED);
		}
	},
	/**
	 * 是否删除
	 */
	DELETED {
		@Override
		public Flags getFlag() {
			return new Flags(Flags.Flag.DELETED);
		}
	},
	/**
	 * 草稿
	 */
	DRAFT {
		@Override
		public Flags getFlag() {
			return new Flags(Flags.Flag.DRAFT);
		}
	},
	/**
	 * 是否放入回收站
	 */
	FLAGGED {
		@Override
		public Flags getFlag() {
			return new Flags(Flags.Flag.FLAGGED);
		}
	},
	/**
	 * 最近的
	 */
	RECENT {
		@Override
		public Flags getFlag() {
			return new Flags(Flags.Flag.RECENT);
		}
	},
	/**
	 * 已读
	 */
	SEEN {
		@Override
		public Flags getFlag() {
			return new Flags(Flags.Flag.SEEN);
		}
	};
	public Flags getFlag() {
		return null;
	}
}
