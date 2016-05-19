package com.yc.bim.main;

import com.yc.bim.exception.BIMException;

public interface MeasureFilter<T> {

	boolean doFilter(T t) throws BIMException;
}
