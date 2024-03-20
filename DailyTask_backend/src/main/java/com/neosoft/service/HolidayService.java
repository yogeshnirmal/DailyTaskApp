package com.neosoft.service;

import com.neosoft.model.Holiday;

import java.util.List;

public interface HolidayService {
    public Holiday addHoliday(Holiday holiday);
    public Holiday updateHoliday(Holiday holiday);
    public Holiday getHolidayById(Long id);
    public void deleteHoliday(Long id);
    public List<Holiday> allHoliday();
}
