package com.neosoft.service;

import com.neosoft.model.Holiday;
import com.neosoft.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    HolidayRepository holidayRepository;
    @Override
    public Holiday addHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    @Override
    public Holiday updateHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    @Override
    public Holiday getHolidayById(Long id) {
        return holidayRepository.findById(id).get();
    }

    @Override
    public void deleteHoliday(Long id) {
    holidayRepository.deleteById(id);
    }

    @Override
    public List<Holiday> allHoliday() {
        return holidayRepository.findAll();
    }
}
