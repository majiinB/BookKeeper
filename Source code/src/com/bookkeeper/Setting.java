package com.bookkeeper;

public class Setting {
	private int setting_id;
	private int borrow_lim;
	private int reserve_lim;
	private int borrow_duration_lim;
	private int penalty_lim;
	
	public Setting(int setting_id, int borrow_lim, int reserve_lim, int borrow_duration_lim, int penalty_lim) {
		this.setting_id = setting_id;
		this.borrow_lim = borrow_lim;
		this.reserve_lim = reserve_lim;
		this.borrow_duration_lim = borrow_duration_lim;
		this.penalty_lim = penalty_lim;
	}

	public int getSetting_id() {
		return setting_id;
	}

	public void setSetting_id(int setting_id) {
		this.setting_id = setting_id;
	}

	public int getReserve_lim() {
		return reserve_lim;
	}

	public void setReserve_lim(int reserve_lim) {
		this.reserve_lim = reserve_lim;
	}

	public int getBorrow_lim() {
		return borrow_lim;
	}

	public void setBorrow_lim(int borrow_lim) {
		this.borrow_lim = borrow_lim;
	}

	public int getBorrow_duration_lim() {
		return borrow_duration_lim;
	}

	public void setBorrow_duration_lim(int borrow_duration_lim) {
		this.borrow_duration_lim = borrow_duration_lim;
	}

	public int getPenalty_lim() {
		return penalty_lim;
	}

	public void setPenalty_lim(int penalty_lim) {
		this.penalty_lim = penalty_lim;
	}

}
