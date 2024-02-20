package com.kos.testlegacy.os.kart.dao;

import java.util.ArrayList;
import java.util.List;

import com.kos.testlegacy.os.kart.vo.OsBuyVO;
import com.kos.testlegacy.os.kart.vo.OsKartVO;

public interface OsKartDAO {

	public List<OsKartVO> osKartSelectAll(OsKartVO okvo);
	public int osKartDelete(OsKartVO kcvo);
	public int osKartDeleteArray(ArrayList<OsKartVO> aList);
	public int osKartInsert(OsKartVO okvo);
	public int osKartUpdate(OsBuyVO obo);
}
